package no.unit.alma.acquisitions;

import no.unit.alma.generated.polines.Notes;
import no.unit.alma.generated.polines.PoLine;
import no.unit.alma.generated.polines.PoLines;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.items.Item;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class AlmaPOLineService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmaPOLineService.class);

    public static final String POLINES_PATH = "po-lines";
    public static final String ACQUISITION_PATH = "acq";
    private static final String ITEMS = "items";

    private final transient WebTarget polinesTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;


    /**
     * Service for Polines.
     * @param almaClient almaClient
     */
    public AlmaPOLineService(AlmaClient almaClient) {
        this.polinesTarget = almaClient.getWebTarget().path(ACQUISITION_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    /**
     * Create a new Poline.
     * @param poLine the poline object
     * @return the new Poline
     */
    public PoLine create(@Nonnull PoLine poLine) {
        log.trace("Create poLine {} at {}", poLine.getNumber(), contextValue);
        return polinesTarget
                .path(POLINES_PATH)
                .request(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(poLine))
                .invoke(PoLine.class);
    }

    /**
     * Get a poline by its polineNumber.
     * @param id poline number
     * @return the poline
     */
    public PoLine read(@Nonnull String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("id is empty");
        }
        log.trace("Read poLine with id {} at {}", id, contextValue);
        return polinesTarget
                .queryParam("po_line_id", id)
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
    public PoLine update(@Nonnull PoLine poLine) {
        if (StringUtils.isEmpty(poLine.getNumber())) {
            throw new IllegalArgumentException("poLine.getNumber is empty");
        }
        log.trace("Update poLine {} at {}", poLine.getNumber(), contextValue);
        return polinesTarget
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
    public void delete(@Nonnull PoLine poLine) {
        if (StringUtils.isEmpty(poLine.getNumber())) {
            throw new IllegalArgumentException("poLine.getNumber is empty");
        }
        String comment = "*Cancellation via api.";
        log.trace("Delete poLine {} at {}. Comment: {}", poLine.getNumber(), contextValue, comment);
        polinesTarget
                .path(POLINES_PATH)
                .path(poLine.getNumber())
                .queryParam("reaason", "LIBRARY_CANCELLED")
                .queryParam("comment", comment)
                .queryParam("inform_vendor", false)
                .queryParam("override", false)
                .queryParam("bib", "retain") //delete or suppress
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
        final String status = "ACTIVE";
        final String acquisitionMethod = "LEGAL_DEPOSIT,LEGAL_DEPOSIT_NOLETTER";
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
        WebTarget webTarget = polinesTarget
                .path(POLINES_PATH)
                .queryParam("q", q)
                .queryParam("status", status)
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .queryParam("acquisition_method", acquisitionMethod);
        if (StringUtils.isNotEmpty(orderBy)) {
            webTarget = webTarget
                    .queryParam("order_by", orderBy)
                    .queryParam("direction", "desc");
        }
        if (expand) {
            webTarget = webTarget
                    .queryParam("expand", "LOCATIONS,NOTES");
        }
        if (StringUtils.isNotEmpty(library)) {
            webTarget = webTarget
                    .queryParam("library", library);
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
        return polinesTarget
                .path(POLINES_PATH)
                .path(poLineNumber)
                .path(ITEMS)
                .path(itemId)
                .queryParam("op", "receive")
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
    public PoLines search(@Nonnull String query, @Nonnull String status, int offset, int limit,
                           @Nullable String library, @Nullable String orderBy, boolean expand) {
        if (StringUtils.isEmpty(status)) {
            throw new IllegalArgumentException("status is null or empty");
        }
        log.trace("Retriveving poLines matching {} with status {} at {}", query, status, contextValue);
        return this.queryPoLines(query, status, offset, limit,
                "LEGAL_DEPOSIT,LEGAL_DEPOSIT_NOLETTER", library, orderBy, expand);
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
