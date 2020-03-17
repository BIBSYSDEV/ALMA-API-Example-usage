package no.unit.alma.acquisitions;

import no.bibsys.alma.rest.vendor.Vendor;
import no.bibsys.alma.rest.vendor.Vendors;
import no.unit.alma.commons.AlmaContext;

import java.io.IOException;

public interface AlmaVendorsService extends AlmaContext {

    Vendors searchVendor(String q);

    Vendors retrieveVendors(String q, String status, String type, int limit, int offset);

    Vendor getVendor(String vendorIdentifier) throws IOException, InterruptedException;

    Vendor postVendor(Vendor vendor);

    Vendor updateVendor(String vendorIdentifier, Vendor vendor);

    void deleteVendor(String vendorIdentifier);

}
