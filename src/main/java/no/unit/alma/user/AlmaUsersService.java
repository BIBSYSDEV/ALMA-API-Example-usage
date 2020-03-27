package no.unit.alma.user;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.itemloans.ItemLoans;
import no.unit.alma.generated.userrequests.UserRequest;
import no.unit.alma.generated.userrequests.UserRequests;
import no.unit.alma.generated.userrequests.UserResourceSharingRequest;
import no.unit.alma.generated.users.User;
import no.unit.alma.generated.users.Users;

public class AlmaUsersService
        implements AlmaUsers, AlmaUsersLoans, AlmaUsersRequests, AlmaUsersResourceSharingRequests {

    private static final String RESOURCE_SHARING_REQUESTS = "resource_sharing_requests";
    private static final String ORDER_BY = "order_by";
    private static final String OFFSET = "offset";
    private static final String LIMIT = "limit";
    private static final String LOANS = "loans";
    private static final String ITEM_PID = "item_pid";
    private static final String MMS_ID = "mms_id";
    private static final String REQUESTS = "requests";

    private final transient WebTarget usersTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    /**
     * Create new AlmaUsersService.
     * 
     * @param almaClient almaClient
     */
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
                .queryParam(LIMIT, limit)
                .queryParam(OFFSET, offset)
                .queryParam(ORDER_BY, orderBy)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Users.class);
    }

    @Override
    public ItemLoans retrieveUserItemLoans(String userIdentifier, int limit, int offset) {
        return usersTarget
                .path(userIdentifier)
                .path(LOANS)
                .queryParam(LIMIT, limit)
                .queryParam(OFFSET, offset)
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
        boolean finished = recordCount <= (offset += limit);
        while (!finished) {
            ItemLoans retrievedMoreLoans = retrieveUserItemLoans(userIdentifier, limit, offset);
            retrievedLoans.getItemLoan().addAll(retrievedMoreLoans.getItemLoan());
            finished = recordCount <= (offset += limit);
        }
        return retrievedLoans;
    }

    @Override
    public UserRequest postUserRequest(String userIdentifer, String recordIdentifer, UserRequest userRequest) {
        return usersTarget
                .path(userIdentifer)
                .path(REQUESTS)
                .queryParam(MMS_ID, recordIdentifer)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(userRequest))
                .invoke(UserRequest.class);
    }

    @Override
    public UserRequest postUserRequestItem(String userIdentifer, String itemId, UserRequest userRequest) {
        return usersTarget
                .path(userIdentifer)
                .path(REQUESTS)
                .queryParam(ITEM_PID, itemId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(userRequest))
                .invoke(UserRequest.class);
    }

    @Override
    public void deleteUserRequest(String userIdentifer, String requestId) {
        usersTarget
                .path(userIdentifer)
                .path(REQUESTS)
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
                .path(REQUESTS)
                .queryParam(LIMIT, 100)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(UserRequests.class);
    }

    @Override
    public UserRequest getUserRequest(String userIdentifer, String requestId) {
        return usersTarget
                .path(userIdentifer)
                .path(REQUESTS)
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
                .path(RESOURCE_SHARING_REQUESTS)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(userResourceSharingRequest))
                .invoke(UserResourceSharingRequest.class);
    }

    @Override
    public UserResourceSharingRequest getUserResourceSharingRequest(String userIdentifier, String requestId) {
        return usersTarget
                .path(userIdentifier)
                .path(RESOURCE_SHARING_REQUESTS)
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
