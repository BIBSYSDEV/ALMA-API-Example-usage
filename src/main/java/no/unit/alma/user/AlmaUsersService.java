package no.unit.alma.user;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import no.bibsys.alma.rest.item_loan.ItemLoans;
import no.bibsys.alma.rest.user.User;
import no.bibsys.alma.rest.user.Users;
import no.bibsys.alma.rest.user_request.UserRequest;
import no.bibsys.alma.rest.user_request.UserRequests;
import no.bibsys.alma.rest.user_resource_sharing_request.UserResourceSharingRequest;
import no.unit.alma.commons.AlmaClient;

public class AlmaUsersService
        implements AlmaUsers, AlmaUsersLoans, AlmaUsersRequests, AlmaUsersResourceSharingRequests {

    private final WebTarget usersTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    public AlmaUsersService(AlmaClient almaClient) {
        this.usersTarget = almaClient.getWebTarget().path("users");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    @Override
    public User getUser(final String userIdentifier) {
        return getUser(userIdentifier, null, null);
    }

    @Override
    public User getUser(final String userIdentifier, final String view, final String expand) {
        WebTarget userTarget =
                usersTarget
                        .path(userIdentifier);

        if (StringUtils.isNotEmpty(view)) {
            userTarget = userTarget.queryParam("view", view);
        }

        if (StringUtils.isNotEmpty(expand)) {
            userTarget = userTarget.queryParam("expand", expand);
        }

        return userTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(User.class);
    }

    @Override
    public User postUser(final User user) {
        return usersTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(user))
                .invoke(User.class);
    }

    @Override
    public User updateUser(String userIdentifier, final User user) {
        return usersTarget
                .path(userIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(user))
                .invoke(User.class);
    }

    @Override
    public void deleteUser(String userIdentifier) {
        usersTarget
                .path(userIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
    }

    @Override
    public Users retrieveUsers(int limit, int offset) {
        return retrieveUsers(limit, offset, "last_name,first_name,primary_id");
    }

    @Override
    public Users retrieveUsers(int limit, int offset, String orderBy) {
        return usersTarget
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .queryParam("order_by", orderBy)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Users.class);
    }

    @Override
    public ItemLoans retrieveUserItemLoans(String userIdentifier, int limit, int offset) {
        return usersTarget
                .path(userIdentifier)
                .path("loans")
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(ItemLoans.class);
    }

    @Override
    public ItemLoans retrieveAllUserItemLoans(String userIdentifier) {
        int offset = 0;
        int limit = 100;
        ItemLoans retrievedLoans = retrieveUserItemLoans(userIdentifier, limit, offset);
        final Integer recordCount = retrievedLoans.getTotalRecordCount();
        while (recordCount > (offset += limit)) {
            ItemLoans retrievedMoreLoans = retrieveUserItemLoans(userIdentifier, limit, offset);
            retrievedLoans.getItemLoan().addAll(retrievedMoreLoans.getItemLoan());
        }
        return retrievedLoans;
    }

    @Override
    public UserRequest postUserRequest(String userIdentifer, String recordIdentifer, UserRequest userRequest) {
        return usersTarget
                .path(userIdentifer)
                .path("requests")
                .queryParam("mms_id", recordIdentifer)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(userRequest))
                .invoke(UserRequest.class);
    }

    @Override
    public UserRequest postUserRequestItem(String userIdentifer, String itemId, UserRequest userRequest) {
        return usersTarget
                .path(userIdentifer)
                .path("requests")
                .queryParam("item_pid", itemId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(userRequest))
                .invoke(UserRequest.class);
    }

    @Override
    public void deleteUserRequest(String userIdentifer, String requestId) {
        usersTarget
                .path(userIdentifer)
                .path("requests")
                .path(requestId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
    }

    @Override
    public UserRequests getUserRequests(String userIdentifer) {
        return usersTarget
                .path(userIdentifer)
                .path("requests")
                .queryParam("limit", 100)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(UserRequests.class);
    }

    @Override
    public UserRequest getUserRequest(String userIdentifer, String requestId) {
        return usersTarget
                .path(userIdentifer)
                .path("requests")
                .path(requestId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(UserRequest.class);
    }

    @Override
    public UserResourceSharingRequest postUserResourceSharingRequest(
            UserResourceSharingRequest userResourceSharingRequest, String userIdentifier) {
        return usersTarget
                .path(userIdentifier)
                .path("resource_sharing_requests")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(userResourceSharingRequest))
                .invoke(UserResourceSharingRequest.class);
    }

    @Override
    public UserResourceSharingRequest getUserResourceSharingRequest(String userIdentifier, String requestId) {
        return usersTarget
                .path(userIdentifier)
                .path("resource_sharing_requests")
                .path(requestId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(UserResourceSharingRequest.class);
    }

    public String getContext() {
        return context;
    }

    public String getContextValue() {
        return contextValue;
    }

    public String getAlmaStage() {
        return almaStage;
    }
}
