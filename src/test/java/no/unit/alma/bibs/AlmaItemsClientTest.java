package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.itemloans.ItemLoan;
import no.unit.alma.generated.itemloans.LoanStatus;
import no.unit.alma.generated.items.BibData;
import no.unit.alma.generated.items.HoldingData;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.ItemData;
import no.unit.alma.generated.items.ItemData.PhysicalMaterialType;
import no.unit.alma.generated.representations.Representation;
import no.unit.alma.generated.userrequests.UserRequest;
import no.unit.alma.generated.userrequests.UserRequest.TargetDestination;
import no.unit.alma.generated.userrequests.UserRequests;

@ExtendWith(MockitoExtension.class)
class AlmaItemsClientTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
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

        Item tempItem = createTestItem();
        when(invocation.invoke(ItemLoan.class)).thenReturn(tempItemLoan);
        when(getInvocation.invoke(Item.class)).thenReturn(tempItem, tempItem, testItemNoBibData, testItemNoHoldingData,
                testItemNoItemData, testItemNoBibData, testItemNoHoldingData,
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

        assertThrows(IllegalStateException.class, () -> almaItemsService.createUserLoanOnItem(TEST_BARCODE,
                TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK));

        assertThrows(IllegalStateException.class, () -> almaItemsService.createUserLoanOnItem(TEST_BARCODE,
                TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK));

        assertThrows(IllegalStateException.class, () -> almaItemsService.createUserLoanOnItem(TEST_BARCODE,
                TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK));

        assertThrows(IllegalStateException.class, () -> almaItemsService.createUserLoanOnItem(TEST_BARCODE,
                TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK, TEST_FINE, TEST_LOAN_STATUS));

        assertThrows(IllegalStateException.class, () -> almaItemsService.createUserLoanOnItem(TEST_BARCODE,
                TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK, TEST_FINE, TEST_LOAN_STATUS));

        assertThrows(IllegalStateException.class, () -> almaItemsService.createUserLoanOnItem(TEST_BARCODE,
                TEST_USER_ID, TEST_LIBRARY, TEST_CIRCULATION_DESK, TEST_FINE, TEST_LOAN_STATUS));

    }

    @Test
    void testUpdateUserLoanAndChangeDueDate() throws DatatypeConfigurationException {
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
    void testCreatePatronRequest() {
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

        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createPatronRequest(tempItem,
                TEST_PICKUP_LOCATION, TEST_MESSAGE, null));

        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createPatronRequest(tempItem,
                TEST_PICKUP_LOCATION, TEST_MESSAGE, ""));

        Item noItemData = createTestItem();
        noItemData.setItemData(null);
        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createPatronRequest(noItemData,
                TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_USER_ID));

        Item noHoldingData = createTestItem();
        noHoldingData.setHoldingData(null);
        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createPatronRequest(noHoldingData,
                TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_USER_ID));

        Item noBibData = createTestItem();
        noBibData.setBibData(null);
        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createPatronRequest(noBibData,
                TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_USER_ID));

        resultPatronRequest = almaItemsService.createPatronRequest(TEST_MMS_ID, TEST_USER_ID, tempUserRequest);
        assertEquals(TEST_BARCODE, resultPatronRequest.getBarcode());

        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createPatronRequest(TEST_MMS_ID,
                null, tempUserRequest));

        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createPatronRequest(TEST_MMS_ID,
                "", tempUserRequest));

        resultPatronRequest =
                almaItemsService.createPatronRequest(TEST_BARCODE, TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_LT_ID);
        assertEquals(TEST_BARCODE, resultPatronRequest.getBarcode());

        assertThrows(IllegalStateException.class, () -> almaItemsService.createPatronRequest(TEST_BARCODE,
                TEST_PICKUP_LOCATION, TEST_MESSAGE, TEST_LT_ID));
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
        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createDigitizationRequest(noBibData,
                TEST_TARGET_DESTINATION, TEST_MESSAGE));

        Item noHoldingData = createTestItem();
        noHoldingData.setHoldingData(null);
        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createDigitizationRequest(noHoldingData,
                TEST_TARGET_DESTINATION, TEST_MESSAGE));

        Item noItemData = createTestItem();
        noItemData.setItemData(null);
        assertThrows(IllegalArgumentException.class, () -> almaItemsService.createDigitizationRequest(noItemData,
                TEST_TARGET_DESTINATION, TEST_MESSAGE));

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
        final String commentFormat = "Ordernum: %s";
        final String appendedCommentFormat = "Ordernum: comment\nOrdernum: %s";

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.queryParam(anyString(), any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(any())).thenReturn(invocation);
        when(builder.buildGet()).thenReturn(getInvocation);

        UserRequest testUserRequest = new UserRequest();
        testUserRequest.setRequestId(TEST_REQUEST_ID);
        testUserRequest.setComment(TEST_COMMENT);
        when(invocation.invoke(UserRequest.class)).thenReturn(testUserRequest);

        UserRequests testUserRequests = new UserRequests();
        testUserRequests.getUserRequests().add(testUserRequest);

        UserRequests emptyUserRequests = new UserRequests();
        UserRequest emptyUserRequest = new UserRequest();
        emptyUserRequests.getUserRequests().add(emptyUserRequest);
        emptyUserRequest.setRequestId("");

        UserRequests nullCommentUserRequests = new UserRequests();
        UserRequest nullCommentUserRequest = new UserRequest();
        nullCommentUserRequests.getUserRequests().add(nullCommentUserRequest);
        nullCommentUserRequest.setRequestId(TEST_REQUEST_ID);
        nullCommentUserRequest.setComment(null);
        nullCommentUserRequest.setBarcode("NULL");

        when(getInvocation.invoke(UserRequests.class))
                .thenReturn(testUserRequests, nullCommentUserRequests,
                        testUserRequests, nullCommentUserRequests,
                        emptyUserRequests);
        Item testItem = createTestItem();
        when(getInvocation.invoke(Item.class)).thenReturn(testItem);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);

        // testUserRequests
        UserRequest resultUserRequest =
                almaItemsService.updateCommentOnRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_COMMENT, false);
        assertEquals(String.format(commentFormat, TEST_COMMENT), resultUserRequest.getComment());

        // nullCommentUserRequests
        resultUserRequest =
                almaItemsService.updateCommentOnRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_COMMENT, false);
        assertEquals(String.format(commentFormat, TEST_COMMENT), resultUserRequest.getComment());
        nullCommentUserRequests.getUserRequests().get(0).setComment("");

        // testUserRequests
        resultUserRequest = almaItemsService.updateCommentOnRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_COMMENT, true);
        assertEquals(String.format(appendedCommentFormat, TEST_COMMENT), resultUserRequest.getComment());

        // nullCommentUserRequests
        resultUserRequest = almaItemsService.updateCommentOnRequest(TEST_BARCODE, TEST_REQUEST_ID, TEST_COMMENT, true);
        assertEquals(String.format(appendedCommentFormat, TEST_COMMENT), resultUserRequest.getComment());

        // emptyUserRequests
        assertThrows(IllegalStateException.class, () -> almaItemsService.updateCommentOnRequest(TEST_BARCODE,
                TEST_REQUEST_ID, TEST_COMMENT, true));
    }

    @Test
    void testActionOnRequest() {
        final String testAction = "action";

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
                almaItemsService.actionOnRequest(TEST_BARCODE, testAction, TEST_REQUEST_ID, false);
        assertEquals(TEST_BARCODE, resultUserRequest.getBarcode());
    }

    @Test
    void testScanInItem() {

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
        String testDepartment = "department";
        resultItem =
                almaItemsService.scanInItem(TEST_BARCODE, TEST_REQUEST_ID, testDepartment, TEST_CIRCULATION_DESK,
                        TEST_LIBRARY);
        assertEquals(TEST_ITEMS_ID, resultItem.getItemData().getPid());
    }

    @Test
    void testUpdateRemoteDigitalItem() {

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(any())).thenReturn(invocation);

        Representation tempRepresentation = new Representation();
        String testLabel = "label";
        tempRepresentation.setLabel(testLabel);
        when(invocation.invoke(Representation.class)).thenReturn(tempRepresentation);

        AlmaItemsService almaItemsService = new AlmaItemsService(mockAlmaApiClient);
        String testRepresentationId = "representation id";
        Representation resultRepresentation =
                almaItemsService.updateRemoteDigitalItem(TEST_MMS_ID, testRepresentationId, tempRepresentation);
        assertEquals(testLabel, resultRepresentation.getLabel());

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
    void testGetContext() {
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaItemsService.getContext());
    }

    @Test
    void testGetContextValue() {
        AlmaItemsService almaItemsService =
                new AlmaItemsService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaItemsService.getContextValue());
    }

    private void mockAlmaApi() {

        when(mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

    private Item createTestItem() {
        BibData bibData = new BibData();
        bibData.setMmsId(TEST_MMS_ID);
        HoldingData holdingData = new HoldingData();
        holdingData.setHoldingId(TEST_HOLDINGS_ID);
        ItemData itemData = new ItemData();
        itemData.setPid(TEST_ITEMS_ID);
        PhysicalMaterialType physicalMaterialType = new PhysicalMaterialType();
        String testPhysicalmaterialType = "physical material type";
        physicalMaterialType.setValue(testPhysicalmaterialType);
        itemData.setPhysicalMaterialType(physicalMaterialType);

        Item tempItem = new Item();
        tempItem.setBibData(bibData);
        tempItem.setHoldingData(holdingData);
        tempItem.setItemData(itemData);

        return tempItem;
    }
}
