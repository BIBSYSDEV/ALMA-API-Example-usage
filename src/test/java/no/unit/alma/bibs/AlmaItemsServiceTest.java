package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.bibsys.alma.rest.items.Item;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

@ExtendWith(MockitoExtension.class)
class AlmaItemsServiceTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final AlmaStage STAGE = AlmaStage.SANDBOX2;
    private static final Integer TOTAL_RECORD_COUNT = 1;
    private static final String TEST_MMS_ID = "123456";
    private static final String TEST_HOLDINGS_ID = "345678";
    private static final String TEST_ITEMS_ID = "567890";
    private static final String TEST_LINK = "link";
    private static final String TEST_BARCODE = null;

    @Mock
    private AlmaClient mockAlmaApiClient;

    @Mock
    private WebTarget itemsWebTarget;

    @Mock
    private Builder itemsBuilder;

    @Mock
    private Invocation itemsInvocation;

    @BeforeEach
    void init() {
        mockAlmaApi();
    }

    @Test
    void testGetItemId() {
        when(itemsWebTarget.path(any())).thenReturn(itemsWebTarget);
        when(itemsWebTarget.request()).thenReturn(itemsBuilder);
        when(itemsBuilder.accept(anyString())).thenReturn(itemsBuilder);
        when(itemsBuilder.buildGet()).thenReturn(itemsInvocation);

        Item tempItem = new Item();
        tempItem.setLink(TEST_LINK);

        when(itemsInvocation.invoke((Class<Object>) any())).thenReturn(tempItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsServiceImplementation(mockAlmaApiClient);

        Item resultItem = almaItemsService.getItem(TEST_MMS_ID, TEST_HOLDINGS_ID, TEST_ITEMS_ID);
        assertEquals(TEST_LINK, resultItem.getLink());

    }

    @Test
    void getItemBarcode() {
        when(itemsWebTarget.path(any())).thenReturn(itemsWebTarget);
        when(itemsWebTarget.queryParam(anyString(), any())).thenReturn(itemsWebTarget);
        when(itemsWebTarget.request()).thenReturn(itemsBuilder);
        when(itemsBuilder.accept(anyString())).thenReturn(itemsBuilder);
        when(itemsBuilder.buildGet()).thenReturn(itemsInvocation);

        Item tempItem = new Item();
        tempItem.setLink(TEST_LINK);

        when(itemsInvocation.invoke((Class<Object>) any())).thenReturn(tempItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsServiceImplementation(mockAlmaApiClient);

        Item resultItem = almaItemsService.getItem(TEST_BARCODE);
        assertEquals(TEST_LINK, resultItem.getLink());

    }

    @Test
    void testCreateItem() {
        when(itemsWebTarget.path(any())).thenReturn(itemsWebTarget);
        when(itemsWebTarget.request()).thenReturn(itemsBuilder);
        when(itemsBuilder.accept(anyString())).thenReturn(itemsBuilder);

        Item tempItem = new Item();
        tempItem.setLink(TEST_LINK);
        when(itemsBuilder.buildPost(any())).thenReturn(itemsInvocation);

        when(itemsInvocation.invoke((Class<Object>) any())).thenReturn(tempItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsServiceImplementation(mockAlmaApiClient);

        Item resultItem = almaItemsService.createItem(TEST_MMS_ID, TEST_HOLDINGS_ID);
        assertEquals(TEST_LINK, resultItem.getLink());

    }
//
//    Item updateItem(Item item);
//
//    ItemLoan createUserLoanOnItem(String barcode, String user_Id, String library, String circulationDesk);
//
//    ItemLoan createUserLoanOnItem(String barcode, String user_Id, String library, String circulationDesk, float fine,
//            LoanStatus loanStatus);
//
//    ItemLoan updateUserLoanAndChangeDueDate(String userId, String loanId, Calendar dueDate);
//
//    UserRequests getRequestsFromItem(Item item, boolean deleted);
//
//    UserRequests getRequestsFromItem(String mms_id, String holding_id, String item_pid, boolean deleted);
//
//    UserRequests getRequestsFromItem(String barcode, boolean deleted);
//
//    UserRequest createPatronRequest(String barcode, String pickupLocationLibrary, String message, String ltId);
//
//    UserRequest createPatronRequest(Item item, String pickupLocationLibrary, String message, String userId);
//
//    UserRequest createPatronRequest(String mmsId, String userId, UserRequest newRequest);
//
//    UserRequest createDigitizationRequest(String barcode, UserRequest.TargetDestination targetDestination,
//            String message);
//
//    UserRequest createDigitizationRequest(Item item, UserRequest.TargetDestination targetDestination, String message);
//
//    UserRequest createDigitizationRequest(Item item, UserRequest.TargetDestination targetDestination, String message,
//            String userId);
//
//    void deleteItem(String mmsId, String holdingsId, String itemId, boolean override, HoldingsRecord holdingsRecord);
//
//    void deleteItem(String barcode, boolean override, HoldingsRecord holdingsRecord);
//
//    void deleteRequest(String barcode, String requestId);
//
//    void deleteRequest(String barcode, String requestId, String note);
//
//    UserRequest updateCommentOnRequest(String barcode, String requestId, String comment,
//            boolean appendToExistingComment);
//
//    UserRequest actionOnRequest(String barcode, String action, String requestId, boolean releaseItem);
//
//    Item scanInItem(String barcode, String requestId, String department, String circDesk, String library);
//
//    Item scanInItem(String barcode, String circDesk, String library);
//
//    Representation updateRemoteDigitalItem(String mmsId, String representationId, Representation digitalItem);
//
//    Item updateItemDescription(Item item);

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
                .thenReturn(itemsWebTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }
}
