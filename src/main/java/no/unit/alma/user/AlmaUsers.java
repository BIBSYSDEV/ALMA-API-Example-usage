package no.unit.alma.user;

import no.unit.alma.generated.users.User;
import no.unit.alma.generated.users.Users;

public interface AlmaUsers {

    User getUser(String userIdentifier);

    User getUser(String userIdentifier, String view, String expand);

    User postUser(User user);

    User updateUser(String userIdentifier, User user);

    void deleteUser(String userIdentifier);

    Users retrieveUsers(int limit, int offset);

    Users retrieveUsers(int limit, int offset, String orderBy);

}
