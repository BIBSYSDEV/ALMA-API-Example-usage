package no.unit.alma.acquisitions;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AlmaVendorsServiceImplementation implements AlmaVendorsService {

    private final WebTarget acqTarget;
    private final String context;
    private final String contextValue;
    private final AlmaStage almaStage;

    public AlmaVendorsServiceImplementation(AlmaClient almaClient) {
        this.acqTarget = almaClient.getWebTarget().path("acq");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage =almaClient.getAlmaStage();
    }

//    @Override
//    public Vendors searchVendor(String q) {
//        return retrieveVendors(q, "ACTIVE", "material_supplier", -1, 0);
//    }
//
//    @Override
//    public Vendors retrieveVendors(String q, String status, String type, int limit, int offset) {
//        WebTarget vendorsTarget = acqTarget.path("vendors");
//
//        if (StringUtils.isEmpty(q) && StringUtils.isEmpty(status) && StringUtils.isEmpty(type)) {
//            return vendorsTarget
//                    .request()
//                    .accept(MediaType.APPLICATION_XML)
//                    .buildGet()
//                    .invoke(Vendors.class);
//        }
//
//        vendorsTarget = vendorsTarget
//                .queryParam("status", StringUtils.isEmpty(status) ? "ALL" : status);
//
//        if (StringUtils.isNotEmpty(q)) {
//            vendorsTarget = vendorsTarget.queryParam("q", q);
//        }
//        if (StringUtils.isNotEmpty(type)) {
//            vendorsTarget = vendorsTarget.queryParam("type", type);
//        }
//        if (limit > -1) {
//            vendorsTarget = vendorsTarget.queryParam("limit", limit);
//        }
//        if (offset > 0) {
//            vendorsTarget = vendorsTarget.queryParam("offset", offset);
//        }
//
//        return vendorsTarget
//                .request()
//                .accept(MediaType.APPLICATION_XML)
//                .buildGet()
//                .invoke(Vendors.class);
//    }

    @Override
    public Vendor getVendor(String vendorIdentifier) {
        return acqTarget
                .path("vendors")
                .path(vendorIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Vendor.class);
    }

//    @Override
//    public Vendor postVendor(final Vendor vendor) {
//        return acqTarget
//                .path("vendors")
//                .request(MediaType.APPLICATION_XML)
//                .accept(MediaType.APPLICATION_XML)
//                .buildPost(Entity.xml(vendor))
//                .invoke(Vendor.class);
//    }
//
//    @Override
//    public Vendor updateVendor(String vendorIdentifier, final Vendor vendor) {
//        return acqTarget
//                .path("vendors")
//                .path(vendorIdentifier)
//                .request(MediaType.APPLICATION_XML)
//                .accept(MediaType.APPLICATION_XML)
//                .buildPut(Entity.xml(vendor))
//                .invoke(Vendor.class);
//    }
//
//    @Override
//    public void deleteVendor(String vendorIdentifier) {
//        acqTarget
//                .path("vendors")
//                .path(vendorIdentifier)
//                .request()
//                .accept(MediaType.APPLICATION_XML)
//                .buildDelete()
//                .invoke()
//                .close();
//    }

    @Override
    public String getContext() {
        return context;
    }

    @Override
    public String getContextValue() {
        return contextValue;
    }

    @Override
    public AlmaStage getAlmaStage() {
        return almaStage;
    }
}
