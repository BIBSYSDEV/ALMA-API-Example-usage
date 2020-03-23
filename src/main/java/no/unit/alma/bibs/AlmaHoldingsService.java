package no.unit.alma.bibs;

import no.bibsys.alma.rest.holding.Holding;
import no.bibsys.alma.rest.holdings.Holdings;
import no.bibsys.alma.rest.items.Items;
import no.unit.alma.commons.AlmaContext;

public interface AlmaHoldingsService extends AlmaContext {
    Holdings getHoldings(String mmsID);

    Holding getHolding(String mmsId, String holdingsId);

    Holding updateHolding(String mmsId, Holding holding);

    Items getItems(String mmsId, String holdingsId, long limit, long offset);
}
