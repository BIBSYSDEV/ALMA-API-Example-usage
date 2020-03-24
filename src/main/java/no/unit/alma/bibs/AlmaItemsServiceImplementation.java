package no.unit.alma.bibs;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import no.unit.alma.generated.items.ObjectFactory;
import org.apache.commons.lang3.StringUtils;

import no.unit.alma.generated.items.BibData;
import no.unit.alma.generated.items.HoldingData;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.ItemData;
import no.unit.alma.generated.representations.Representation;
import no.unit.alma.generated.itemloans.ItemLoan;
import no.unit.alma.generated.itemloans.LoanStatus;
import no.unit.alma.generated.userrequests.UserRequest;
import no.unit.alma.generated.userrequests.UserRequests;
import no.unit.alma.generated.userrequests.RequestTypes;
import no.unit.alma.generated.userrequests.PickupLocationTypes;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

public class AlmaItemsServiceImplementation implements AlmaItemsService {

    private final WebTarget bibsTarget;
    private final WebTarget itemsTarget;
    private final WebTarget usersTarget;
    private final String context;
    private final String contextValue;
    private final AlmaStage almaStage;

    public AlmaItemsServiceImplementation(AlmaClient almaClient) {
        this.bibsTarget = almaClient.getWebTarget().path("bibs");
        this.itemsTarget = almaClient.getWebTarget().path("items");
        this.usersTarget = almaClient.getWebTarget().path("users");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    @Override
    public Item getItem(final String mmsId, final String holdingsId, final String itemId) {
        return bibsTarget
                .path(mmsId)
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .path(itemId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Item.class);
    }

    @Override
    public Item getItem(final String barcode) {
        return itemsTarget
                .queryParam("item_barcode", barcode)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Item.class);
    }

