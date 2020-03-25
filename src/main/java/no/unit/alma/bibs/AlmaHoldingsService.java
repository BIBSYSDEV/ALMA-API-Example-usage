package no.unit.alma.bibs;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import no.bibsys.alma.rest.holding.Holding;
import no.bibsys.alma.rest.holdings.Holdings;
import no.bibsys.alma.rest.items.Items;
import no.unit.alma.commons.AlmaClient;

/**
 * This client implements an integration to the /almaws/v1/bibs/<mmsId>/holdings
 */
public class AlmaHoldingsService {

    private final WebTarget bibsTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    public AlmaHoldingsService(AlmaClient almaClient) {
        this.bibsTarget = almaClient.getWebTarget().path("bibs");
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    public Holdings getHoldings(String mmsId) {
        return bibsTarget
                .path(mmsId)
                .path("holdings")
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Holdings.class);
    }

    public Holding getHolding(String mmsId, String holdingsId) {
        return bibsTarget
                .path(mmsId)
                .path("holdings")
                .path(holdingsId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Holding.class);
    }

    public Holding updateHolding(String mmsId, final Holding holding) {
        return bibsTarget
                .path(mmsId)
                .path("holdings")
                .path(holding.getHoldingId())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(holding))
                .invoke(Holding.class);
    }

    public Items getItems(String mmsId, String holdingsId, long limit, long offset) {
        return bibsTarget
                .path(mmsId)
                .path("holdings")
                .path(holdingsId)
                .path("items")
                .queryParam("limit", limit < 0 ? 100 : limit)
                .queryParam("offset", offset)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Items.class);
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
