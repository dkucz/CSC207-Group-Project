package signup.data_access;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier) throws ExecutionException, InterruptedException;
    void save(User user) throws ExecutionException, InterruptedException;

    void deleteTokenFile();

    void createStoredCredentials() throws GeneralSecurityException, IOException;

    void createCalendar() throws GeneralSecurityException, IOException;

    boolean hasCalendar() throws GeneralSecurityException, IOException;
}
