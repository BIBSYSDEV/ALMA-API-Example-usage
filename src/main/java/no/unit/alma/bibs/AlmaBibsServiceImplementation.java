package no.unit.alma.bibs;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import no.bibsys.alma.rest.bibs.Bib;
import no.bibsys.alma.rest.bibs.Bibs;
import no.bibsys.alma.rest.items.Item;
import no.bibsys.alma.rest.items.ItemData;
import no.bibsys.alma.rest.representations.Representation;
import no.bibsys.alma.rest.representations.Representations;
import no.bibsys.alma.rest.user_request.UserRequests;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

/**
 * This client implements an integration to the /almaws/v1/bibs
 */
public class AlmaBibsServiceImplementation implements AlmaBibsService {

    private final WebTarget bibsTarget;
    private final WebTarget itemsTarget;
    private final String context;
    private final String contextValue;
    private final AlmaStage almaStage;

    public AlmaBibsServiceImplementation(AlmaClient almaClient) {
        this.bibsTarget = almaClient.getWebTarget().path("bibs");
        this.itemsTarget = almaClient.getWebTarget().path("items");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    @Override
    public Bib getBib(String identifier, String availParams) {
        WebTarget getBibTarget =
                bibsTarget
                        .path(identifier);
        if (StringUtils.isNotEmpty(availParams)) {
            getBibTarget = getBibTarget.queryParam("expand", availParams);
        }
        return getBibTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Bib.class);
    }

