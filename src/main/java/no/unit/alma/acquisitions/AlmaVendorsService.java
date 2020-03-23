package no.unit.alma.acquisitions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import no.bibsys.alma.rest.vendor.Vendor;
import no.bibsys.alma.rest.vendor.Vendors;
import no.unit.alma.commons.AlmaClient;
import org.apache.commons.lang3.StringUtils;

public class AlmaVendorsService  {

    public static final String VENDORS_PATH = "vendors";
    public static final String ACQUISITION_PATH = "acq";

    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    public AlmaVendorsService(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget().path(ACQUISITION_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    public Vendors searchVendor(String q) {
        return retrieveVendors(q, "ACTIVE", "material_supplier", -1, 0);
    }

    
    public Vendors retrieveVendors(String q, String status, String type, int limit, int offset) {
        WebTarget vendorsTarget = webTarget.path(VENDORS_PATH);

        if (StringUtils.isEmpty(q) && StringUtils.isEmpty(status) && StringUtils.isEmpty(type)) {
            return vendorsTarget
                    .request()
                    .accept(MediaType.APPLICATION_XML)
                    .buildGet()
                    .invoke(Vendors.class);
        }

        vendorsTarget = vendorsTarget
                .queryParam("status", StringUtils.isEmpty(status) ? "ALL" : status);

        if (StringUtils.isNotEmpty(q)) {
            vendorsTarget = vendorsTarget.queryParam("q", q);
        }
        if (StringUtils.isNotEmpty(type)) {
            vendorsTarget = vendorsTarget.queryParam("type", type);
        }
        if (limit > -1) {
            vendorsTarget = vendorsTarget.queryParam("limit", limit);
        }
        if (offset > 0) {
            vendorsTarget = vendorsTarget.queryParam("offset", offset);
        }

        return vendorsTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Vendors.class);
    }

    
    public Vendor getVendor(String vendorIdentifier) {
        return webTarget
                .path(VENDORS_PATH)
                .path(vendorIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Vendor.class);
    }

    
    public Vendor postVendor(final Vendor vendor) {
        return webTarget
                .path(VENDORS_PATH)
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(vendor))
                .invoke(Vendor.class);
    }

    
    public Vendor updateVendor(String vendorIdentifier, final Vendor vendor) {
        return webTarget
                .path(VENDORS_PATH)
                .path(vendorIdentifier)
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(vendor))
                .invoke(Vendor.class);
    }

    
    public void deleteVendor(String vendorIdentifier) {
        webTarget
                .path(VENDORS_PATH)
                .path(vendorIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildDelete()
                .invoke()
                .close();
    }

    
    public String getContext() {
        return context;
    }

    
    public String getContextValue() {
        return contextValue;
    }

    
    public String getAlmaStage() {
        return almaStage;
    }
}
