package no.unit.alma.acquisitions;

import no.unit.alma.generated.polines.PoLine;
import no.unit.alma.generated.polines.PoLines;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.items.Item;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class AlmaPOLineService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaPOLineService.class);

    public static final String QUERY_PARAM_REASON = "reason";
    public static final String QUERY_PARAM_REASON_LIBRARY_CANCELLED = "LIBRARY_CANCELLED";
    public static final String QUERY_PARAM_COMMENT = "comment";
    public static final String QUERY_PARAM_DEFAULT_CANCELLATION_COMMENT = "*Cancellation via api.";
    public static final String QUERY_PARAM_INFORM_VENDOR = "inform_vendor";
    public static final String QUERY_PARAM_OVERRIDE = "override";
    public static final String QUERY_PARAM_BIB = "bib";
    public static final String QUERY_PARAM_BIB_RETAIN = "retain";
    public static final String QUERY_PARAM_ACQUISITION_METHOD = "acquisition_method";
    public static final String LEGAL_DEPOSIT_LEGAL_DEPOSIT_NOLETTER = "LEGAL_DEPOSIT,LEGAL_DEPOSIT_NOLETTER";
    public static final String QUERY_PARAM_Q = "q";
    public static final String QUERY_PARAM_STATUS = "status";
    public static final String ACTIVE = "ACTIVE";
    public static final String QUERY_PARAM_LIMIT = "limit";
    public static final String QUERY_PARAM_OFFSET = "offset";
    public static final String QUERY_PARAM_ORDER_BY = "order_by";
    public static final String QUERY_PARAM_DIRECTION = "direction";
    public static final String DESC = "desc";
    public static final String QUERY_PARAM_EXPAND = "expand";
    public static final String LOCATIONS_NOTES = "LOCATIONS,NOTES";
    public static final String QUERY_PARAM_LIBRARY = "library";
    public static final String QUERY_PRAM_OP = "op";
    public static final String RECEIVE = "receive";

    public static final String POLINES_PATH = "po-lines";
    public static final String ACQUISITION_PATH = "acq";
    private static final String ITEMS_PATH = "items";

    private final transient WebTarget acqTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;


    /**
     * Service for Polines.
     * @param almaClient almaClient
     */
    public AlmaPOLineService(AlmaClient almaClient) {
        this.acqTarget = almaClient.getWebTarget().path(ACQUISITION_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    /**
     * Create a new Poline.
     * @param poLine the poline object
     * @return the new Poline
     */
    public PoLine createPoline(@Nonnull PoLine poLine) {
        log.trace("Create poLine {} at {}", poLine.getNumber(), contextValue);
        return acqTarget
                .path(POLINES_PATH)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(poLine))
                .invoke(PoLine.class);
    }

    /**
     * Get a poline by its polineNumber.
     * @param id poline number
     * @return the poline
     */
    public PoLine getPoline(@Nonnull String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("id is empty");
        }
        log.trace("Read poLine with id {} at {}", id, contextValue);
        return acqTarget
                .path(POLINES_PATH)
                .path(id)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(PoLine.class);
    }

    /**
     * updates a poline.
     * @param poLine the poline to update
     * @return the updated poline
     */
    public PoLine updatePoline(@Nonnull PoLine poLine) {
        if (StringUtils.isEmpty(poLine.getNumber())) {
            throw new IllegalArgumentException("poLine.getNumber is empty");
        }
        log.trace("Update poLine {} at {}", poLine.getNumber(), contextValue);
        return acqTarget
                .path(POLINES_PATH)
                .path(poLine.getNumber())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(poLine))
                .invoke(PoLine.class);
    }

    /**
     * Deletes a poline.
     * @param poLine the poline to delete
     */
    public void deletePoline(@Nonnull PoLine poLine) {
        if (StringUtils.isEmpty(poLine.getNumber())) {
            throw new IllegalArgumentException("poLine.getNumber is empty");
        }
        log.trace("Delete poLine {} at {}. Comment: {}", poLine.getNumber(), contextValue, QUERY_PARAM_DEFAULT_CANCELLATION_COMMENT);
        acqTarget
                .path(POLINES_PATH)
                .path(poLine.getNumber())
                .queryParam(QUERY_PARAM_REASON, QUERY_PARAM_REASON_LIBRARY_CANCELLED)
                .queryParam(QUERY_PARAM_COMMENT, QUERY_PARAM_DEFAULT_CANCELLATION_COMMENT)
                .queryParam(QUERY_PARAM_INFORM_VENDOR, false)
                .queryParam(QUERY_PARAM_OVERRIDE, false)
                .queryParam(QUERY_PARAM_BIB, QUERY_PARAM_BIB_RETAIN) //delete or suppress
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
    }

    /**
     * retrieves all ACTIVE polines.
     * @return list of active polines
     */
    public List<PoLines> readAllActive() {
        log.trace("Retriveving all poLines at {}", contextValue);
        final String q = "";
        final String status = ACTIVE;
        final String acquisitionMethod = LEGAL_DEPOSIT_LEGAL_DEPOSIT_NOLETTER;
        int limit = 50;
        int offset = 0;
        List<PoLines> poLinesList = new ArrayList<>();
        PoLines poLines = this.queryPoLines(q, status, offset, limit, acquisitionMethod, null, null,
                true);
        poLinesList.add(poLines);
        Integer recordCount = poLines.getTotalRecordCount();

        while (recordCount > offset + limit) {
            offset += limit;
            poLinesList.add(this.queryPoLines(q, status, offset, limit, acquisitionMethod, null,
                    null, true));
        }
        return poLinesList;
    }

    /**
     * Search for PoLines.
     * @param q search criteria
     * @param status status of the order lines (e.g. ACTIVE)
     * @param offset offset of the retrieval
     * @param limit limit of the retrieval
     * @param acquisitionMethod e.g. LEGAL_DEPOSIT
     * @param library narrow the search by library code
     * @param orderBy sorting param
     * @param expand expand by NOTE and LOCATION
     * @return list of Polines
     */
    public PoLines queryPoLines(String q, String status, int offset, int limit, String acquisitionMethod, String
            library, String orderBy, boolean expand) {
        WebTarget webTarget = acqTarget
                .path(POLINES_PATH)
                .queryParam(QUERY_PARAM_Q, q)
                .queryParam(QUERY_PARAM_STATUS, status)
                .queryParam(QUERY_PARAM_LIMIT, limit)
                .queryParam(QUERY_PARAM_OFFSET, offset)
                .queryParam(QUERY_PARAM_ACQUISITION_METHOD, acquisitionMethod);
        if (StringUtils.isNotEmpty(orderBy)) {
            webTarget = webTarget
                    .queryParam(QUERY_PARAM_ORDER_BY, orderBy)
                    .queryParam(QUERY_PARAM_DIRECTION, DESC);
        }
        if (expand) {
            webTarget = webTarget
                    .queryParam(QUERY_PARAM_EXPAND, LOCATIONS_NOTES);
        }
        if (StringUtils.isNotEmpty(library)) {
            webTarget = webTarget
                    .queryParam(QUERY_PARAM_LIBRARY, library);
        }
        return webTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(PoLines.class);
    }

    /**
     * Receive an existing item.
     * @param itemId barcode
     * @param poLineNumber order number
     * @return the item
     */
    public Item receiveItem(@Nonnull String itemId, @Nonnull String poLineNumber) {
        if (StringUtils.isEmpty(itemId)) {
            throw new IllegalArgumentException("itemId is empty");
        }
        if (StringUtils.isEmpty(poLineNumber)) {
            throw new IllegalArgumentException("poLineId is empty");
        }
        log.trace("Receiving item (Id={}) on poLine (Id={}) at {}", itemId, poLineNumber, contextValue);
        return acqTarget
                .path(POLINES_PATH)
                .path(poLineNumber)
                .path(ITEMS_PATH)
                .path(itemId)
                .queryParam(QUERY_PRAM_OP, RECEIVE)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(new Item()))
                .invoke(Item.class);
    }

    /**
     * Search for PoLines.
     * @param query search criteria
     * @param status status of the order lines (e.g. ACTIVE)
     * @param offset offset of the retrieval
     * @param limit limit of the retrieval
     * @param library narrow the search by library code
     * @param orderBy sorting param
     * @param expand expand by NOTE and LOCATION
     * @return list of polines
     */
    public PoLines searchPolines(@Nonnull String query, @Nonnull String status, int offset, int limit,
                                 @Nullable String library, @Nullable String orderBy, boolean expand) {
        if (StringUtils.isEmpty(status)) {
            throw new IllegalArgumentException("status is null or empty");
        }
        log.trace("Retriveving poLines matching {} with status {} at {}", query, status, contextValue);
        return this.queryPoLines(query, status, offset, limit, LEGAL_DEPOSIT_LEGAL_DEPOSIT_NOLETTER, library, orderBy,
                expand);
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
