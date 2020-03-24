package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.bibsys.alma.rest.holding.Holding;
import no.bibsys.alma.rest.holdings.Holdings;
import no.bibsys.alma.rest.items.Items;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

@ExtendWith(MockitoExtension.class)
class AlmaHoldingsClientTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final AlmaStage STAGE = AlmaStage.SANDBOX2;

    private static final Integer TOTAL_RECORD_COUNT = 1;
    private static final String TEST_MMS_ID = "123456";
    private static final String TEST_HOLDING_ID = "345678";
    private static final String TEST_ORIGINATING_SYSTEM = "originating system";

    @Mock
    private AlmaClient mockAlmaApiClient;

    @Mock
    private WebTarget holdingsWebTarget;

    @Mock
    private Builder holdingsBuilder;

    @Mock
    private Invocation holdingsInvocation;

    @BeforeEach
    void init() {
        mockAlmaApi();
    }

    @Test
    void testGetHoldings() {
        when(holdingsWebTarget.path(any())).thenReturn(holdingsWebTarget);
        when(holdingsWebTarget.request()).thenReturn(holdingsBuilder);
        when(holdingsBuilder.accept(anyString())).thenReturn(holdingsBuilder);
        when(holdingsBuilder.buildGet()).thenReturn(holdingsInvocation);
        Holdings tempHoldings = new Holdings();
        tempHoldings.setTotalRecordCount(TOTAL_RECORD_COUNT);
        when(holdingsInvocation.invoke((Class<Object>) any())).thenReturn(tempHoldings);
        AlmaHoldingsService almaHoldingsService =
                new AlmaHoldingsServiceImplementation(mockAlmaApiClient);

        Holdings resultHoldings = almaHoldingsService.getHoldings(TEST_MMS_ID);
        assertEquals(TOTAL_RECORD_COUNT, resultHoldings.getTotalRecordCount());

    }

    @Test
    void testGetHolding() {
        when(holdingsWebTarget.path(any())).thenReturn(holdingsWebTarget);
        when(holdingsWebTarget.request()).thenReturn(holdingsBuilder);
        when(holdingsBuilder.accept(anyString())).thenReturn(holdingsBuilder);
        when(holdingsBuilder.buildGet()).thenReturn(holdingsInvocation);
        Holding tempHolding = new Holding();
        tempHolding.setOriginatingSystem(TEST_ORIGINATING_SYSTEM);
        when(holdingsInvocation.invoke((Class<Object>) any())).thenReturn(tempHolding);
        AlmaHoldingsService almaHoldingsService =
                new AlmaHoldingsServiceImplementation(mockAlmaApiClient);

        Holding resultHolding = almaHoldingsService.getHolding(TEST_MMS_ID, TEST_HOLDING_ID);
        assertEquals(TEST_ORIGINATING_SYSTEM, resultHolding.getOriginatingSystem());
    }

    @Test
    void testUpdateHolding() {
        when(holdingsWebTarget.path(any())).thenReturn(holdingsWebTarget);
        when(holdingsWebTarget.request()).thenReturn(holdingsBuilder);
        when(holdingsBuilder.accept(anyString())).thenReturn(holdingsBuilder);

        Holding tempHolding = new Holding();
        tempHolding.setOriginatingSystem(TEST_ORIGINATING_SYSTEM);
        when(holdingsBuilder.buildPut(Entity.xml(tempHolding))).thenReturn(holdingsInvocation);
        when(holdingsInvocation.invoke((Class<Object>) any())).thenReturn(tempHolding);
        AlmaHoldingsService almaHoldingsService =
                new AlmaHoldingsServiceImplementation(mockAlmaApiClient);

        Holding resultHolding = almaHoldingsService.updateHolding(TEST_MMS_ID, tempHolding);
        assertEquals(TEST_ORIGINATING_SYSTEM, resultHolding.getOriginatingSystem());
    }

    @Test
    void testGetItems() {
        when(holdingsWebTarget.path(any())).thenReturn(holdingsWebTarget);
        when(holdingsWebTarget.queryParam(anyString(), any())).thenReturn(holdingsWebTarget);
        when(holdingsWebTarget.request()).thenReturn(holdingsBuilder);
        when(holdingsBuilder.accept(anyString())).thenReturn(holdingsBuilder);
        when(holdingsBuilder.buildGet()).thenReturn(holdingsInvocation);

        Items tempItems = new Items();
        tempItems.setTotalRecordCount(TOTAL_RECORD_COUNT);

        when(holdingsInvocation.invoke((Class<Object>) any())).thenReturn(tempItems);

        AlmaHoldingsService almaHoldingsService =
                new AlmaHoldingsServiceImplementation(mockAlmaApiClient);

        Items resultItems = almaHoldingsService.getItems(TEST_MMS_ID, TEST_HOLDING_ID, 10, 0);
        assertEquals(TOTAL_RECORD_COUNT, resultItems.getTotalRecordCount());
    }

    @Test
    void testGetAlmaStage() {
        AlmaHoldingsService almaBibsService =
                new AlmaHoldingsServiceImplementation(mockAlmaApiClient);
        assertEquals(STAGE.getVaultAlmaStageName(), almaBibsService
                .getAlmaStage().getVaultAlmaStageName());
    }

    @Test
    void testGetContext() {
        AlmaHoldingsService almaBibsService =
                new AlmaHoldingsServiceImplementation(mockAlmaApiClient);
        assertEquals(CONTEXT, almaBibsService.getContext());
    }

    @Test
    void testGetContextValue() {
        AlmaHoldingsService almaBibsService =
                new AlmaHoldingsServiceImplementation(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaBibsService.getContextValue());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(holdingsWebTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}
