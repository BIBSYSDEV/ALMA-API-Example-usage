package no.unit.alma.bibs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.generated.bibs.Bib;
import no.unit.alma.generated.bibs.Bibs;
import no.unit.alma.generated.items.BibData;
import no.unit.alma.generated.items.HoldingData;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.ItemData;
import no.unit.alma.generated.representations.Representation;
import no.unit.alma.generated.representations.Representations;
import no.unit.alma.generated.userrequests.UserRequests;
import no.unit.alma.commons.AlmaClient;

@ExtendWith(MockitoExtension.class)
class AlmaBibsClientTest {

    private static final String TEST_MMS_ID = "123456";
    private static final long TEST_MMS_ID_NUMBER = 123456;
    private static final String TEST_HOLDING_ID = "12345";
    private static final String TEST_COLLECTION_ID = "654321";
    private static final String REPRESENTATION_ID = "1234";
    private static final String TEST_IE_ID = "123456789";
    private static final String TEST_NZ_MMS_ID = "234567";

    private static final String TEST_BARCODE = "barcode";
    private static final String TEST_ACCESS = "access";
    private static final String TEST_DIGITAL_REPOSITORY_ID = "digitalRepositoryId";
    private static final String TEST_URL = "url";
    private static final String TEST_LIBRARY_CODE = "libraryCode";
    private static final String TEST_REMOTE_REPOSITORY_ID = "remoteRepositoryId";
    private static final String TEST_YEAR = "year";
    private static final String TEST_MONTH = "month";
    private static final String TEST_DAY = "day";
    private static final String TEST_VOLUME = "volume";
    private static final String TEST_ISSUE = "issue";
    private static final String TEST_NUMBER = "number";
    private static final String TEST_LABEL = "label";
    private static final String TEST_EXPAND = "expand";
    private static final String TEST_VIEW = "view";

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";

    @Mock
    private AlmaClient mockAlmaApiClient;

    @Mock
    private WebTarget webTarget;

    @Mock
    private WebTarget bibsWebTarget;

    @Mock
    private WebTarget itemsWebTarget;

    @Mock
    private Builder bibsBuilder;

    @Mock
    private Builder itemsBuilder;

    @Mock
    private Invocation bibsInvocation;

    @Mock
    private Invocation itemsInvocation;

    @Mock
    private Response response;
    private Bib bib;
    private Item item;

