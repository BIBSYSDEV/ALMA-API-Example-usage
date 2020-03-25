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

import no.bibsys.alma.rest.item_loan.ItemLoans;
import no.unit.alma.commons.AlmaClient;

@ExtendWith(MockitoExtension.class)
class AlmaUsersLoansTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";
    private static final Integer TOTAL_RECORD_COUNT = 150;
    private static final String TEST_USER_ID = "user id";
    private static final int LIMIT = 10;
    private static final int OFFSET = 0;

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
    void testRetrieveUserItemLoans() {
        when(webTarget.path(anyString())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        ItemLoans testItemLoans = new ItemLoans();
        testItemLoans.setTotalRecordCount(TOTAL_RECORD_COUNT);
        when(invocation.invoke(ItemLoans.class)).thenReturn(testItemLoans);

        AlmaUsersLoans almaUsersLoans = new AlmaUsersService(mockAlmaApiClient);
        ItemLoans resultItemLoans = almaUsersLoans.retrieveUserItemLoans(TEST_USER_ID, LIMIT, OFFSET);
        assertEquals(TOTAL_RECORD_COUNT, resultItemLoans.getTotalRecordCount());

        resultItemLoans = almaUsersLoans.retrieveAllUserItemLoans(TEST_USER_ID);
        assertEquals(TOTAL_RECORD_COUNT, resultItemLoans.getTotalRecordCount());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}
