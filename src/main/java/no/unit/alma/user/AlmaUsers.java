package no.unit.alma.user;

import no.bibsys.alma.rest.user.User;
import no.bibsys.alma.rest.user.Users;
import no.unit.alma.commons.AlmaContext;

public interface AlmaUsers extends AlmaContext {

    User getUser(String userIdentifier);

    User getUser(String userIdentifier, String view, String expand);

    User postUser(User user);

    User updateUser(String userIdentifier, User user);

    void deleteUser(String userIdentifier);

    Users retrieveUsers(int limit, int offset);

    Users retrieveUsers(int limit, int offset, String orderBy);

}
