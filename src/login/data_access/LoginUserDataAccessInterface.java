package login.data_access;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier) throws ExecutionException, InterruptedException;

    void save(User user) throws ExecutionException, InterruptedException;

    User get(String username) throws ExecutionException, InterruptedException;

    void createStoredCredentials() throws GeneralSecurityException, IOException;

    void deleteTokenFile();
}
