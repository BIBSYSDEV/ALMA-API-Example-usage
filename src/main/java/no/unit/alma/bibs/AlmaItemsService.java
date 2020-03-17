package no.unit.alma.bibs;

import java.util.Calendar;

import no.bibsys.alma.rest.item_loan.ItemLoan;
import no.bibsys.alma.rest.item_loan.LoanStatus;
import no.bibsys.alma.rest.items.Item;
import no.bibsys.alma.rest.representations.Representation;
import no.bibsys.alma.rest.user_request.UserRequest;
import no.bibsys.alma.rest.user_request.UserRequests;
import no.unit.alma.commons.AlmaContext;

public interface AlmaItemsService extends AlmaContext {

    Item getItem(String mmsId, String holdingsId, String itemId);

    Item getItem(String barcode);

    Item createItem(String mms, String holdingsId);

    Item updateItem(Item item);

    ItemLoan createUserLoanOnItem(String barcode, String user_Id, String library, String circulationDesk);

    ItemLoan createUserLoanOnItem(String barcode, String user_Id, String library, String circulationDesk, float fine,
            LoanStatus loanStatus);

    ItemLoan updateUserLoanAndChangeDueDate(String userId, String loanId, Calendar dueDate);

    UserRequests getRequestsFromItem(Item item, boolean deleted);

    UserRequests getRequestsFromItem(String mms_id, String holding_id, String item_pid, boolean deleted);

    UserRequests getRequestsFromItem(String barcode, boolean deleted);

    UserRequest createPatronRequest(String barcode, String pickupLocationLibrary, String message, String ltId);

    UserRequest createPatronRequest(Item item, String pickupLocationLibrary, String message, String userId);

    UserRequest createPatronRequest(String mmsId, String userId, UserRequest newRequest);

    UserRequest createDigitizationRequest(String barcode, UserRequest.TargetDestination targetDestination,
            String message);

    UserRequest createDigitizationRequest(Item item, UserRequest.TargetDestination targetDestination, String message);

    UserRequest createDigitizationRequest(Item item, UserRequest.TargetDestination targetDestination, String message,
            String userId);

    void deleteItem(String mmsId, String holdingsId, String itemId, boolean override, HoldingsRecord holdingsRecord);

    void deleteItem(String barcode, boolean override, HoldingsRecord holdingsRecord);

    void deleteRequest(String barcode, String requestId);

    void deleteRequest(String barcode, String requestId, String note);

    UserRequest updateCommentOnRequest(String barcode, String requestId, String comment,
            boolean appendToExistingComment);

    UserRequest actionOnRequest(String barcode, String action, String requestId, boolean releaseItem);

    Item scanInItem(String barcode, String requestId, String department, String circDesk, String library);

    Item scanInItem(String barcode, String circDesk, String library);

    Representation updateRemoteDigitalItem(String mmsId, String representationId, Representation digitalItem);

    Item updateItemDescription(Item item);

}
