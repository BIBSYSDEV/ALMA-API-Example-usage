package no.unit.alma.acquisitions;

import java.io.IOException;

import no.bibsys.alma.rest.vendor.Vendor;
import no.unit.alma.commons.AlmaContext;

public interface AlmaVendorsService extends AlmaContext {
//    Vendors searchVendor(String q);
//
//    Vendors retrieveVendors(String q, String status, String type, int limit, int offset);

    Vendor getVendor(String vendorIdentifier) throws IOException, InterruptedException;
//
//    Vendor postVendor(Vendor vendor);
//
//    Vendor updateVendor(String vendorIdentifier, Vendor vendor);
//
//    void deleteVendor(String vendorIdentifier);

}
