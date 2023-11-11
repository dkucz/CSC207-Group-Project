package login.data_access;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);

    User get(String username);

    void createStoredCredentials() throws GeneralSecurityException, IOException;
}
