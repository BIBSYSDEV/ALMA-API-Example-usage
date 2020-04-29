package no.unit.alma.partners;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import no.unit.alma.commons.AlmaClient;
import no.unit.alma.generated.partners.Partner;
import no.unit.alma.generated.partners.Partners;

public class AlmaPartnersService {

    public static final String PARTNERS_PATH = "partners";

    private final transient WebTarget webTarget;
    private final String context;
    private final String contextValue;

    /**
     * Service for partners.
     *
     * @param almaClient almaClient
     */
    public AlmaPartnersService(AlmaClient almaClient) {
        this.webTarget = almaClient.getWebTarget();
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
    }

    /**
     * Search for partners.
     * 
     * @param q Query as String
     * @return Partners
     */
    public Partners searchPartner(String q) {
        return retrievePartners(q, "ACTIVE", "material_supplier", -1, 0);
    }

    /**
     * Retrieve Partners.
     *
     * @param q      Query as String
     * @param status Status as String
     * @param type   Type as String
     * @param limit  Limit as int
     * @param offset Offset as int
     * @return Partners
     */
    public Partners retrievePartners(String q, String status, String type, int limit, int offset) {
        WebTarget partnersTarget = webTarget.path(PARTNERS_PATH);

        if (StringUtils.isEmpty(q) && StringUtils.isEmpty(status) && StringUtils.isEmpty(type)) {
            return partnersTarget
                    .request()
                    .accept(MediaType.APPLICATION_XML)
                    .buildGet()
                    .invoke(Partners.class);
        }

        partnersTarget =
                partnersTarget
                        .queryParam("status", StringUtils.isEmpty(status) ? "ALL" : status);

        if (StringUtils.isNotEmpty(q)) {
            partnersTarget = partnersTarget.queryParam("q", q);
        }
        if (StringUtils.isNotEmpty(type)) {
            partnersTarget = partnersTarget.queryParam("type", type);
        }
        if (limit > -1) {
            partnersTarget = partnersTarget.queryParam("limit", limit);
        }
        if (offset > 0) {
            partnersTarget = partnersTarget.queryParam("offset", offset);
        }

        return partnersTarget
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Partners.class);
    }

    /**
     * Fetch partner.
     *
     * @param partnerIdentifier as String
     * @return Partner
     */
    public Partner getPartner(String partnerIdentifier) {
        return webTarget
                .path(PARTNERS_PATH)
                .path(partnerIdentifier)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Partner.class);
    }

    /**
     * Post new partner.
     *
     * @param partner as String
     * @return Partner
     */
    public Partner postPartner(final Partner partner) {
        return webTarget
                .path(PARTNERS_PATH)
                .request(MediaType.APPLICATION_XML)
                .buildPost(Entity.xml(partner))
                .invoke(Partner.class);
    }

    /**
     * Update a partner.
     *
     * @param partnerIdentifier as String
     * @param partner           changed partner as Partner
     * @return Partner
     */
    public Partner updatePartner(String partnerIdentifier, final Partner partner) {
        return webTarget
                .path(PARTNERS_PATH)
                .path(partnerIdentifier)
                .request(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(partner))
                .invoke(Partner.class);
    }

    /**
     * Delete partner.
     *
     * @param partnerIdentifier as String
     */
    public void deletePartner(String partnerIdentifier) {
        webTarget
                .path(PARTNERS_PATH)
                .path(partnerIdentifier)
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
}
