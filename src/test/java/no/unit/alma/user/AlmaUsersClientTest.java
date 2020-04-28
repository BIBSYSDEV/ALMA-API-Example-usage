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
import no.unit.alma.generated.users.User;
import no.unit.alma.generated.users.Users;

@ExtendWith(MockitoExtension.class)
class AlmaUsersClientTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String TEST_NAME = "Test Name";
    private static final String TEST_USER_ID = "user id";
    private static final String TEST_VIEW = "view";
    private static final String TEST_EXPAND = "expand";
    private static final Long TOTAL_RECORD_COUNT = 5L;

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
    void testGetUser() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        User testUser = new User();
        testUser.setFullName(TEST_NAME);
        when(invocation.invoke(User.class)).thenReturn(testUser);

        AlmaUsersService almaUsersClient = new AlmaUsersService(mockAlmaApiClient);
        User resultUser = almaUsersClient.getUser(TEST_USER_ID);
        assertEquals(TEST_NAME, resultUser.getFullName());

        resultUser = almaUsersClient.getUser(TEST_USER_ID, TEST_VIEW, TEST_EXPAND);
        assertEquals(TEST_NAME, resultUser.getFullName());
    }

    @Test
    void testPostUser() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(any())).thenReturn(invocation);

        User testUser = new User();
        testUser.setFullName(TEST_NAME);
        when(invocation.invoke(User.class)).thenReturn(testUser);

        AlmaUsersService almaUsersClient = new AlmaUsersService(mockAlmaApiClient);
        User resultUser = almaUsersClient.postUser(testUser);
        assertEquals(TEST_NAME, resultUser.getFullName());
    }

    @Test
    void testUpdateUser() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(any())).thenReturn(invocation);

        User testUser = new User();
        testUser.setFullName(TEST_NAME);
        when(invocation.invoke(User.class)).thenReturn(testUser);

        AlmaUsersService almaUsersClient = new AlmaUsersService(mockAlmaApiClient);
        User resultUser = almaUsersClient.updateUser(TEST_USER_ID, testUser);
        assertEquals(TEST_NAME, resultUser.getFullName());
    }

    @Test
    void testDeleteUser() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildDelete()).thenReturn(invocation);
        when(invocation.invoke()).thenReturn(response);

        AlmaUsersService almaUsersClient = new AlmaUsersService(mockAlmaApiClient);
        almaUsersClient.deleteUser(TEST_USER_ID);
    }

    @Test
    void testretrieveUsers() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        Users testUsers = new Users();
        testUsers.setTotalRecordCount(TOTAL_RECORD_COUNT);
        when(invocation.invoke(Users.class)).thenReturn(testUsers);

        int limit = 10;
        int offset = 0;
        String testOrderby = "order by";
        AlmaUsersService almaUsersClient = new AlmaUsersService(mockAlmaApiClient);
        Users resultUsers = almaUsersClient.retrieveUsers(limit, offset);
        assertEquals(TOTAL_RECORD_COUNT, resultUsers.getTotalRecordCount());

        resultUsers = almaUsersClient.retrieveUsers(limit, offset, testOrderby);
        assertEquals(TOTAL_RECORD_COUNT, resultUsers.getTotalRecordCount());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}
