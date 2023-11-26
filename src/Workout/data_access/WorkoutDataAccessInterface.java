package Workout.data_access;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface WorkoutDataAccessInterface {

    boolean existsByName(String identifier);

    boolean existsByType(String type);

    boolean existsByDifficulty(String type);

    void save(User user);

    User get(String username);

    void createStoredCredentials() throws GeneralSecurityException, IOException;
}