    @Override
    public Item createItem(final String mms, final String holdingsId) {
        return bibsTarget
                .path(mms)
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(""))
                .invoke(Item.class);
    }

    @Override
    public Item updateItem(final Item item) {
        return bibsTarget
                .path(item.getBibData().getMmsId())
                .path("holdings")
                .path(item.getHoldingData().getHoldingId())
                .path("items")
                .path(item.getItemData().getPid())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(item))
                .invoke(Item.class);
    }

    @Override
    public ItemLoan createUserLoanOnItem(final String barcode, final String user_Id, final String library,
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
        itemLoan.setUserId(user_Id);
        final ItemLoan.Library loanLibrary = new ItemLoan.Library();
        loanLibrary.setValue(library);
        itemLoan.setLibrary(loanLibrary);
        final ItemLoan.CircDesk circDesk = new ItemLoan.CircDesk();
        circDesk.setValue(circulationDesk);
        itemLoan.setCircDesk(circDesk);

        return bibsTarget
                .path(bibData.getMmsId())
                .path("holdings")
                .path(holdingData.getHoldingId())
                .path("items")
                .path(itemData.getPid())
                .path("loans")
                .queryParam("user_id", user_Id)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(itemLoan))
                .invoke(ItemLoan.class);
    }

    @Override
    public ItemLoan createUserLoanOnItem(final String barcode, final String user_Id, final String library,
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
        itemLoan.setUserId(user_Id);
        final ItemLoan.Library loanLibrary = new ItemLoan.Library();
        loanLibrary.setValue(library);
        itemLoan.setLibrary(loanLibrary);
        final ItemLoan.CircDesk circDesk = new ItemLoan.CircDesk();
        circDesk.setValue(circulationDesk);
        itemLoan.setCircDesk(circDesk);

        return bibsTarget
                .path(bibData.getMmsId())
                .path("holdings")
                .path(holdingData.getHoldingId())
                .path("items")
                .path(itemData.getPid())
                .path("loans")
                .queryParam("user_id", user_Id)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(itemLoan))
                .invoke(ItemLoan.class);
    }

    @Override
    public ItemLoan updateUserLoanAndChangeDueDate(final String userId, final String loanId, final Calendar dueDate) throws DatatypeConfigurationException {
        final ItemLoan itemLoan = new ItemLoan();
        GregorianCalendar gregory = new GregorianCalendar();
        gregory.setTime(dueDate.getTime());
        XMLGregorianCalendar gregorianDueDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
        itemLoan.setDueDate(gregorianDueDate);
        return usersTarget
                .path(userId)
                .path("loans")
                .path(loanId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(itemLoan))
                .invoke(ItemLoan.class);
    }

    @Override
    public UserRequests getRequestsFromItem(Item item, boolean deleted) {
        final String recordId = item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return getRequestsFromItem(recordId, holdingsId, itemId, deleted);
    }

    @Override
    public UserRequests getRequestsFromItem(String mms_id, String holding_id, String item_pid, boolean deleted) {
        WebTarget requestsFromItemTarget =
                bibsTarget
                        .path(mms_id)
                        .path("holdings")
                        .path(holding_id)
                        .path("items")
                        .path(item_pid)
                        .path("requests");

        if (deleted) {
            requestsFromItemTarget =
                    requestsFromItemTarget
                            .queryParam("request_type", "DIGITIZATION")
                            .queryParam("status", "history");
        }

        return requestsFromItemTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(UserRequests.class);
    }

    @Override
    public UserRequests getRequestsFromItem(String barcode, boolean deleted) {
        final Item item = getItem(barcode);
        return getRequestsFromItem(item, deleted);
    }

    @Override
    public UserRequest createPatronRequest(String barcode, String pickupLocationLibrary, String message, String ltId) {
        final Item item = getItem(barcode);
        if (item.getItemData() == null) {
            throw new IllegalStateException("Item not found for barcode: " + barcode);
        }
        return createPatronRequest(item, pickupLocationLibrary, message, ltId);
    }

    @Override
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
        requestSubType.setValue("PATRON_PHYSICAL");
        newRequest.setRequestSubType(requestSubType);
        return bibsTarget
                .path(bibData.getMmsId())
                .path("holdings")
                .path(holdingData.getHoldingId())
                .path("items")
                .path(itemData.getPid())
                .path("requests")
                .queryParam("user_id", userId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(newRequest))
                .invoke(UserRequest.class);
    }

    @Override
    public UserRequest createPatronRequest(String mmsId, String userId, final UserRequest newRequest) {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("No ltId provided for mmsid=" + mmsId + ", could not create request");
        }
        return bibsTarget
                .path(mmsId)
                .path("requests")
                .queryParam("user_id", userId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(newRequest))
                .invoke(UserRequest.class);
    }

    @Override
    public UserRequest createDigitizationRequest(String barcode, UserRequest.TargetDestination targetDestination,
            String message) {
        final Item item = getItem(barcode);
        return createDigitizationRequest(item, targetDestination, message);
    }

    @Override
    public UserRequest createDigitizationRequest(Item item, UserRequest.TargetDestination targetDestination,
            String message) {
        return createDigitizationRequest(item, targetDestination, message, null);
    }

    @Override
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
//            log.error("", e);
        }
        newRequest.setMaterialType(materialType);
        newRequest.setTargetDestination(targetDestination);
        WebTarget digitizationTarget =
                bibsTarget
                        .path(bibData.getMmsId())
                        .path("holdings")
                        .path(holdingData.getHoldingId())
                        .path("items")
                        .path(itemData.getPid())
                        .path("requests");
        if (StringUtils.isNotEmpty(userId)) {
            digitizationTarget =
                    digitizationTarget
                            .queryParam("user_id", userId);
        }
        return digitizationTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(newRequest))
                .invoke(UserRequest.class);
    }

    @Override
    public void deleteItem(final String mmsId, String holdingsId, final String itemId, boolean override,
            HoldingsRecord holdingsRecord) {
        bibsTarget
                .path(mmsId)
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .path(itemId)
                .queryParam("override", override)
                .queryParam("holdings", holdingsRecord.toString())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
    }

    @Override
    public void deleteItem(final String barcode, boolean override, HoldingsRecord holdingsRecord) {
        final Item item = getItem(barcode);
        final String recordId = item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        deleteItem(recordId, holdingsId, itemId, override, holdingsRecord);
    }

    @Override
    public void deleteRequest(String barcode, String requestId) {
        deleteRequest(barcode, requestId, "");
    }

    @Override
    public void deleteRequest(final String barcode, final String requestId, String note) {
        final Item item = getItem(barcode);
        final String recordId = item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();

        WebTarget deleteTarget =
                bibsTarget
                        .path(recordId)
                        .path("holdings")
                        .path(holdingsId)
                        .path("items")
                        .path(itemId)
                        .path("requests")
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

    @Override
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
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .path(itemId)
                .path("requests")
                .path(recordId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(requestToUpdate))
                .invoke(UserRequest.class);
    }

    @Override
    public UserRequest actionOnRequest(String barcode, String action, String requestId, boolean releaseItem) { // todo:
                                                                                                               // releaseItem
                                                                                                               // er
                                                                                                               // ikke i
                                                                                                               // bruk
        final Item item = getItem(barcode);
        final String recordId = "" + item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return bibsTarget
                .path(recordId)
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .path(itemId)
                .path("requests")
                .path(requestId)
                .queryParam("op", action)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(""))
                .invoke(UserRequest.class);
    }

    @Override
    public Item scanInItem(String barcode, String requestId, String department, String circDesk, String library) {
        final Item item = getItem(barcode);
        final String recordId = "" + item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return bibsTarget
                .path(recordId)
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .path(itemId)
                .queryParam("request_id", requestId)
                .queryParam("op", "scan")
                .queryParam("department", department)
                .queryParam("circ_desk", circDesk)
                .queryParam("library", library)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(""))
                .invoke(Item.class);
    }

    @Override
    public Item scanInItem(String barcode, String circDesk, String library) {
        final Item item = getItem(barcode);
        final String recordId = "" + item.getBibData().getMmsId();
        final String holdingsId = item.getHoldingData().getHoldingId();
        final String itemId = item.getItemData().getPid();
        return bibsTarget
                .path(recordId)
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .path(itemId)
                .queryParam("op", "scan")
                .queryParam("circ_desk", circDesk)
                .queryParam("library", library)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(""))
                .invoke(Item.class);
    }

    @Override
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

    @Override
    public Item updateItemDescription(final Item item) {
        return bibsTarget
                .path(item.getBibData().getMmsId())
                .path("holdings")
                .path(item.getHoldingData().getHoldingId())
                .path("items")
                .path(item.getItemData().getPid())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(new ObjectFactory().createItem(item)))
                .invoke(Item.class);
    }

    @Override
    public String getContext() {
        return context;
    }

    @Override
    public String getContextValue() {
        return contextValue;
    }

    @Override
    public AlmaStage getAlmaStage() {
        return almaStage;
    }
}
