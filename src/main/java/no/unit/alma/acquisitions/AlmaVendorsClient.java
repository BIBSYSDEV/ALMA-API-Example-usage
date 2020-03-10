package no.unit.alma.acquisitions;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.commons.AlmaStage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class AlmaVendorsClient implements AlmaVendors {

    private final HttpClient acqTarget;
    private final String context;
    private final String contextValue;
    private final AlmaStage almaStage;

    private final static String VENDORS_URL = "https://jsonplaceholder.typicode.com/todos/1"; //"vendors";

    public AlmaVendorsClient(AlmaClient almaClient) {
        this.acqTarget = almaClient.getWebTarget();//.path("acq");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage =almaClient.getAlmaStage();
    }

//    public Vendors searchVendor(String q) {
//        return retrieveVendors(q, "ACTIVE", "material_supplier", -1, 0);
//    }

//    public Vendors retrieveVendors(String q, String status, String type, int limit, int offset) {
//        HttpClient vendorsTarget = acqTarget;//.path("vendors");
//
//        if (StringUtils.isEmpty(q) && StringUtils.isEmpty(status) && StringUtils.isEmpty(type)) {
//            return vendorsTarget
//                .request()
//                .accept(MediaType.APPLICATION_XML)
//                .buildGet()
//                .invoke(Vendors.class);
//        }
//
//        vendorsTarget = vendorsTarget
//            .queryParam("status", StringUtils.isEmpty(status) ? "ALL" : status);
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
//            .request()
//            .accept(MediaType.APPLICATION_XML)
//            .buildGet()
//            .invoke(Vendors.class);
//    }

    @Override
    public Vendor getVendor(String vendorIdentifier) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VENDORS_URL))
                .timeout(Duration.ofMinutes(1))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = HttpClient
                .newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());

        return new Vendor(response.body());
//        return acqTarget
//            .path("vendors")
//            .path(vendorIdentifier)
//            .request()
//            .accept(MediaType.APPLICATION_XML)
//            .buildGet()
//            .invoke(Vendor.class);
    }

//    @Override
//    public Vendor postVendor(final Vendor vendor) {
//        return acqTarget
//            .path("vendors")
//            .request(MediaType.APPLICATION_XML)
//            .accept(MediaType.APPLICATION_XML)
//            .buildPost(Entity.xml(vendor))
//            .invoke(Vendor.class);
//    }
//
//    @Override
//    public Vendor updateVendor(String vendorIdentifier, final Vendor vendor) {
//        return acqTarget
//            .path("vendors")
//            .path(vendorIdentifier)
//            .request(MediaType.APPLICATION_XML)
//            .accept(MediaType.APPLICATION_XML)
//            .buildPut(Entity.xml(vendor))
//            .invoke(Vendor.class);
//    }
//
//    @Override
//    public void deleteVendor(String vendorIdentifier) {
//        acqTarget
//            .path("vendors")
//            .path(vendorIdentifier)
//            .request()
//            .accept(MediaType.APPLICATION_XML)
//            .buildDelete()
//            .invoke()
//            .close();
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
