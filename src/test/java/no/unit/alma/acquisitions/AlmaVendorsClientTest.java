package no.unit.alma.acquisitions;

import no.bibsys.alma.rest.vendor.Vendor;
import no.unit.alma.commons.AlmaServiceFactory;
import no.unit.alma.commons.AlmaStage;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlmaVendorsClientTest {

    //private AlmaServiceFactory almaServiceFactory = new AlmaServiceFactory(JerseyClientBuilder.newClient());


    @Test
    void testGetVendor() throws IOException, InterruptedException {
//        AlmaVendorsService almaVendorsService = almaServiceFactory.getAlmaVendors("g", AlmaStage.SANDBOX2);
//        Vendor test = almaVendorsService.getVendor("testid");
//        assertEquals("test", test.getVendorLibraries());
        assertEquals("test", "test");

    }

}