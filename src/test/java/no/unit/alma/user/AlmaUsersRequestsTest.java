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

import no.bibsys.alma.rest.user_request.UserRequest;
import no.bibsys.alma.rest.user_request.UserRequests;
import no.unit.alma.commons.AlmaClient;

@ExtendWith(MockitoExtension.class)
class AlmaUsersRequestsTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";
    private static final Integer TOTAL_RECORD_COUNT = 150;
    private static final String TEST_USER_ID = "user id";
    private static final int LIMIT = 10;
    private static final int OFFSET = 0;
    private static final String TEST_AUTHOR = "author";
    private static final String TEST_REQUEST_ID = "request id";
    private static final String TEST_ITEM_ID = "item id";

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
    void testGetUserRequest() {
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        UserRequest testUserRequest = new UserRequest();
        testUserRequest.setAuthor(TEST_AUTHOR);
        when(invocation.invoke(UserRequest.class)).thenReturn(testUserRequest);

        AlmaUsersRequests almaUsersRequestService = new AlmaUsersService(mockAlmaApiClient);
        UserRequest resultUserRequest = almaUsersRequestService.getUserRequest(TEST_USER_ID, TEST_REQUEST_ID);
        assertEquals(TEST_AUTHOR, resultUserRequest.getAuthor());

    }

    @Test
    void testGetUserRequests() {
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        UserRequests testUserRequests = new UserRequests();
        testUserRequests.setTotalRecordCount(TOTAL_RECORD_COUNT);
        when(invocation.invoke(UserRequests.class)).thenReturn(testUserRequests);

        AlmaUsersRequests almaUsersRequestService = new AlmaUsersService(mockAlmaApiClient);
        UserRequests resultUserRequests = almaUsersRequestService.getUserRequests(TEST_USER_ID);
        assertEquals(TOTAL_RECORD_COUNT, resultUserRequests.getTotalRecordCount());
    }

    @Test
    void testDeleteUserRequest() {
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildDelete()).thenReturn(invocation);
        when(invocation.invoke()).thenReturn(response);

        AlmaUsersRequests almaUsersRequestService = new AlmaUsersService(mockAlmaApiClient);
        almaUsersRequestService.deleteUserRequest(TEST_USER_ID, TEST_REQUEST_ID);
    }

    @Test
    void testPostUserRequest() {
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(any())).thenReturn(invocation);

        UserRequest testUserRequest = new UserRequest();
        testUserRequest.setAuthor(TEST_AUTHOR);
        when(invocation.invoke(UserRequest.class)).thenReturn(testUserRequest);

        AlmaUsersRequests almaUsersRequestService = new AlmaUsersService(mockAlmaApiClient);
        UserRequest resultUserRequest =
                almaUsersRequestService.postUserRequest(TEST_USER_ID, TEST_REQUEST_ID, testUserRequest);
        assertEquals(TEST_AUTHOR, resultUserRequest.getAuthor());

        resultUserRequest =
                almaUsersRequestService.postUserRequestItem(TEST_USER_ID, TEST_ITEM_ID, testUserRequest);
        assertEquals(TEST_AUTHOR, resultUserRequest.getAuthor());
    }

    // UserRequest postUserRequest(String userIdentifer, String recordIdentifer,
    // UserRequest userRequest);
    //
    // UserRequest postUserRequestItem(String userIdentifer, String itemId,
    // UserRequest userRequest);
    //

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }
}
