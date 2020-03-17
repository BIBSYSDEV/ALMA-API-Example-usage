package no.unit.alma.acquisitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import no.bibsys.alma.rest.vendor.Vendor;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

@ExtendWith(MockitoExtension.class)
class AlmaVendorsClientTest {

    private static final String TEST_ID = "123456";

    @Mock
    private AlmaClient mockAlmaApiClient;

    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation.Builder builder;

    @Mock
    private Invocation invocation;

    @Mock
    private Response response;


    @Test
    void testGetVendor() throws IOException, InterruptedException {
        // mock almaClient-methods
        when(this.mockAlmaApiClient.getWebTarget())
                .thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(AlmaStage.SANDBOX2);
        when(mockAlmaApiClient.getContext()).thenReturn("");
        when(mockAlmaApiClient.getContextValue()).thenReturn("");
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.path(any())).thenReturn(webTarget);
        when(webTarget.request()).thenReturn(builder);
        when(builder.accept(anyString())).thenReturn(builder);
        when(builder.buildGet()).thenReturn(invocation);
        Vendor tempVendor = new Vendor();
        tempVendor.setCode("test");
        when(invocation.invoke((Class<Object>) any())).thenReturn(tempVendor);
        AlmaVendorsServiceImplementation almaVendorsServiceImplementation =
                new AlmaVendorsServiceImplementation(mockAlmaApiClient);
        Vendor vendor = almaVendorsServiceImplementation.getVendor(TEST_ID);
        assertEquals(tempVendor.getCode(), vendor.getCode());
    }

}