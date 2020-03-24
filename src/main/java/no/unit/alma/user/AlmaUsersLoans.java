package no.unit.alma.user;

import no.bibsys.alma.rest.item_loan.ItemLoans;
import no.unit.alma.commons.AlmaContext;

public interface AlmaUsersLoans extends AlmaContext {

    ItemLoans retrieveUserItemLoans(String userIdentifier, int limit, int offset);

    ItemLoans retrieveAllUserItemLoans(String userIdentifier);
}
