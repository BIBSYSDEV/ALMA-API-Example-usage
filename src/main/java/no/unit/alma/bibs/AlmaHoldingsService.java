package no.unit.alma.bibs;

import no.unit.alma.generated.items.Items;
import no.unit.alma.generated.holding.Holding;
import no.unit.alma.generated.holdings.Holdings;

import no.unit.alma.commons.AlmaContext;

public interface AlmaHoldingsService extends AlmaContext {
    Holdings getHoldings(String mmsID);

    Holding getHolding(String mmsId, String holdingsId);

    Holding updateHolding(String mmsId, Holding holding);

    Items getItems(String mmsId, String holdingsId, long limit, long offset);
}