    /**
     * Add bib record to collection
     *
     * @param mmsId        of the bib record
     * @param collectionId
     */
    @Override
    public void addBibToCollection(String mmsId, String collectionId) {
        final String bibXmlString = String.format("<bib>\n<mms_id>%s</mms_id>\n</bib>\n", mmsId);
        bibsTarget
                .path("collections")
                .path(collectionId)
                .path("bibs")
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(bibXmlString))
                .invoke()
                .close();
    }

    /**
     * Create linked record in IZ that points to the record in NZ with given mmsId.
     *
     * @param mmsId of the record in NZ that ends with 2201 (Example
     *              991441774984702201)
     * @return true if record is created that links from IZ to the NZ. Returns false
     *         if linked record already exists.
     */
    @Override
    public Bib createLinkedRecord(String mmsId) {
        return bibsTarget
                .queryParam("from_nz_mms_id", mmsId)
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(new Bib()))
                .invoke(Bib.class);
    }

    @Override
    public Bib updateBib(final Bib bib) {
        return bibsTarget
                .path(bib.getMmsId())
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(bib))
                .invoke(Bib.class);
    }

    @Override
    public UserRequests getRequestsFromBib(String recordIdentifier, boolean deleted) {
        WebTarget userRequestsTarget =
                bibsTarget
                        .path(recordIdentifier)
                        .path("requests");
        if (deleted) {
            userRequestsTarget =
                    userRequestsTarget
                            .queryParam("request_type", "DIGITIZATION")
                            .queryParam("status", "history");
        }
        return userRequestsTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(UserRequests.class);
    }

    private Representation createRemotePresentation(String mmsId, Representation representation) {
        return bibsTarget
                .path(mmsId)
                .path("representations")
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(representation))
                .invoke(Representation.class);
    }

    @Override
    public Representation createRemotePresentation(String barcode, String access, String digitalRepositoryId,
            String url, String libraryCode) {
        final Item item = getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue("DERIVATIVE_COPY");
        input.setUsageType(usageType);
        final Representation.Repository repository = new Representation.Repository();
        repository.setValue(digitalRepositoryId);
        input.setOriginatingRecordId(url);
        input.setRepository(repository);
        input.setLinkingParameter1(url);
        input.setLinkingParameter4(barcode);
        final String label = createLabel(item);
        input.setLabel(label);
        input.setPublicNote(access);

        return createRemotePresentation(mmsId, input);
    }

    @Override
    public Representation createRemotePresentation(String mmsId, String barcode, String access,
            String digitalRepositoryId, String url, String libraryCode) {
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue("DERIVATIVE_COPY");
        input.setUsageType(usageType);
        final Representation.Repository repository = new Representation.Repository();
        repository.setValue(digitalRepositoryId);
        input.setOriginatingRecordId(url);
        input.setRepository(repository);
        input.setLinkingParameter1(url);
        input.setLinkingParameter4(barcode);
        input.setPublicNote(access);

        return createRemotePresentation(mmsId, input);
    }

    @Override
    public Representation createRemotePresentation(long mmsId, String access, String remoteRepositoryId,
            String libraryCode, String url, String year, String month, String day, String volume, String issue,
            String number) {
        final String mmsIdAsString = Long.toString(mmsId);
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue("DERIVATIVE_COPY");
        input.setUsageType(usageType);
        final Representation.Repository repository = new Representation.Repository();
        repository.setValue(remoteRepositoryId);
        input.setRepository(repository);
        input.setLinkingParameter1(url);
        input.setLinkingParameter4("" + mmsId);
        input.setOriginatingRecordId(url);
        String label = createLabel(volume, issue, number, "", year, month, day, "");
        input.setLabel(label);
        input.setYear(year);
        input.setSeasonMonth(month);
        input.setDayInMonth(day);
        input.setVolume(volume);
        input.setIssue(issue);
        input.setNumber(number);
        input.setPublicNote(access);

        return createRemotePresentation(mmsIdAsString, input);
    }

    @Override
    public Representation createRemotePresentation(String barcode, String access, String remoteRepositoryId,
            String libraryCode, String url, String year, String month, String day, String volume, String issue,
            String number) {
        final Item item = getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue("DERIVATIVE_COPY");
        input.setUsageType(usageType);
        final Representation.Repository repository = new Representation.Repository();
        repository.setValue(remoteRepositoryId);
        input.setRepository(repository);
        input.setLinkingParameter1(url);
        input.setLinkingParameter4(barcode);
        input.setOriginatingRecordId(url);
        final String label = createLabel(volume, issue, number, "", year, month, day, "");
        input.setLabel(label);
        input.setYear(year);
        input.setSeasonMonth(month);
        input.setDayInMonth(day);
        input.setVolume(volume);
        input.setIssue(issue);
        input.setNumber(number);
        input.setPublicNote(access);

        return createRemotePresentation(mmsId, input);
    }

    @Override
    public Representation createRemotePresentation(String barcode, String label, String access,
            String remoteRepositoryId, String libraryCode, String url, String year, String month, String day,
            String volume, String issue, String number) {
        final Item item = getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue("DERIVATIVE_COPY");
        input.setUsageType(usageType);
        final Representation.Repository repository = new Representation.Repository();
        repository.setValue(remoteRepositoryId);
        input.setRepository(repository);
        input.setLinkingParameter1(url);
        input.setLinkingParameter4(barcode);
        input.setOriginatingRecordId(url);
        input.setLabel(label);
        input.setYear(year);
        input.setSeasonMonth(month);
        input.setDayInMonth(day);
        input.setVolume(volume);
        input.setIssue(issue);
        input.setNumber(number);
        input.setPublicNote(access);

        return createRemotePresentation(mmsId, input);
    }

    private Item getItem(String barcode) {
        return itemsTarget
                .queryParam("item_barcode", barcode)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Item.class);
    }

    @Override
    public Representations getRemoteRepresentationsFromMmsId(String mmsId, int limit, int offset) {
        return bibsTarget
                .path(mmsId)
                .path("representations")
                .queryParam("limit", limit)
                .queryParam("offset", offset)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Representations.class);
    }

    @Override
    public Representation getSingleRemoteRepresentationFromBarcode(String barcode, String representationId) {
        final Item item = getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        return getSingleRemoteRepresentationFromMmsId(mmsId, representationId);
    }

    @Override
    public Representation getSingleRemoteRepresentationFromMmsId(String mmsId, String representationId) {
        return bibsTarget
                .path(mmsId)
                .path("representations")
                .path(representationId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Representation.class);
    }

    @Override
    public Bibs retrieveBibs(String mms_id, String ie_id, String holdings_id, String representation_id,
            String nz_mms_id, String view, String expand) {
        return bibsTarget
                .queryParam("mms_id", mms_id)
                .queryParam("ie_id", ie_id)
                .queryParam("holdings_id", holdings_id)
                .queryParam("representation_id", representation_id)
                .queryParam("nz_mms_id", nz_mms_id)
                .queryParam("view", view)
                .queryParam("expand", expand)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Bibs.class);
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

    private String createLabel(String enumerationA, String enumerationB, String enumerationC, String enumerationD,
            String chronologyI, String chronologyJ, String chronologyK, String chronologyL) {

        enumerationA = (enumerationA != null ? enumerationA.trim() : "");
        enumerationB = (enumerationB != null ? enumerationB.trim() : "");
        enumerationC = (enumerationC != null ? enumerationC.trim() : "");
        enumerationD = (enumerationD != null ? enumerationD.trim() : "");
        chronologyI = (chronologyI != null ? chronologyI.trim() : "");
        chronologyJ = (chronologyJ != null ? chronologyJ.trim() : "");
        chronologyK = (chronologyK != null ? chronologyK.trim() : "");
        chronologyL = (chronologyL != null ? chronologyL.trim() : "");

        String label = enumerationA;

        if (!"".equals(chronologyI)) {
            label +=
                    "(" + chronologyI + (!"".equals(chronologyJ) ? "," + chronologyJ : "")
                            + (!"".equals(chronologyK) ? "," + chronologyK : "")
                            + (!"".equals(chronologyL) ? "," + chronologyL : "") + ")";
        }
        if (!"".equals(enumerationB)) {
            label +=
                    " " + enumerationB + (!"".equals(enumerationC) ? "," + enumerationC : "")
                            + (!"".equals(enumerationD) ? "," + enumerationD : "");
        }

        if (label == null) {
            label = "";
        }

        return label;
    }

    private String createLabel(Item item) {

        ItemData itemData = item.getItemData();
        return createLabel(itemData.getEnumerationA(), itemData.getEnumerationB(), itemData.getEnumerationC(),
                itemData.getEnumerationD(), itemData.getChronologyI(), itemData.getChronologyJ(),
                itemData.getChronologyK(), itemData.getChronologyL());

    }

}
