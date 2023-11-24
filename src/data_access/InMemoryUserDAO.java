package data_access;

import entity.User;
import signup.data_access.SignupUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class InMemoryUserDAO implements SignupUserDataAccessInterface {
    @Override
    public boolean existsByName(String identifier) {
        return false;
    }

    @Override
    public void save(User user) {

    }


    public String getCalendarID() throws GeneralSecurityException, IOException {
        return null;
    }


    public void createAccessControlRule(String gmail) throws IOException, GeneralSecurityException {

    }
}
