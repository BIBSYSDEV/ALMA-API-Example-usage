package no.unit.alma.user;

import no.unit.alma.generated.itemloans.ItemLoans;

public interface AlmaUsersLoans {

    ItemLoans retrieveUserItemLoans(String userIdentifier, int limit, int offset);

    ItemLoans retrieveAllUserItemLoans(String userIdentifier);
}
