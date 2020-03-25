package no.unit.alma.bibs;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import no.unit.alma.generated.itemloans.ItemLoan;
import no.unit.alma.generated.itemloans.LoanStatus;
import no.unit.alma.generated.items.BibData;
import no.unit.alma.generated.items.HoldingData;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.ItemData;
import no.unit.alma.generated.items.ObjectFactory;
import no.unit.alma.generated.representations.Representation;
import no.unit.alma.generated.userrequests.PickupLocationTypes;
import no.unit.alma.generated.userrequests.RequestTypes;
import no.unit.alma.generated.userrequests.UserRequest;
import no.unit.alma.generated.userrequests.UserRequests;
import no.unit.alma.commons.AlmaClient;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

public class AlmaItemsService {

    private static final String EMPTY_STRING = "";
    private static final String PATRON_PHYSICAL = "PATRON_PHYSICAL";
    private static final String HISTORY = "history";
    private static final String STATUS = "status";
    private static final String REQUEST_TYPE = "request_type";
    private static final String REQUESTS = "requests";
    private static final String USER_ID = "user_id";
    private static final String LOANS = "loans";
    private static final String HOLDINGS = "holdings";
    private static final String USERS = "users";
    private static final String ITEMS = "items";
    private static final String BIBS = "bibs";

    private final transient WebTarget bibsTarget;
    private final transient WebTarget itemsTarget;
    private final transient WebTarget usersTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    private static final transient Logger log = LoggerFactory.getLogger(AlmaItemsService.class);

    public AlmaItemsService(AlmaClient almaClient) {
        this.bibsTarget = almaClient.getWebTarget().path(BIBS);
        this.itemsTarget = almaClient.getWebTarget().path(ITEMS);
        this.usersTarget = almaClient.getWebTarget().path(USERS);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    public Item getItem(final String mmsId, final String holdingsId, final String itemId) {
        return bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Item.class);
    }

