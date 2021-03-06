package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.holding.Holding;
import no.unit.alma.generated.holdings.Holdings;
import no.unit.alma.generated.items.BibData;
import no.unit.alma.generated.items.HoldingData;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.ItemData;
import no.unit.alma.generated.items.Items;

@ExtendWith(MockitoExtension.class)
class AlmaHoldingsClientTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";

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
                new AlmaHoldingsService(mockAlmaApiClient);

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
                new AlmaHoldingsService(mockAlmaApiClient);

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
        AlmaHoldingsService almaHoldingsService = new AlmaHoldingsService(mockAlmaApiClient);

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
                new AlmaHoldingsService(mockAlmaApiClient);

        long limit = 10;
        long offset = 0;
        Items resultItems = almaHoldingsService.getItems(TEST_MMS_ID, TEST_HOLDING_ID, limit, offset);
        assertEquals(TOTAL_RECORD_COUNT, resultItems.getTotalRecordCount());
        long noLimit = -1;
        resultItems = almaHoldingsService.getItems(TEST_MMS_ID, TEST_HOLDING_ID, noLimit, offset);
        assertEquals(TOTAL_RECORD_COUNT, resultItems.getTotalRecordCount());
    }

    @Test
    void testGetAllItems() {
        int totalRecordCount = 240;
        List<Items> responses = new CopyOnWriteArrayList<Items>();
        responses.add(createTestItems(TEST_MMS_ID, TEST_HOLDING_ID, 100, totalRecordCount));
        responses.add(createTestItems(TEST_MMS_ID, TEST_HOLDING_ID, 100, totalRecordCount));
        responses.add(createTestItems(TEST_MMS_ID, TEST_HOLDING_ID, 40, totalRecordCount));
        responses.add(createTestItems(TEST_MMS_ID, TEST_HOLDING_ID, 40, 40));

        when(holdingsWebTarget.path(any())).thenReturn(holdingsWebTarget);
        when(holdingsWebTarget.queryParam(anyString(), any())).thenReturn(holdingsWebTarget);
        when(holdingsWebTarget.request()).thenReturn(holdingsBuilder);
        when(holdingsBuilder.accept(anyString())).thenReturn(holdingsBuilder);
        when(holdingsBuilder.buildGet()).thenReturn(holdingsInvocation);
        when(holdingsInvocation.invoke(Items.class)).thenReturn(responses.get(0), responses.get(1), responses.get(2),
                responses.get(3));

        AlmaHoldingsService almaHoldingsService = new AlmaHoldingsService(mockAlmaApiClient);
        Items allItems = almaHoldingsService.getAllItems(TEST_MMS_ID, TEST_HOLDING_ID);
        assertEquals(totalRecordCount, allItems.getTotalRecordCount());
        assertEquals(totalRecordCount, allItems.getItems().size());
        allItems = almaHoldingsService.getAllItems(TEST_MMS_ID, TEST_HOLDING_ID);
        assertEquals(40, allItems.getTotalRecordCount());
    }

    private Items createTestItems(String mmsId, String holdingsId, int number, int total) {
        List<Item> itemList = new CopyOnWriteArrayList<Item>();

        for (int i = 0; i < number; i++) {
            Item newItem = new Item();
            BibData bibData = new BibData();
            bibData.setMmsId(mmsId);
            newItem.setBibData(bibData);

            HoldingData holdingData = new HoldingData();
            holdingData.setHoldingId(holdingsId);
            newItem.setHoldingData(holdingData);

            ItemData itemData = new ItemData();
            itemData.setPid(Long.toString(System.currentTimeMillis()));
            newItem.setItemData(itemData);

            itemList.add(newItem);
        }

        Items items = new Items();
        items.getItems().addAll(itemList);
        items.setTotalRecordCount(total);

        return items;
    }

    @Test
    void testGetContext() {
        AlmaHoldingsService almaBibsService =
                new AlmaHoldingsService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaBibsService.getContext());
    }

    @Test
    void testGetContextValue() {
        AlmaHoldingsService almaBibsService =
                new AlmaHoldingsService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaBibsService.getContextValue());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(holdingsWebTarget);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }
}
