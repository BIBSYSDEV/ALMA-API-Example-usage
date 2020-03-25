package no.unit.alma.user;

import no.unit.alma.generated.userrequests.UserRequest;
import no.unit.alma.generated.userrequests.UserRequests;

public interface AlmaUsersRequests {
    UserRequest postUserRequest(String userIdentifer, String recordIdentifer, UserRequest userRequest);

    UserRequest postUserRequestItem(String userIdentifer, String itemId, UserRequest userRequest);

    void deleteUserRequest(String userIdentifer, String requestId);

    UserRequests getUserRequests(String userIdentifer);

    UserRequest getUserRequest(String userIdentifer, String requestId);
}
