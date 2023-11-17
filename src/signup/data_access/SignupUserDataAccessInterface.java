package signup.data_access;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface SignupUserDataAccessInterface {
    boolean existsByName(String identifier);
    void save(User user);

    String getCalendarID() throws GeneralSecurityException, IOException;

    void createAccessControlRule(String gmail) throws IOException, GeneralSecurityException;
}
