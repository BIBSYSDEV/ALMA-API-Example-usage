package no.unit.alma.user;

import no.bibsys.alma.rest.user_resource_sharing_request.UserResourceSharingRequest;

public interface AlmaUsersResourceSharingRequests {
    UserResourceSharingRequest postUserResourceSharingRequest(UserResourceSharingRequest userResourceSharingRequest,
            String userIdentifier);

    UserResourceSharingRequest getUserResourceSharingRequest(String userIdentifier, String requestId);
}
