package no.unit.alma.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.userrequests.UserResourceSharingRequest;

@ExtendWith(MockitoExtension.class)
class AlmaUsersResourceSharingRequestsTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String TEST_USER_ID = "user id";
    private static final String TEST_BARCODE = "barcode";
    private static final String TEST_REQUEST_ID = "request id";

    @Mock
    AlmaClient mockAlmaApiClient;

    @Mock
    WebTarget webTarget;

    @Mock
    Builder builder;

    @Mock
    Invocation invocation;

    @Mock
    Response response;

    @BeforeEach
    void init() {
        mockAlmaApi();
    }

    @Test
    void testGetUserResourceSharingRequest() {
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        UserResourceSharingRequest testUserResourceSharingRequest = new UserResourceSharingRequest();
        testUserResourceSharingRequest.setBarcode(TEST_BARCODE);
        when(invocation.invoke(UserResourceSharingRequest.class)).thenReturn(testUserResourceSharingRequest);

        AlmaUsersResourceSharingRequests almaUsersResourceSharingRequestsService =
                new AlmaUsersService(mockAlmaApiClient);
        UserResourceSharingRequest resultUserResourceSharingRequest =
                almaUsersResourceSharingRequestsService.getUserResourceSharingRequest(TEST_USER_ID, TEST_REQUEST_ID);
        assertEquals(TEST_BARCODE, resultUserResourceSharingRequest.getBarcode());
    }

    @Test
    void testPosUserResourceSharingRequest() {
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(any())).thenReturn(invocation);

        UserResourceSharingRequest testUserResourceSharingRequest = new UserResourceSharingRequest();
        testUserResourceSharingRequest.setBarcode(TEST_BARCODE);
        when(invocation.invoke(UserResourceSharingRequest.class)).thenReturn(testUserResourceSharingRequest);

        AlmaUsersResourceSharingRequests almaUsersResourceSharingRequestsService =
                new AlmaUsersService(mockAlmaApiClient);
        UserResourceSharingRequest resultUserResourceSharingRequest =
                almaUsersResourceSharingRequestsService.postUserResourceSharingRequest(testUserResourceSharingRequest,
                        TEST_USER_ID);
        assertEquals(TEST_BARCODE, resultUserResourceSharingRequest.getBarcode());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}
