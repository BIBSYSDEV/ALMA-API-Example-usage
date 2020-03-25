package no.unit.alma.bibs;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import no.unit.alma.generated.items.Items;
import no.unit.alma.generated.holding.Holding;
import no.unit.alma.generated.holdings.Holdings;

import no.unit.alma.commons.AlmaClient;

/**
 * This client implements an integration to the /almaws/v1/bibs/<mmsId>/holdings
 */
public class AlmaHoldingsService {

    private static final String BIBS = "bibs";
    private static final String HOLDINGS = "holdings";
    private final transient WebTarget bibsTarget;
    private final String context;
    private final String contextValue;
    private final String almaStage;

    public AlmaHoldingsService(AlmaClient almaClient) {
        this.bibsTarget = almaClient.getWebTarget().path(BIBS);
        this.context = almaClient.getContext();
        this.contextValue = almaClient.getContextValue();
        this.almaStage = almaClient.getAlmaStage();
    }

    public Holdings getHoldings(String mmsId) {
        return bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Holdings.class);
    }

    public Holding getHolding(String mmsId, String holdingsId) {
        return bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holdingsId)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Holding.class);
    }

    public Holding updateHolding(String mmsId, final Holding holding) {
        return bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holding.getHoldingId())
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildPut(Entity.xml(holding))
                .invoke(Holding.class);
    }

    public Items getItems(String mmsId, String holdingsId, long limit, long offset) {
        return bibsTarget
                .path(mmsId)
                .path(HOLDINGS)
                .path(holdingsId)
                .path("items")
                .queryParam("limit", limit < 0 ? 100 : limit)
                .queryParam("offset", offset)
                .request()
                .accept(MediaType.APPLICATION_XML)
                .buildGet()
                .invoke(Items.class);
    }

    public Items getAllItems(String mmsId, String holdingsId) {

        Items items = new Items();
        int offset = 0;
        final int limit = 100;
        Items retrievedItems = getItems(mmsId, holdingsId, limit, offset);
        items.getItem().addAll(retrievedItems.getItem());

        int total = retrievedItems.getTotalRecordCount();
        boolean finished = limit + offset >= total;

        while (!finished) {
            offset = offset + limit;

            retrievedItems = getItems(mmsId, holdingsId, limit, offset);
            items.getItem().addAll(retrievedItems.getItem());

            finished = limit + offset > total;
        }

        items.setTotalRecordCount(total);
        return items;
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
