package no.unit.alma.bibs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.bibs.Bib;
import no.unit.alma.generated.bibs.Bibs;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.ItemData;
import no.unit.alma.generated.representations.Representation;
import no.unit.alma.generated.representations.Representations;
import no.unit.alma.generated.userrequests.UserRequests;

/**
 * This client implements an integration to the /almaws/v1/bibs
 */
public class AlmaBibsService {

    private static final String EMPTY_STRING = "";
    private static final String DERIVATIVE_COPY = "DERIVATIVE_COPY";
    private final transient WebTarget bibsTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;
    private final transient AlmaItemsService almaItemsService;

    public AlmaBibsService(AlmaClient almaClient) {

        almaItemsService = new AlmaItemsService(almaClient);

        this.bibsTarget = almaClient.getWebTarget().path("bibs");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

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

    public void addBibToCollection(String mmsId, String collectionId) {
        final String bibXmlString = String.format("<bib>\n<mms_id>%s</mms_id>\n</bib>\n", mmsId);
        bibsTarget
                .path("collections")
                .path(collectionId)
                .path("bibs")
                .request()
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

    public Bib createLinkedRecord(String mmsId) {
        return bibsTarget
                .queryParam("from_nz_mms_id", mmsId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(new Bib()))
                .invoke(Bib.class);
    }

    public Bib updateBib(final Bib bib) {
        return bibsTarget
                .path(bib.getMmsId())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(bib))
                .invoke(Bib.class);
    }

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
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(representation))
                .invoke(Representation.class);
    }

    public Representation createRemotePresentation(String barcode, String access, String digitalRepositoryId,
            String url, String libraryCode) {
        final Item item = almaItemsService.getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue(DERIVATIVE_COPY);
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

    public Representation createRemoteRepresentation(String mmsId, String barcode, String access,
            String digitalRepositoryId, String url, String libraryCode) {
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue(DERIVATIVE_COPY);
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

    @SuppressWarnings({ "PMD.ExcessiveParameterList" })
    public Representation createRemoteRepresentation(long mmsId, String access, String remoteRepositoryId,
            String libraryCode, String url, String year, String month, String day, String volume, String issue,
            String number) {
        final String mmsIdAsString = Long.toString(mmsId);
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue(DERIVATIVE_COPY);
        input.setUsageType(usageType);
        final Representation.Repository repository = new Representation.Repository();
        repository.setValue(remoteRepositoryId);
        input.setRepository(repository);
        input.setLinkingParameter1(url);
        input.setLinkingParameter4(EMPTY_STRING + mmsId);
        input.setOriginatingRecordId(url);
        String label = createLabel(volume, issue, number, EMPTY_STRING, year, month, day, EMPTY_STRING);
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

    @SuppressWarnings({ "PMD.ExcessiveParameterList" })
    public Representation createRemoteRepresentation(String barcode, String access, String remoteRepositoryId,
            String libraryCode, String url, String year, String month, String day, String volume, String issue,
            String number) {
        final Item item = almaItemsService.getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue(DERIVATIVE_COPY);
        input.setUsageType(usageType);
        final Representation.Repository repository = new Representation.Repository();
        repository.setValue(remoteRepositoryId);
        input.setRepository(repository);
        input.setLinkingParameter1(url);
        input.setLinkingParameter4(barcode);
        input.setOriginatingRecordId(url);
        final String label = createLabel(volume, issue, number, EMPTY_STRING, year, month, day, EMPTY_STRING);
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

    @SuppressWarnings({ "PMD.ExcessiveParameterList" })
    public Representation createRemoteRepresentation(String barcode, String label, String access,
            String remoteRepositoryId, String libraryCode, String url, String year, String month, String day,
            String volume, String issue, String number) {
        final Item item = almaItemsService.getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        final Representation input = new Representation();
        input.setIsRemote(true);
        final Representation.Library library = new Representation.Library();
        library.setValue(libraryCode);
        input.setLibrary(library);
        final Representation.UsageType usageType = new Representation.UsageType();
        usageType.setValue(DERIVATIVE_COPY);
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

    public Representation getSingleRemoteRepresentationFromBarcode(String barcode, String representationId) {

        final Item item = almaItemsService.getItem(barcode);
        final String mmsId = item.getBibData().getMmsId();
        return getSingleRemoteRepresentationFromMmsId(mmsId, representationId);
    }

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

    public Bibs retrieveBibs(String mmsId, String ieId, String holdingsId, String representationId,
            String nzMmsId, String view, String expand) {
        return bibsTarget
                .queryParam("mms_id", mmsId)
                .queryParam("ie_id", ieId)
                .queryParam("holdings_id", holdingsId)
                .queryParam("representation_id", representationId)
                .queryParam("nz_mms_id", nzMmsId)
                .queryParam("view", view)
                .queryParam("expand", expand)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Bibs.class);
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

    private String createLabel(String enumerationA, String enumerationB, String enumerationC, String enumerationD,
            String chronologyI, String chronologyJ, String chronologyK, String chronologyL) {

        List<String> enumerationList =
                Arrays.asList(new String[] { enumerationB, enumerationC, enumerationD })
                        .stream()
                        .filter(enumeration -> enumeration != null && !enumeration.isBlank())
                        .map(enumeration -> enumeration.strip())
                        .collect(Collectors.toList());

        List<String> chronologyList =
                Arrays.asList(new String[] { chronologyI, chronologyJ, chronologyK, chronologyL })
                        .stream()
                        .filter(chronology -> chronology != null && !chronology.isBlank())
                        .map(chronology -> chronology.strip())
                        .collect(Collectors.toList());

        String label = enumerationA != null && !enumerationA.isBlank() ? enumerationA : EMPTY_STRING;

        if (!EMPTY_STRING.equals(chronologyI)) {
            label = String.format("%s(%s)", label, String.join(label, chronologyList));
        }
        if (!EMPTY_STRING.equals(enumerationB)) {
            label = String.format("%s %s", label, String.join(label, enumerationList));
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
