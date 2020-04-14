package no.unit.alma.acquisitions;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import no.unit.alma.generated.vendors.Vendor;
import no.unit.alma.generated.vendors.Vendors;
import no.unit.alma.commons.AlmaClient;
import org.apache.commons.lang3.StringUtils;

public class AlmaVendorsService  {

    public static final String VENDORS_PATH = "vendors";
    public static final String ACQUISITION_PATH = "acq";

    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    /**
     * Service for vendors.
     *
     * @param almaClient almaClient
     */
    public AlmaVendorsService(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget().path(ACQUISITION_PATH);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    /**
     * Search for vendors.
     * @param q     Query as String
     * @return Vendors
     */
    public Vendors searchVendor(String q) {
        return retrieveVendors(q, "ACTIVE", "material_supplier", -1, 0);
    }


    /**
     * Retrieve Vendors.
     *
     * @param q         Query as String
     * @param status    Status as String
     * @param type      Type as String
     * @param limit     Limit as int
     * @param offset    Offset as int
     * @return Vendors
     */
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


    /**
     * Fetch vendor.
     *
     * @param vendorIdentifier as String
     * @return Vendor
     */
    public Vendor getVendor(String vendorIdentifier) {
        return webTarget
                .path(VENDORS_PATH)
                .path(vendorIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Vendor.class);
    }


    /**
     * Post new vendor.
     *
     * @param vendor as String
     * @return Vendor
     */
    public Vendor postVendor(final Vendor vendor) {
        return webTarget
                .path(VENDORS_PATH)
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(vendor))
                .invoke(Vendor.class);
    }


    /**
     * Update a vendor.
     *
     * @param vendorIdentifier  as String
     * @param vendor            changed vendor as Vendor
     * @return Vendor
     */
    public Vendor updateVendor(String vendorIdentifier, final Vendor vendor) {
        return webTarget
                .path(VENDORS_PATH)
                .path(vendorIdentifier)
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(vendor))
                .invoke(Vendor.class);
    }


    /**
     * Delete vendor.
     *
     * @param vendorIdentifier as String
     */
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
