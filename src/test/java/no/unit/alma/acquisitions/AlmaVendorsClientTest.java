package no.unit.alma.acquisitions;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlmaVendorsClientTest {

    @Test
    void testGetVendor() throws IOException, InterruptedException {
        AlmaVendorsClient almaVendorsClient= new AlmaVendorsClient(null);
        Vendor test = almaVendorsClient.getVendor("testid");
        assertEquals("test", test.getVendorContentReplacement());
    }

}