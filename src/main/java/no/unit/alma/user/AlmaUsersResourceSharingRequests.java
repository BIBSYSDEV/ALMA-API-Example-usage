package no.unit.alma.user;

import no.bibsys.alma.rest.user_resource_sharing_request.UserResourceSharingRequest;
import no.unit.alma.commons.AlmaContext;

public interface AlmaUsersResourceSharingRequests extends AlmaContext {
    UserResourceSharingRequest postUserResourceSharingRequest(UserResourceSharingRequest userResourceSharingRequest,
            String userIdentifier);

    UserResourceSharingRequest getUserResourceSharingRequest(String userIdentifier, String requestId);
}
