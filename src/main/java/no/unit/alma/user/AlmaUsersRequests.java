package no.unit.alma.user;

import no.bibsys.alma.rest.user_request.UserRequest;
import no.bibsys.alma.rest.user_request.UserRequests;

public interface AlmaUsersRequests {
    UserRequest postUserRequest(String userIdentifer, String recordIdentifer, UserRequest userRequest);

    UserRequest postUserRequestItem(String userIdentifer, String itemId, UserRequest userRequest);

    void deleteUserRequest(String userIdentifer, String requestId);

    UserRequests getUserRequests(String userIdentifer);

    UserRequest getUserRequest(String userIdentifer, String requestId);
}
