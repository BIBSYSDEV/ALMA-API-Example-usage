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

import no.unit.alma.generated.vendors.Vendors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.unit.alma.generated.vendors.Vendor;
import no.unit.alma.commons.AlmaClient;

@ExtendWith(MockitoExtension.class)
class AlmaVendorsServiceTest {

    private static final String TEST_ID = "123456";
    private static final String CONTEXT = "exampleContext";
    private static final String CONTEXT_VALUE = "exampleContextValue";
    private static final String STAGE = "alma-sandbox2";

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

        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        Vendor resultVendor = almaVendorsService.getVendor(TEST_ID);
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


        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        almaVendorsService.deleteVendor(TEST_ID);
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

        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        Vendor resultVendor = almaVendorsService.postVendor(vendor);
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

        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        Vendor resultVendor = almaVendorsService.updateVendor(TEST_ID, vendor);
        assertEquals(vendor.getCode(), resultVendor.getCode());
    }

    @Test
    void testRetrieveVendors() {
        mockAlmaApi();

        final int limit = 0;
        final int offset = 10;
        final String status = "status";
        final String emptyQueryString = "query";
        final String type = "some_type";

        Vendors vendors = new Vendors();
        vendors.setTotalRecordCount(12);

        when(webTarget.queryParam(anyString(),any())).thenReturn(webTarget);
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendors);

        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        Vendors resultVendors = almaVendorsService.retrieveVendors(emptyQueryString, status, type, limit, offset);
        assertEquals(vendors.getTotalRecordCount(), resultVendors.getTotalRecordCount());
    }

    @Test
    void testRetrieveAllVendors() {
        mockAlmaApi();

        final int limit = 10;
        final int offset = 10;
        final String emptyStatus = "";
        final String emptyQueryString = "";
        final String type = "";

        Vendors vendors = new Vendors();
        vendors.setTotalRecordCount(12);

        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendors);

        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        Vendors resultVendors =
                almaVendorsService.retrieveVendors(emptyQueryString, emptyStatus, type, limit, offset);
        assertEquals(vendors.getTotalRecordCount(), resultVendors.getTotalRecordCount());
    }

    @Test
    void testSearchVendors() {
        mockAlmaApi();

        final int resultCount = 121;
        final String queryString = "test";

        Vendors vendors = new Vendors();
        vendors.setTotalRecordCount(resultCount);

        when(webTarget.queryParam(anyString(),any())).thenReturn(webTarget);
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        when(invocation.invoke((Class<Object>) any())).thenReturn(vendors);

        AlmaVendorsService almaVendorsService =
                new AlmaVendorsService(mockAlmaApiClient);
        Vendors resultVendors = almaVendorsService.searchVendor(queryString);
        assertEquals(vendors.getTotalRecordCount(), resultVendors.getTotalRecordCount());
    }


    @Test
    void testGetAlmaStage() {
        mockAlmaApi();
        AlmaVendorsService almaVendorsService = new AlmaVendorsService(mockAlmaApiClient);
        assertEquals(STAGE, almaVendorsService.getAlmaStage());
    }

    @Test
    void testGetContext() {
        mockAlmaApi();
        AlmaVendorsService almaVendorsService = new AlmaVendorsService(mockAlmaApiClient);
        assertEquals(CONTEXT, almaVendorsService.getContext());
    }

    @Test
    void testGetContextValue() {
        mockAlmaApi();
        AlmaVendorsService almaVendorsService = new AlmaVendorsService(mockAlmaApiClient);
        assertEquals(CONTEXT_VALUE, almaVendorsService.getContextValue());
    }


    private void mockAlmaApi() {
        when(this.mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(STAGE);
        when(mockAlmaApiClient.getContext()).thenReturn(CONTEXT);
        when(mockAlmaApiClient.getContextValue()).thenReturn(CONTEXT_VALUE);
    }





}