package no.unit.alma.acquisitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import no.bibsys.alma.rest.vendor.Vendors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.bibsys.alma.rest.vendor.Vendor;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

@ExtendWith(MockitoExtension.class)
class AlmaVendorsServiceTest {

    private static final String TEST_ID = "123456";
    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final AlmaStage STAGE = AlmaStage.SANDBOX2;

    @Mock
    private AlmaClient mockAlmaApiClient;
    @Mock
    private WebTarget webTarget;
    @Mock
    private Invocation.Builder builder;
    @Mock
    private Invocation invocation;
    @Mock
    Response response;

    @Test
    void testGetVendor() {
        mockAlmaApi();

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        Vendor tempVendor = new Vendor();
        tempVendor.setCode("test");
        when(invocation.invoke((Class<Object>) any())).thenReturn(tempVendor);

        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        Vendor resultVendor = almaVendorsServiceImplementation.getVendor(TEST_ID);
        assertEquals(tempVendor.getCode(), resultVendor.getCode());
    }

    @Test
    void testDeleteVendor() {
        mockAlmaApi();

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildDelete()).thenReturn(invocation);
        when(invocation.invoke()).thenReturn(response);
        doNothing().when(response).close();


        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        almaVendorsServiceImplementation.deleteVendor(TEST_ID);
    }


    @Test
    void testPostVendor() {
        mockAlmaApi();

        Vendor vendor = new Vendor();
        vendor.setCode("test");

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request(anyString())).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPost(Entity.xml(vendor))).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendor);

        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        Vendor resultVendor = almaVendorsServiceImplementation.postVendor(vendor);
        assertEquals(vendor.getCode(), resultVendor.getCode());

    }

    @Test
    void testUpdateVendor() {
        mockAlmaApi();

        Vendor vendor = new Vendor();
        vendor.setCode("test");

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request(anyString())).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildPut(Entity.xml(vendor))).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendor);

        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        Vendor resultVendor = almaVendorsServiceImplementation.updateVendor(TEST_ID, vendor);
        assertEquals(vendor.getCode(), resultVendor.getCode());
    }
    @Test
    void testRetrieveVendors() {
        mockAlmaApi();

        final int LIMIT = 0;
        final int OFFSET = 10;
        final String STATUS = "status";
        final String  EMPTY_QUERY_STRING = "query";
        final String  TYPE = "some_type";

        Vendors vendors = new Vendors();
        vendors.setTotalRecordCount(12);

        when(webTarget.queryParam(anyString(),any())).thenReturn(webTarget);
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendors);

        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        Vendors resultVendors = almaVendorsServiceImplementation.retrieveVendors(EMPTY_QUERY_STRING, STATUS, TYPE, LIMIT, OFFSET);
        assertEquals(vendors.getTotalRecordCount(), resultVendors.getTotalRecordCount());
    }
    @Test
    void testRetrieveAllVendors() {
        mockAlmaApi();

        final int LIMIT = 10;
        final int OFFSET = 10;
        final String EMPTY_STATUS = "";
        final String  EMPTY_QUERY_STRING = "";
        final String  TYPE = "";

        Vendors vendors = new Vendors();
        vendors.setTotalRecordCount(12);

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendors);

        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        Vendors resultVendors = almaVendorsServiceImplementation.retrieveVendors(EMPTY_QUERY_STRING, EMPTY_STATUS, TYPE, LIMIT, OFFSET);
        assertEquals(vendors.getTotalRecordCount(), resultVendors.getTotalRecordCount());
    }

    @Test
    void testSearchVendors() {
        mockAlmaApi();

        final int RESULT_COUNT = 121;
        final String  QUERY_STRING = "test";

        Vendors vendors = new Vendors();
        vendors.setTotalRecordCount(RESULT_COUNT);

        when(webTarget.queryParam(anyString(),any())).thenReturn(webTarget);
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendors);

        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        Vendors resultVendors = almaVendorsServiceImplementation.searchVendor(QUERY_STRING);
        assertEquals(vendors.getTotalRecordCount(), resultVendors.getTotalRecordCount());
    }


    @Test
    void testGetAlmaStage() {
        mockAlmaApi();
        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        assertEquals(STAGE.getVaultAlmaStageName(), almaVendorsServiceImplementation
                .getAlmaStage().getVaultAlmaStageName());
    }

    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        assertEquals(CONTEXT, almaVendorsServiceImplementation.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        AlmaStage result = almaVendorsServiceImplementation.getAlmaStage();
        assertEquals(CONTEXT_VALUE, almaVendorsServiceImplementation.getContextValue());
    }


    private void mockAlmaApi() {
        when(this.mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }





}