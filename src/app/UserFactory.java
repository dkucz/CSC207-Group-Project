package app;

import entity.User;

public class UserFactory {
    public User create(String username, String password){
        return new User(username, password);
    }
}