    public Item getItem(final String barcode) {
        return itemsTarget
                .queryParam("item_barcode", barcode)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Item.class);
    }

    public Item createItem(final String mms, final String holdingsId) {
        return bibsTarget
                .path(mms)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(EMPTY_STRING))
                .invoke(Item.class);
    }

    public Item updateItem(final Item item) {
        return bibsTarget
                .path(item.getBibData().getMmsId())
                .path(HOLDINGS)
                .path(item.getHoldingData().getHoldingId())
                .path(ITEMS)
                .path(item.getItemData().getPid())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(item))
                .invoke(Item.class);
    }


    public ItemLoan createUserLoanOnItem(final String barcode, final String userId, final String library,
            final String circulationDesk) {
        final Item item = getItem(barcode);
        final BibData bibData = item.getBibData();
        final HoldingData holdingData = item.getHoldingData();
        final ItemData itemData = item.getItemData();
        if (bibData == null || holdingData == null || itemData == null) {
            throw new IllegalStateException("Cannot create user loan on empty Item");
        }
        final ItemLoan itemLoan = new ItemLoan();
        itemLoan.setItemBarcode(barcode);
        itemLoan.setUserId(userId);
        final ItemLoan.Library loanLibrary = new ItemLoan.Library();
        loanLibrary.setValue(library);
        itemLoan.setLibrary(loanLibrary);
        final ItemLoan.CircDesk circDesk = new ItemLoan.CircDesk();
        circDesk.setValue(circulationDesk);
        itemLoan.setCircDesk(circDesk);

        return bibsTarget
                .path(bibData.getMmsId())
                .path(HOLDINGS)
                .path(holdingData.getHoldingId())
                .path(ITEMS)
                .path(itemData.getPid())
                .path(LOANS)
                .queryParam(USER_ID, userId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(itemLoan))
                .invoke(ItemLoan.class);
    }


    public ItemLoan createUserLoanOnItem(final String barcode, final String userId, final String library,
            final String circulationDesk, final float fine, final LoanStatus loanStatus) {
        final Item item = getItem(barcode);
        final BibData bibData = item.getBibData();
        final HoldingData holdingData = item.getHoldingData();
        final ItemData itemData = item.getItemData();
        if (bibData == null || holdingData == null || itemData == null) {
            throw new IllegalStateException("Cannot create user loan on empty Item");
        }
        final ItemLoan itemLoan = new ItemLoan();
        itemLoan.setLoanFine(fine);
        itemLoan.setLoanStatus(loanStatus);
        itemLoan.setItemBarcode(barcode);
        itemLoan.setUserId(userId);
        final ItemLoan.Library loanLibrary = new ItemLoan.Library();
        loanLibrary.setValue(library);
        itemLoan.setLibrary(loanLibrary);
        final ItemLoan.CircDesk circDesk = new ItemLoan.CircDesk();
        circDesk.setValue(circulationDesk);
        itemLoan.setCircDesk(circDesk);

        return bibsTarget
                .path(bibData.getMmsId())
                .path(HOLDINGS)
                .path(holdingData.getHoldingId())
                .path(ITEMS)
                .path(itemData.getPid())
                .path(LOANS)
                .queryParam(USER_ID, userId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(itemLoan))
                .invoke(ItemLoan.class);
    }


    public ItemLoan updateUserLoanAndChangeDueDate(final String userId, final String loanId, final Calendar dueDate)
            throws DatatypeConfigurationException {
        final ItemLoan itemLoan = new ItemLoan();
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(dueDate.getTime());
        XMLGregorianCalendar gregorianDueDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
        itemLoan.setDueDate(gregorianDueDate);
        return usersTarget
                .path(userId)
                .path(LOANS)
                .path(loanId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(itemLoan))
                .invoke(ItemLoan.class);
    }

    public UserRequests getRequestsFromItem(Item item, boolean deleted) {
        final String recordId = item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return getRequestsFromItem(recordId, holdingsId, itemId, deleted);
    }


    public UserRequests getRequestsFromItem(String mmsId, String holdingId, String itemPid, boolean deleted) {
        WebTarget requestsFromItemTarget =
                bibsTarget
                        .path(mmsId)
                        .path(HOLDINGS)
                        .path(holdingId)
                        .path(ITEMS)
                        .path(itemPid)
                        .path(REQUESTS);

        if (deleted) {
            requestsFromItemTarget =
                    requestsFromItemTarget
                            .queryParam(REQUEST_TYPE, "DIGITIZATION")
                            .queryParam(STATUS, HISTORY);
        }

        return requestsFromItemTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(UserRequests.class);
    }

    public UserRequests getRequestsFromItem(String barcode, boolean deleted) {
        final Item item = getItem(barcode);
        return getRequestsFromItem(item, deleted);
    }

    public UserRequest createPatronRequest(String barcode, String pickupLocationLibrary, String message, String ltId) {
        final Item item = getItem(barcode);
        if (item.getItemData() == null) {
            throw new IllegalStateException("Item not found for barcode: " + barcode);
        }
        return createPatronRequest(item, pickupLocationLibrary, message, ltId);
    }

    public UserRequest createPatronRequest(Item item, String pickupLocationLibrary, String message, String userId) {
        final BibData bibData = item.getBibData();
        final HoldingData holdingData = item.getHoldingData();
        final ItemData itemData = item.getItemData();
        if (bibData == null || holdingData == null || itemData == null) {
            throw new IllegalArgumentException("Cannot create digitization request for empty Item");
        }
        if (StringUtils.isEmpty(userId)) {
            throw new IllegalArgumentException(
                    "No ltId provided for barcode=" + item.getItemData().getBarcode() + ", could not create request");
        }
        final UserRequest newRequest = new UserRequest();
        newRequest.setPickupLocationType(PickupLocationTypes.LIBRARY);
        newRequest.setRequestType(RequestTypes.HOLD);
        newRequest.setComment(message);
        newRequest.setPickupLocationLibrary(pickupLocationLibrary);
        final UserRequest.RequestSubType requestSubType = new UserRequest.RequestSubType();
        requestSubType.setValue(PATRON_PHYSICAL);
        newRequest.setRequestSubType(requestSubType);
        return bibsTarget
                .path(bibData.getMmsId())
                .path(HOLDINGS)
                .path(holdingData.getHoldingId())
                .path(ITEMS)
                .path(itemData.getPid())
                .path(REQUESTS)
                .queryParam(USER_ID, userId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(newRequest))
                .invoke(UserRequest.class);
    }

    public UserRequest createPatronRequest(String mmsId, String userId, final UserRequest newRequest) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("No ltId provided for mmsid=" + mmsId + ", could not create request");
        }
        return bibsTarget
                .path(mmsId)
                .path(REQUESTS)
                .queryParam(USER_ID, userId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(newRequest))
                .invoke(UserRequest.class);
    }

    public UserRequest createDigitizationRequest(String barcode, UserRequest.TargetDestination targetDestination,
            String message) {
        final Item item = getItem(barcode);
        return createDigitizationRequest(item, targetDestination, message);
    }

    public UserRequest createDigitizationRequest(Item item, UserRequest.TargetDestination targetDestination,
            String message) {
        return createDigitizationRequest(item, targetDestination, message, null);
    }

    public UserRequest createDigitizationRequest(Item item, UserRequest.TargetDestination targetDestination,
            String message, String userId) {
        final BibData bibData = item.getBibData();
        final HoldingData holdingData = item.getHoldingData();
        final ItemData itemData = item.getItemData();
        if (bibData == null || holdingData == null || itemData == null) {
            throw new IllegalArgumentException("Cannot create digitization request for empty Item");
        }

        final UserRequest newRequest = new UserRequest();
        newRequest.setRequestType(RequestTypes.DIGITIZATION);
        newRequest.setComment(message);
        newRequest.setPartialDigitization(Boolean.FALSE);
        final UserRequest.MaterialType materialType = new UserRequest.MaterialType();
        materialType.setValue("BOOK");
        try {
            materialType.setValue(item.getItemData().getPhysicalMaterialType().getValue());
        } catch (Exception e) { // wtf
            log.error(e.getMessage());
        }
        newRequest.setMaterialType(materialType);
        newRequest.setTargetDestination(targetDestination);
        WebTarget digitizationTarget =
                bibsTarget
                        .path(bibData.getMmsId())
                        .path(HOLDINGS)
                        .path(holdingData.getHoldingId())
                        .path(ITEMS)
                        .path(itemData.getPid())
                        .path(REQUESTS);
        if (StringUtils.isNotEmpty(userId)) {
            digitizationTarget =
                    digitizationTarget
                            .queryParam(USER_ID, userId);
        }
        return digitizationTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(newRequest))
                .invoke(UserRequest.class);
    }

    public void deleteItem(final String mmsId, String holdingsId, final String itemId, boolean override,
            HoldingsRecord holdingsRecord) {
        bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .queryParam("override", override)
                .queryParam(HOLDINGS, holdingsRecord.toString())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
    }

    public void deleteItem(final String barcode, boolean override, HoldingsRecord holdingsRecord) {
        final Item item = getItem(barcode);
        final String recordId = item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        WebTarget deleteTarget =
                bibsTarget
                        .path(recordId)
                        .path(HOLDINGS)
                        .path(holdingsId)
                        .path(ITEMS)
                        .path(itemId)
                        .queryParam(HOLDINGS, holdingsRecord.toString());
        if (override) {
            deleteTarget = deleteTarget.queryParam("override", true);
        }
        deleteTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
    }

    public void deleteRequest(String barcode, String requestId) {
        deleteRequest(barcode, requestId, EMPTY_STRING);
    }

    public void deleteRequest(final String barcode, final String requestId, String note) {
        final Item item = getItem(barcode);
        final String recordId = item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();

        WebTarget deleteTarget =
                bibsTarget
                        .path(recordId)
                        .path(HOLDINGS)
                        .path(holdingsId)
                        .path(ITEMS)
                        .path(itemId)
                        .path(REQUESTS)
                        .path(requestId);
        if (StringUtils.isNotEmpty(note)) {
            deleteTarget = deleteTarget.queryParam("note", note);
        }
        deleteTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();

    }

    public UserRequest updateCommentOnRequest(String barcode, String requestId, String comment,
            boolean appendToExistingComment) {
        final List<UserRequest> requestsFromItem = getRequestsFromItem(barcode, false).getUserRequest();
        UserRequest updatingRequest = null;
        for (UserRequest request : requestsFromItem) {
            if (request.getRequestId().equals(requestId)) {
                updatingRequest = request;
                break;
            }
        }
        if (updatingRequest == null) {
            throw new IllegalStateException("Could not find request for " + barcode + " with id = " + requestId);
        }
        String existingComment = updatingRequest.getComment();
        if (appendToExistingComment && existingComment != null && existingComment.length() > 0) {
            updatingRequest.setComment(existingComment + "\nOrdernum: " + comment);
        } else {
            updatingRequest.setComment("Ordernum: " + comment);
        }
        final Item item = getItem(barcode);
        final String recordId = item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        final UserRequest requestToUpdate = updatingRequest;

        return bibsTarget
                .path(recordId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .path(REQUESTS)
                .path(recordId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(requestToUpdate))
                .invoke(UserRequest.class);
    }

    public UserRequest actionOnRequest(String barcode, String action, String requestId, boolean releaseItem) { // todo:
                                                                                                               // releaseItem
                                                                                                               // er
                                                                                                               // ikke i
                                                                                                               // bruk
        final Item item = getItem(barcode);
        final String recordId = EMPTY_STRING + item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return bibsTarget
                .path(recordId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .path(REQUESTS)
                .path(requestId)
                .queryParam("op", action)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(EMPTY_STRING))
                .invoke(UserRequest.class);
    }

    public Item scanInItem(String barcode, String requestId, String department, String circDesk, String library) {
        final Item item = getItem(barcode);
        final String recordId = EMPTY_STRING + item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return bibsTarget
                .path(recordId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .queryParam("request_id", requestId)
                .queryParam("op", "scan")
                .queryParam("department", department)
                .queryParam("circ_desk", circDesk)
                .queryParam("library", library)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(EMPTY_STRING))
                .invoke(Item.class);
    }

    public Item scanInItem(String barcode, String circDesk, String library) {
        final Item item = getItem(barcode);
        final String recordId = EMPTY_STRING + item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return bibsTarget
                .path(recordId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path(ITEMS)
                .path(itemId)
                .queryParam("op", "scan")
                .queryParam("circ_desk", circDesk)
                .queryParam("library", library)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(EMPTY_STRING))
                .invoke(Item.class);
    }

    public Representation updateRemoteDigitalItem(String mmsId, String representationId, Representation digitalItem) {
        return bibsTarget
                .path(mmsId)
                .path("representations")
                .path(representationId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(digitalItem))
                .invoke(Representation.class);
    }

    public Item updateItemDescription(final Item item) {
        return bibsTarget
                .path(item.getBibData().getMmsId())
                .path(HOLDINGS)
                .path(item.getHoldingData().getHoldingId())
                .path(ITEMS)
                .path(item.getItemData().getPid())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(new ObjectFactory().createItem(item)))
                .invoke(Item.class);
    }

    public String getContext() {
        return context;
    }

    public String getContextValue() {
        return contextValue;
    }

    public String getAlmaStage() {
        return almaStage;
    }
}
