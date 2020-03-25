package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.bibsys.alma.rest.item_loan.ItemLoan;
import no.bibsys.alma.rest.item_loan.LoanStatus;
import no.bibsys.alma.rest.items.BibData;
import no.bibsys.alma.rest.items.HoldingData;
import no.bibsys.alma.rest.items.Item;
import no.bibsys.alma.rest.items.ItemData;
import no.bibsys.alma.rest.items.ItemData.PhysicalMaterialType;
import no.bibsys.alma.rest.representations.Representation;
import no.bibsys.alma.rest.user_request.UserRequest;
import no.bibsys.alma.rest.user_request.UserRequest.TargetDestination;
import no.bibsys.alma.rest.user_request.UserRequests;
import no.unit.alma.commons.AlmaClient;

@ExtendWith(MockitoExtension.class)
class AlmaItemsClientTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";
    private static final Integer TOTAL_RECORD_COUNT = 1;
    private static final String TEST_MMS_ID = "mms id";
    private static final String TEST_HOLDINGS_ID = "holdings id";
    private static final String TEST_ITEMS_ID = "items id";
    private static final String TEST_LINK = "link";
    private static final String TEST_BARCODE = "barcode";
    private static final String TEST_USER_ID = "user id";
    private static final String TEST_LIBRARY = "library";
    private static final String TEST_CIRCULATION_DESK = "circulation desk";
    private static final float TEST_FINE = 0;
    private static final LoanStatus TEST_LOAN_STATUS = LoanStatus.ACTIVE;
    private static final String TEST_LOAN_ID = "loan id";
    private static final Calendar TEST_DUE_DATE = Calendar.getInstance();
    private static final String TEST_PICKUP_LOCATION = "pickup location";
    private static final String TEST_MESSAGE = "message";
    private static final String TEST_LT_ID = "lt id";
    private static final TargetDestination TEST_TARGET_DESTINATION = new TargetDestination();
    private static final String TEST_REQUEST_ID = "request id";
    private static final String TEST_NOTE = "note";
    private static final String TEST_COMMENT = "comment";

    @Mock
    private AlmaClient mockAlmaApiClient;

    @Mock
    private WebTarget webTarget;

    @Mock
    private Builder builder;

    @Mock
    private Invocation invocation;

    @Mock
    private WebTarget getItemsWebTarget;

    @Mock
    private Builder getItemsBuilder;

    @Mock
    private Invocation getInvocation;

    @Mock
    private Response response;

    @BeforeEach
    void init() {
        mockAlmaApi();
    }

    @Test
    void testGetItemId() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        Item tempItem = new Item();
        tempItem.setLink(TEST_LINK);

        when(invocation.invoke(Item.class)).thenReturn(tempItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        Item resultItem = almaItemsService.getItem(TEST_MMS_ID, TEST_HOLDINGS_ID, TEST_ITEMS_ID);
        assertEquals(TEST_LINK, resultItem.getLink());

    }

    @Test
    void getItemBarcode() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        Item tempItem = new Item();
        tempItem.setLink(TEST_LINK);

        when(invocation.invoke(Item.class)).thenReturn(tempItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        Item resultItem = almaItemsService.getItem(TEST_BARCODE);
        assertEquals(TEST_LINK, resultItem.getLink());

    }

    @Test
    void testCreateItem() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);

        Item tempItem = new Item();
        tempItem.setLink(TEST_LINK);
        when(builder.buildPost(any())).thenReturn(invocation);

        when(invocation.invoke(Item.class)).thenReturn(tempItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        Item resultItem = almaItemsService.createItem(TEST_MMS_ID, TEST_HOLDINGS_ID);
        assertEquals(TEST_LINK, resultItem.getLink());

    }

    @Test
    void testUpdateItem() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);

        Item tempItem = createTestItem();
        tempItem.setLink(TEST_LINK);
        when(builder.buildPut(any())).thenReturn(invocation);

        when(invocation.invoke(Item.class)).thenReturn(tempItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        Item resultItem = almaItemsService.updateItem(tempItem);
        assertEquals(TEST_LINK, resultItem.getLink());
    }

    @Test
    void testCreateUserLoanOnItem() {

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);

        Item tempItem = createTestItem();
        when(builder.buildPost(any())).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);

        ItemLoan tempItemLoan = new ItemLoan();
        tempItemLoan.setItemBarcode(TEST_BARCODE);

        Item testItemNoBibData = createTestItem();
        testItemNoBibData.setBibData(null);

        Item testItemNoHoldingData = createTestItem();
        testItemNoHoldingData.setHoldingData(null);

        Item testItemNoItemData = createTestItem();
        testItemNoItemData.setItemData(null);

        when(invocation.invoke(ItemLoan.class)).thenReturn(tempItemLoan);
        when(getInvocation.invoke(Item.class)).thenReturn(tempItem, tempItem, testItemNoBibData, testItemNoHoldingData,
                testItemNoItemData);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        ItemLoan resultItemLoan =
                almaItemsService.createUserLoanOnItem(TEST_BARCODE, TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK);
        assertEquals(TEST_BARCODE, resultItemLoan.getItemBarcode());
        resultItemLoan =
                almaItemsService.createUserLoanOnItem(TEST_BARCODE, TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK,
                        TEST_FINE, TEST_LOAN_STATUS);
        assertEquals(TEST_BARCODE, resultItemLoan.getItemBarcode());
        try {
            almaItemsService.createUserLoanOnItem(TEST_BARCODE, TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK);
            fail("BibData == null in Item should throw exception");
        } catch (IllegalStateException e) {
        }

        try {
            almaItemsService.createUserLoanOnItem(TEST_BARCODE, TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK);
            fail("HoldingData == null in Item should throw exception");
        } catch (IllegalStateException e) {
        }

        try {
            almaItemsService.createUserLoanOnItem(TEST_BARCODE, TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK);
            fail("ItemData == null in Item should throw exception");
        } catch (IllegalStateException e) {
        }

    }

    @Test
    void testUpdateUserLoanAndChangeDueDate() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);

        when(builder.buildPut(any())).thenReturn(invocation);

        ItemLoan tempItemLoan = new ItemLoan();
        tempItemLoan.setItemBarcode(TEST_BARCODE);

        when(invocation.invoke((Class<Object>) any())).thenReturn(tempItemLoan);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        ItemLoan resultItemLoan =
                almaItemsService.updateUserLoanAndChangeDueDate(TEST_USER_ID, TEST_LOAN_ID, TEST_DUE_DATE);
        assertEquals(TEST_BARCODE, resultItemLoan.getItemBarcode());

    }

    @Test
    void testGetRequestsFromItem() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);

        UserRequests tempUserRequests = new UserRequests();
        tempUserRequests.setTotalRecordCount(TOTAL_RECORD_COUNT);
        when(invocation.invoke(UserRequests.class)).thenReturn(tempUserRequests);

        Item testGetItem = createTestItem();
        when(invocation.invoke(Item.class)).thenReturn(testGetItem);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        UserRequests resultUserRequests =
                almaItemsService.getRequestsFromItem(TEST_MMS_ID, TEST_HOLDINGS_ID, TEST_ITEMS_ID, true);
        assertEquals(TOTAL_RECORD_COUNT, resultUserRequests.getTotalRecordCount());
        resultUserRequests = almaItemsService.getRequestsFromItem(TEST_MMS_ID, TEST_HOLDINGS_ID, TEST_ITEMS_ID, false);
        assertEquals(TOTAL_RECORD_COUNT, resultUserRequests.getTotalRecordCount());

        resultUserRequests = almaItemsService.getRequestsFromItem(TEST_BARCODE, true);
        assertEquals(TOTAL_RECORD_COUNT, resultUserRequests.getTotalRecordCount());
        resultUserRequests = almaItemsService.getRequestsFromItem(TEST_BARCODE, false);
        assertEquals(TOTAL_RECORD_COUNT, resultUserRequests.getTotalRecordCount());

        Item tempItem = createTestItem();
        resultUserRequests = almaItemsService.getRequestsFromItem(tempItem, false);
        assertEquals(TOTAL_RECORD_COUNT, resultUserRequests.getTotalRecordCount());
        resultUserRequests = almaItemsService.getRequestsFromItem(tempItem, true);
        assertEquals(TOTAL_RECORD_COUNT, resultUserRequests.getTotalRecordCount());
    }

    @Test
    void testCreatePatronRequst() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(any())).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);

        UserRequest tempUserRequest = new UserRequest();

        tempUserRequest.setBarcode(TEST_BARCODE);
        when(invocation.invoke(UserRequest.class)).thenReturn(tempUserRequest);

        Item testGetItem = createTestItem();

        Item testItemNoItemData = createTestItem();
        testItemNoItemData.setItemData(null);

        when(getInvocation.invoke(Item.class)).thenReturn(testGetItem, testItemNoItemData);
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        Item tempItem = createTestItem();
        UserRequest resultPatronRequest =
                almaItemsService.createPatronRequest(tempItem, TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_USER_ID);
        assertEquals(TEST_BARCODE, resultPatronRequest.getBarcode());

        try {
            almaItemsService.createPatronRequest(tempItem, TEST_PICKUP_LOCATION, TEST_MESSAGE, null);
            fail("userId == null in createPatronRequest should throw exception");
        } catch (IllegalArgumentException e) {
        }

        try {
            almaItemsService.createPatronRequest(tempItem, TEST_PICKUP_LOCATION, TEST_MESSAGE, "");
            fail("userId == \"\" in createPatronRequest should throw exception");
        } catch (IllegalArgumentException e) {
        }

        Item noItemData = createTestItem();
        noItemData.setItemData(null);
        try {
            almaItemsService.createPatronRequest(noItemData, TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_USER_ID);
            fail("ItemData == null in Item should throw exception");
        } catch (IllegalArgumentException e) {
        }

        Item noHoldingData = createTestItem();
        noHoldingData.setHoldingData(null);
        try {
            almaItemsService.createPatronRequest(noHoldingData, TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_USER_ID);
            fail("HoldingData == null in Item should throw exception");
        } catch (IllegalArgumentException e) {
        }

        Item noBibData = createTestItem();
        noBibData.setBibData(null);
        try {
            almaItemsService.createPatronRequest(noBibData, TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_USER_ID);
            fail("BibData == null in Item should throw exception");
        } catch (IllegalArgumentException e) {
        }

        resultPatronRequest = almaItemsService.createPatronRequest(TEST_MMS_ID, TEST_USER_ID, tempUserRequest);
        assertEquals(TEST_BARCODE, resultPatronRequest.getBarcode());

        try {
            almaItemsService.createPatronRequest(TEST_MMS_ID, null, tempUserRequest);
            fail("userId == null in createPatronRequest should throw exception");
        } catch (IllegalArgumentException e) {
        }
        try {
            almaItemsService.createPatronRequest(TEST_MMS_ID, "", tempUserRequest);
            fail("userId == \"\" in createPatronRequest should throw exception");
        } catch (IllegalArgumentException e) {
        }

        resultPatronRequest =
                almaItemsService.createPatronRequest(TEST_BARCODE, TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_LT_ID);
        assertEquals(TEST_BARCODE, resultPatronRequest.getBarcode());

        try {
            almaItemsService.createPatronRequest(TEST_BARCODE, TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_LT_ID);
            fail("ItemData == null in Item should throw exception");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void testCreateDigitizationRequest() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(any())).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);

        UserRequest tempUserRequest = new UserRequest();
        tempUserRequest.setBarcode(TEST_BARCODE);
        when(invocation.invoke(UserRequest.class)).thenReturn(tempUserRequest);

        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);

        Item testItem = createTestItem();
        UserRequest resultUserRequest =
                almaItemsService.createDigitizationRequest(testItem, TEST_TARGET_DESTINATION, TEST_MESSAGE,
                        TEST_USER_ID);
        assertEquals(TEST_BARCODE, resultUserRequest.getBarcode());

        resultUserRequest =
                almaItemsService.createDigitizationRequest(testItem, TEST_TARGET_DESTINATION, TEST_MESSAGE);
        assertEquals(TEST_BARCODE, resultUserRequest.getBarcode());

        Item noBibData = createTestItem();
        noBibData.setBibData(null);
        try {
            almaItemsService.createDigitizationRequest(noBibData, TEST_TARGET_DESTINATION, TEST_MESSAGE);
            fail("BibData == null in Item should throw exceptrion");
        } catch (IllegalArgumentException e) {
        }

        Item noHoldingData = createTestItem();
        noHoldingData.setHoldingData(null);
        try {
            almaItemsService.createDigitizationRequest(noHoldingData, TEST_TARGET_DESTINATION, TEST_MESSAGE);
            fail("BibData == null in Item should throw exceptrion");
        } catch (IllegalArgumentException e) {
        }

        Item noItemData = createTestItem();
        noItemData.setItemData(null);
        try {
            almaItemsService.createDigitizationRequest(noItemData, TEST_TARGET_DESTINATION, TEST_MESSAGE);
            fail("BibData == null in Item should throw exceptrion");
        } catch (IllegalArgumentException e) {
        }

        Item testGetItem = createTestItem();
        when(getInvocation.invoke(Item.class)).thenReturn(testGetItem);

        resultUserRequest =
                almaItemsService.createDigitizationRequest(TEST_BARCODE, TEST_TARGET_DESTINATION, TEST_MESSAGE);
        assertEquals(TEST_BARCODE, resultUserRequest.getBarcode());
    }

    @Test
    void testDeleteItem() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildDelete()).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);
        when(invocation.invoke()).thenReturn(response);

        Item testItem = createTestItem();
        when(getInvocation.invoke(Item.class)).thenReturn(testItem);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);
        almaItemsService.deleteItem(TEST_BARCODE, false, HoldingsRecord.DELETE);
        almaItemsService.deleteItem(TEST_BARCODE, true, HoldingsRecord.DELETE);
        almaItemsService.deleteItem(TEST_MMS_ID, TEST_HOLDINGS_ID, TEST_ITEMS_ID, false, HoldingsRecord.DELETE);
        almaItemsService.deleteItem(TEST_MMS_ID, TEST_HOLDINGS_ID, TEST_ITEMS_ID, true, HoldingsRecord.DELETE);
    }

    @Test
    void testDeleteRequest() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildDelete()).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);
        when(invocation.invoke()).thenReturn(response);

        Item testItem = createTestItem();
        when(getInvocation.invoke(Item.class)).thenReturn(testItem);
        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);
        almaItemsService.deleteRequest(TEST_BARCODE, TEST_REQUEST_ID);
        almaItemsService.deleteRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_NOTE);
    }

    @Test
    void testUpdateCommentOnRequest() {
        final String COMMENT_FORMAT = "Ordernum: %s";
        final String APPENDED_COMMENT_FORMAT = "Ordernum: comment\nOrdernum: %s";

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(any())).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);

        UserRequest testUserRequest = new UserRequest();
        testUserRequest.setRequestId(TEST_REQUEST_ID);
        when(invocation.invoke(UserRequest.class)).thenReturn(testUserRequest);

        UserRequests testUserRequests = new UserRequests();
        testUserRequests.getUserRequest().add(testUserRequest);

        UserRequests emptyUserRequests = new UserRequests();
        UserRequest emptyUserRequest = new UserRequest();
        emptyUserRequests.getUserRequest().add(emptyUserRequest);
        emptyUserRequest.setRequestId("");
        when(getInvocation.invoke(UserRequests.class)).thenReturn(testUserRequests, testUserRequests,
                emptyUserRequests);
        Item testItem = createTestItem();
        when(getInvocation.invoke(Item.class)).thenReturn(testItem);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);

        UserRequest resultUserRequest =
                almaItemsService.updateCommentOnRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_COMMENT, false);
        assertEquals(String.format(COMMENT_FORMAT, TEST_COMMENT), resultUserRequest.getComment());

        resultUserRequest = almaItemsService.updateCommentOnRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_COMMENT, true);
        assertEquals(String.format(APPENDED_COMMENT_FORMAT, TEST_COMMENT), resultUserRequest.getComment());

        try {
            almaItemsService.updateCommentOnRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_COMMENT, true);
            fail("When updateCommentOnRequest on non-existing request id should throw exception");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void testActionOnRequest() {
        final String TEST_ACTION = "action";

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(any())).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);

        Item testItem = createTestItem();
        when(getInvocation.invoke(Item.class)).thenReturn(testItem);

        UserRequest tempUserRequest = new UserRequest();
        tempUserRequest.setBarcode(TEST_BARCODE);
        when(invocation.invoke(UserRequest.class)).thenReturn(tempUserRequest);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);
        UserRequest resultUserRequest =
                almaItemsService.actionOnRequest(TEST_BARCODE, TEST_ACTION, TEST_REQUEST_ID, false);
        assertEquals(TEST_BARCODE, resultUserRequest.getBarcode());
    }

    @Test
    void testScanInItem() {
        String TEST_DEPARTMENT = "department";

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(any())).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);

        Item testItem = createTestItem();
        when(getInvocation.invoke(Item.class)).thenReturn(testItem);
        when(invocation.invoke(Item.class)).thenReturn(testItem);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);
        Item resultItem = almaItemsService.scanInItem(TEST_BARCODE, TEST_CIRCULATION_DESK, TEST_LIBRARY);
        assertEquals(TEST_ITEMS_ID, resultItem.getItemData().getPid());
        resultItem =
                almaItemsService.scanInItem(TEST_BARCODE, TEST_REQUEST_ID, TEST_DEPARTMENT, TEST_CIRCULATION_DESK,
                        TEST_LIBRARY);
        assertEquals(TEST_ITEMS_ID, resultItem.getItemData().getPid());
    }

    @Test
    void testUpdateRemoteDigitalItem() {
        String TEST_LABEL = "label";
        String TEST_REPRESENTATION_ID = "representation id";

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(any())).thenReturn(invocation);

        Representation tempRepresentation = new Representation();
        tempRepresentation.setLabel(TEST_LABEL);
        when(invocation.invoke(Representation.class)).thenReturn(tempRepresentation);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);
        Representation resultRepresentation =
                almaItemsService.updateRemoteDigitalItem(TEST_MMS_ID, TEST_REPRESENTATION_ID, tempRepresentation);
        assertEquals(TEST_LABEL, resultRepresentation.getLabel());

    }

    @Test
    void testUpdateItemDescription() {
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(any())).thenReturn(invocation);

        Item tempItem = createTestItem();
        tempItem.getItemData().setBarcode(TEST_BARCODE);
        when(invocation.invoke(Item.class)).thenReturn(tempItem);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);
        Item resultItem = almaItemsService.updateItemDescription(tempItem);
        assertEquals(TEST_BARCODE, resultItem.getItemData().getBarcode());
    }

    @Test
    void testGetAlmaStage() {
        AlmaHoldingsService almaBibsService =
                new AlmaHoldingsService(mockAlmaApiClient);
        assertEquals(STAGE, almaBibsService
                .getAlmaStage());
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
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

    private Item createTestItem() {
        Item tempItem = new Item();
        BibData bibData = new BibData();
        bibData.setMmsId(TEST_MMS_ID);
        HoldingData holdingData = new HoldingData();
        holdingData.setHoldingId(TEST_HOLDINGS_ID);
        ItemData itemData = new ItemData();
        itemData.setPid(TEST_ITEMS_ID);
        PhysicalMaterialType physicalMaterialType = new PhysicalMaterialType();
        String TEST_PHYSICALMATERIAL_TYPE = "physical material type";
        physicalMaterialType.setValue(TEST_PHYSICALMATERIAL_TYPE);
        itemData.setPhysicalMaterialType(physicalMaterialType);
        tempItem.setBibData(bibData);
        tempItem.setHoldingData(holdingData);
        tempItem.setItemData(itemData);

        return tempItem;
    }
}