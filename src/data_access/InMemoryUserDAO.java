package data_access;

import entity.User;
import login.data_access.LoginUserDataAccessInterface;
import signup.data_access.SignupUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class InMemoryUserDAO implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void deleteTokenFile() {

    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public void createStoredCredentials() {}

    @Override
    public void createCalendar() {

    }

    @Override
    public boolean hasCalendar() throws GeneralSecurityException, IOException {
        return false;
    }
}
