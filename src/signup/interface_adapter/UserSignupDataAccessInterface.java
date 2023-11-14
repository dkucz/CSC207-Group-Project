package signup.interface_adapter;

import entity.User;

public interface UserSignupDataAccessInterface {
    boolean existsByName(String identifier);

    void save(User user);
}
