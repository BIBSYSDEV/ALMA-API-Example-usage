package no.unit.alma.acquisitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.items.Item;
import no.unit.alma.generated.items.ItemData;
import no.unit.alma.generated.polines.PoLine;
import no.unit.alma.generated.polines.PoLines;

@ExtendWith(MockitoExtension.class)
class AlmaPOLineServiceTest {

    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";
    private static final String TEST_ID = "POL-124356";
    private static final String TEST_BARCODE = "124356";
    public static final String EMPTY_STRING = "";
    public static final int A_BUNCH_OF_POLINES = 152;
    public static final int AMOUNT_OF_POLINES_RETREIVALS = 4;
    public static final int AMOUNT_OF_POLINES = 2;
    public static final String QUERY = "q";
    public static final String CLOSED = "CLOSED";
    public static final String LIBRARY_NUMBER = "0183331";
    public static final String ORDER_BY_TITLE = "title";

    @Mock
    private AlmaClient mockAlmaApiClient;
    @Mock
    private WebTarget webTarget;
    @Mock
    private WebTarget acqTarget;
    @Mock
    private WebTarget polineTarget;
    @Mock
    private Invocation.Builder builder;
    @Mock
    private Invocation invocation;
    @Mock
    Response response;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreatePoline() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(acqTarget);
        when(acqTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        PoLine mockPoline = new PoLine();
        mockPoline.setNumber(TEST_ID);
        when(builder.buildPost(Entity.xml(mockPoline))).thenReturn(invocation);
        when(invocation.invoke((Class<PoLine>) any())).thenReturn(mockPoline);

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        PoLine poLine = almaPOLineService.createPoline(mockPoline);
        assertEquals(TEST_ID, poLine.getNumber());
    }

    @Test
    void testGetPoline() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        PoLine mockPoline = new PoLine();
        mockPoline.setNumber(TEST_ID);
        when(invocation.invoke((Class<Object>) any())).thenReturn(mockPoline);

        AlmaPOLineService almaPOLineService =
                new AlmaPOLineService(mockAlmaApiClient);
        PoLine resultPoline = almaPOLineService.getPoline(TEST_ID);
        assertEquals(mockPoline.getNumber(), resultPoline.getNumber());

        assertThrows(IllegalArgumentException.class, () -> almaPOLineService.getPoline(EMPTY_STRING),
                "should have failed without an id.");
    }

    @Test
    void testUpdatePoline() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(acqTarget);
        when(acqTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        PoLine mockPoline = new PoLine();
        mockPoline.setNumber(TEST_ID);
        when(builder.buildPut(Entity.xml(mockPoline))).thenReturn(invocation);
        when(invocation.invoke((Class<PoLine>) any())).thenReturn(mockPoline);

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        PoLine poLine = almaPOLineService.updatePoline(mockPoline);
        assertEquals(TEST_ID, poLine.getNumber());

        mockPoline.setNumber(EMPTY_STRING);
        assertThrows(IllegalArgumentException.class, () -> almaPOLineService.updatePoline(mockPoline),
                "should have failed without poline_number.");
    }

    @Test
    void testDeletePoline() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.queryParam(anyString(), any())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildDelete()).thenReturn(invocation);
        when(invocation.invoke()).thenReturn(response);
        doNothing().when(response).close();

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        PoLine mockPoline = new PoLine();
        mockPoline.setNumber(TEST_ID);
        almaPOLineService.deletePoline(mockPoline);

        mockPoline.setNumber(EMPTY_STRING);
        assertThrows(IllegalArgumentException.class, () -> almaPOLineService.deletePoline(mockPoline),
                "should have failed without poline_number.");
    }

    @Test
    void readAllActive() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(acqTarget);
        when(acqTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.queryParam(anyString(), any())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        PoLines mockPolines = new PoLines();
        mockPolines.setTotalRecordCount(Integer.valueOf(A_BUNCH_OF_POLINES));
        when(invocation.invoke((Class<Object>) any())).thenReturn(mockPolines);

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        List<PoLines> poLines = almaPOLineService.readAllActive();
        assertEquals(AMOUNT_OF_POLINES_RETREIVALS, poLines.size());
    }

    @Test
    void queryPoLines() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(acqTarget);
        when(acqTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.queryParam(anyString(), any())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        PoLines mockPolines = new PoLines();
        mockPolines.setTotalRecordCount(Integer.valueOf(AMOUNT_OF_POLINES));
        when(invocation.invoke((Class<Object>) any())).thenReturn(mockPolines);

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        String q = QUERY;
        String status = CLOSED;
        int offset = 0;
        int limit = 5;
        String acquisitionMethod = AlmaPOLineService.LEGAL_DEPOSIT_LEGAL_DEPOSIT_NOLETTER;
        String library = LIBRARY_NUMBER;
        String orderBy = ORDER_BY_TITLE;
        boolean expand = true;
        PoLines poLines =
                almaPOLineService.queryPoLines(q, status, offset, limit, acquisitionMethod, library, orderBy,
                        expand);
        assertEquals(2, poLines.getTotalRecordCount());
    }

    @Test
    void receiveItem() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(acqTarget);
        when(acqTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.queryParam(anyString(), any())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        Item mockItem = new Item();
        ItemData itemData = new ItemData();
        itemData.setBarcode(TEST_BARCODE);
        mockItem.setItemData(itemData);
        when(builder.buildPost(Entity.xml(any()))).thenReturn(invocation);
        when(invocation.invoke((Class<Item>) any())).thenReturn(mockItem);

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        Item item = almaPOLineService.receiveItem(TEST_ID, TEST_BARCODE);
        assertEquals(TEST_BARCODE, item.getItemData().getBarcode());
    }

    @Test
    void testReceiveItemFails() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(webTarget.path(anyString())).thenReturn(acqTarget);

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        assertThrows(IllegalArgumentException.class, () -> almaPOLineService.receiveItem(EMPTY_STRING, TEST_BARCODE),
                "should have failed without a poline_number.");
        assertThrows(IllegalArgumentException.class, () -> almaPOLineService.receiveItem(TEST_ID, EMPTY_STRING),
                "should have failed without an item_id.");
    }

    @Test
    void testSearchPolines() {
        when(mockAlmaApiClient.getWebTarget()).thenReturn(acqTarget);
        when(acqTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.path(anyString())).thenReturn(polineTarget);
        when(polineTarget.queryParam(anyString(), any())).thenReturn(polineTarget);
        when(polineTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        PoLines mockPolines = new PoLines();
        mockPolines.setTotalRecordCount(Integer.valueOf(152));
        when(invocation.invoke((Class<Object>) any())).thenReturn(mockPolines);

        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        String query = QUERY;
        String status = CLOSED;
        int offset = 0;
        int limit = 5;
        String library = LIBRARY_NUMBER;
        String orderBy = ORDER_BY_TITLE;
        boolean expand = false;
        PoLines poLines = almaPOLineService.searchPolines(query, status, offset, limit, library, orderBy, expand);
        assertEquals(152, poLines.getTotalRecordCount());

        assertThrows(IllegalArgumentException.class, () -> almaPOLineService.searchPolines(query, EMPTY_STRING, offset,
                limit, library, orderBy, expand), "should have failed without status.");
    }

    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaPOLineService.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaPOLineService almaPOLineService = new AlmaPOLineService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaPOLineService.getContextValue());
    }

    private void mockAlmaApi() {
        when(this.mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }

}