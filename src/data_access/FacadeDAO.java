package data_access;

import entity.User;
import login.data_access.LoginUserDataAccessInterface;
import signup.data_access.SignupUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class FacadeDAO implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {
    private final FirestoreDAO firestoreDAO;
    private final GoogleCalendarDAO googleCalendarDAO;
    private final ExercisesDAO exercisesDAO;

    public FacadeDAO(FirestoreDAO firestoreDAO, GoogleCalendarDAO googleCalendarDAO, ExercisesDAO exercisesDAO)
    {
        this.firestoreDAO = firestoreDAO;
        this.googleCalendarDAO = googleCalendarDAO;
        this.exercisesDAO = exercisesDAO;
    }

    @Override
    public User get(String username) throws ExecutionException, InterruptedException {
        return firestoreDAO.get(username);
    }

    @Override
    public void createStoredCredentials() throws GeneralSecurityException, IOException {
        googleCalendarDAO.createStoredCredentials();
    }

    @Override
    public boolean existsByName(String identifier) throws ExecutionException, InterruptedException {
        return firestoreDAO.existsByName(identifier);
    }

    @Override
    public void save(User user) throws ExecutionException, InterruptedException {
        firestoreDAO.save(user);
    }
}
