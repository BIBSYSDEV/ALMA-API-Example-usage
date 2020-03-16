package no.unit.alma.acquisitions;

import com.typesafe.config.Config;
import no.bibsys.alma.rest.vendor.Vendor;
import no.bibsys.vault.VaultClient;
import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaServiceFactory;
import no.unit.alma.commons.AlmaStage;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

class AlmaVendorsClientTest {

    private static final String TEST_ID = "123456";

    @Mock
    AlmaClient mockAlmaApiClient;

    @Mock
    WebTarget webTarget;

    @Test
    void testGetVendor() throws IOException, InterruptedException {
        //setup
//        Client client = JerseyClientBuilder.newClient();
//        WebTarget webTarget = client.target("http://www.example.com/");

        //mock almaClient-methods
        when(mockAlmaApiClient.getWebTarget()).thenReturn(webTarget);
        when(mockAlmaApiClient.getAlmaStage()).thenReturn(AlmaStage.SANDBOX2);
        when(mockAlmaApiClient.getContext()).thenReturn("");
        when(mockAlmaApiClient.getContextValue()).thenReturn("");
        when(webTarget.path(any())).thenReturn(null);
        AlmaVendorsServiceImplementation almaVendorsServiceImplementation = new AlmaVendorsServiceImplementation(mockAlmaApiClient);

        Vendor vendor = almaVendorsServiceImplementation.getVendor(TEST_ID);
        assertEquals("test", vendor.getVendorLibraries());
    }

}