    @Test
    void testGetBib() throws IOException, InterruptedException {

        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.path(any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsWebTarget.queryParam(anyString(), any())).thenReturn(bibsWebTarget);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildGet()).thenReturn(bibsInvocation);
        Bib tempBib = new Bib();
        tempBib.setTitle("test");
        when(bibsInvocation.invoke((Class<Object>) any())).thenReturn(tempBib);
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);

        Bib resultBib = almaBibsService.getBib(TEST_MMS_ID, "true");
        assertEquals("test", resultBib.getTitle());

        resultBib = almaBibsService.getBib(TEST_MMS_ID, "");
        assertEquals("test", resultBib.getTitle());
    }

    @Test
    void testUpdateBib() throws IOException, InterruptedException {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.path(any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildPut(Entity.xml(bib))).thenReturn(bibsInvocation);
        when(bibsInvocation.invoke((Class<Object>) any())).thenReturn(bib);
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);

        Bib updatedBib = almaBibsService.updateBib(bib);
        assertEquals("test", updatedBib.getTitle());
    }

    @Test
    void testAddBibToCollection() throws IOException, InterruptedException {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.path(any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildPost(any())).thenReturn(bibsInvocation);
        when(bibsInvocation.invoke()).thenReturn(response);
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);

        almaBibsService.addBibToCollection(TEST_MMS_ID, TEST_COLLECTION_ID);
    }

    @Test
    void testGetSingleRemoteRepresentation() {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.path(any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildGet()).thenReturn(bibsInvocation);

        Representation representation = new Representation();
        representation.setTitle("test");

        when(bibsInvocation.invoke((Class<Representation>) any())).thenReturn(representation);

        mockGetItem();

        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);

        Representation testMmsIdRepresentation =
                almaBibsService.getSingleRemoteRepresentationFromMmsId(TEST_MMS_ID, REPRESENTATION_ID);
        assertEquals("test", testMmsIdRepresentation.getTitle());

        Representation testBarcodeRepresentation =
                almaBibsService.getSingleRemoteRepresentationFromBarcode(TEST_BARCODE, REPRESENTATION_ID);
        assertEquals("test", testBarcodeRepresentation.getTitle());
    }

    @Test
    void testGetRemoteRepresentations() {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.path(any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsWebTarget.queryParam(anyString(), any())).thenReturn(bibsWebTarget);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildGet()).thenReturn(bibsInvocation);

        Representations representations = new Representations();
        representations.setTotalRecordCount(5l);

        when(bibsInvocation.invoke((Class<Representations>) any())).thenReturn(representations);
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);

        Representations remoteRepresentations =
                almaBibsService.getRemoteRepresentationsFromMmsId(TEST_MMS_ID, 10, 0);
        assertEquals(5l, remoteRepresentations.getTotalRecordCount());

    }

    @Test
    void testCreateRemoteRepresentation() {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.path(any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildPost(any())).thenReturn(bibsInvocation);

        Representation representation = new Representation();
        representation.setTitle("test");
        representation.setLabel(TEST_LABEL);

        when(bibsInvocation.invoke((Class<Representation>) any())).thenReturn(representation);

        mockGetItem();

        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);

        Representation remotePresentation =
                almaBibsService.createRemotePresentation(TEST_BARCODE, TEST_ACCESS,
                        TEST_DIGITAL_REPOSITORY_ID, TEST_URL, TEST_LIBRARY_CODE);
        assertEquals("test", remotePresentation.getTitle());

        remotePresentation =
                almaBibsService.createRemotePresentation(TEST_BARCODE, TEST_ACCESS,
                        TEST_DIGITAL_REPOSITORY_ID, TEST_URL, TEST_LIBRARY_CODE);
        assertEquals("test", remotePresentation.getTitle());

        remotePresentation =
                almaBibsService.createRemoteRepresentation(TEST_MMS_ID, TEST_BARCODE, TEST_ACCESS,
                        TEST_DIGITAL_REPOSITORY_ID, TEST_URL, TEST_LIBRARY_CODE);
        assertEquals("test", remotePresentation.getTitle());

        remotePresentation =
                almaBibsService.createRemoteRepresentation(TEST_MMS_ID_NUMBER, TEST_ACCESS,
                        TEST_REMOTE_REPOSITORY_ID, TEST_LIBRARY_CODE, TEST_URL, TEST_YEAR, TEST_MONTH, TEST_DAY,
                        TEST_VOLUME, TEST_ISSUE, TEST_NUMBER);
        assertEquals("test", remotePresentation.getTitle());

        remotePresentation =
                almaBibsService.createRemoteRepresentation(TEST_BARCODE, TEST_ACCESS,
                        TEST_REMOTE_REPOSITORY_ID, TEST_LIBRARY_CODE, TEST_URL, TEST_YEAR, TEST_MONTH, TEST_DAY,
                        TEST_VOLUME, TEST_ISSUE, TEST_NUMBER);
        assertEquals("test", remotePresentation.getTitle());

        remotePresentation =
                almaBibsService.createRemoteRepresentation(TEST_BARCODE, TEST_LABEL, TEST_ACCESS,
                        TEST_REMOTE_REPOSITORY_ID, TEST_LIBRARY_CODE, TEST_URL, TEST_YEAR, TEST_MONTH, TEST_DAY,
                        TEST_VOLUME, TEST_ISSUE, TEST_NUMBER);
        assertEquals("test", remotePresentation.getTitle());

        remotePresentation =
                almaBibsService.createRemoteRepresentation(TEST_BARCODE, TEST_LABEL, TEST_ACCESS,
                        TEST_REMOTE_REPOSITORY_ID, TEST_LIBRARY_CODE, TEST_URL, "", "", "",
                        "", "", "");
        assertEquals(TEST_LABEL, remotePresentation.getLabel());

    }

    @Test
    void testCreateLinkedRecord() {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsWebTarget.queryParam(anyString(), any())).thenReturn(bibsWebTarget);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildPost(any())).thenReturn(bibsInvocation);
        when(bibsInvocation.invoke((Class<Object>) any())).thenReturn(bib);
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);

        Bib linkedRecord = almaBibsService.createLinkedRecord(TEST_MMS_ID);
        assertEquals("test", linkedRecord.getTitle());
    }

    @Test
    void testRetrieveBibs() {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsWebTarget.queryParam(anyString(), any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildGet()).thenReturn(bibsInvocation);

        Bibs bibs = new Bibs();
        bibs.setTotalRecordCount(5);

        when(bibsInvocation.invoke((Class<Object>) any())).thenReturn(bibs);
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);
        Bibs retrieveBibs =
                almaBibsService.retrieveBibs(TEST_MMS_ID, TEST_IE_ID, TEST_HOLDING_ID, REPRESENTATION_ID,
                        TEST_NZ_MMS_ID, TEST_VIEW, TEST_EXPAND);
        assertEquals(5, retrieveBibs.getTotalRecordCount());
    }

    @Test
    void testGetRequestsFromBib() {
        mockAlmaApi();

        when(webTarget.path("bibs")).thenReturn(bibsWebTarget);
        when(bibsWebTarget.path(any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsWebTarget.queryParam(anyString(), any())).thenReturn(bibsWebTarget);
        when(bibsWebTarget.request()).thenReturn(bibsBuilder);
        when(bibsBuilder.accept(anyString())).thenReturn(bibsBuilder);
        when(bibsBuilder.buildGet()).thenReturn(bibsInvocation);

        UserRequests userRequests = new UserRequests();
        userRequests.setTotalRecordCount(5);
        when(bibsInvocation.invoke((Class<UserRequests>) any())).thenReturn(userRequests);

        AlmaBibsService almaBibsService = new AlmaBibsService(mockAlmaApiClient);
        UserRequests requestsFromBib = almaBibsService.getRequestsFromBib(TEST_MMS_ID, false);
        assertEquals(5, requestsFromBib.getTotalRecordCount());

        requestsFromBib = almaBibsService.getRequestsFromBib(TEST_MMS_ID, true);
        assertEquals(5, requestsFromBib.getTotalRecordCount());

    }

    @Test
    void testGetAlmaStage() {
        mockAlmaApi();
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);
        assertEquals(STAGE, almaBibsService.getAlmaStage());
    }

    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaBibsService.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaBibsService almaBibsService =
                new AlmaBibsService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaBibsService.getContextValue());
    }

    private void mockAlmaApi() {

        bib = new Bib();
        bib.setTitle("test");

        when(this.mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

    private void mockGetItem() {
        when(webTarget.path("items")).thenReturn(itemsWebTarget);
        when(itemsWebTarget.queryParam(anyString(), any())).thenReturn(itemsWebTarget);
        when(itemsWebTarget.request()).thenReturn(itemsBuilder);
        when(itemsBuilder.accept(anyString())).thenReturn(itemsBuilder);
        when(itemsBuilder.buildGet()).thenReturn(itemsInvocation);

        item = new Item();
        BibData bibData = new BibData();
        bibData.setMmsId(TEST_MMS_ID);
        HoldingData holdingData = new HoldingData();
        holdingData.setHoldingId(TEST_HOLDING_ID);
        ItemData itemData = new ItemData();
        itemData.setBarcode(TEST_BARCODE);
        item.setBibData(bibData);
        item.setItemData(itemData);

        when(itemsInvocation.invoke((Class<Item>) any())).thenReturn(item);
    }

}
