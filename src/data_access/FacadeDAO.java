package data_access;

import Workout.data_access.WorkoutDataAccessInterface;
import app.WorkoutUseCaseFactory;
import entity.User;
import entity.Workout;
import login.data_access.LoginUserDataAccessInterface;
import signup.data_access.SignupUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class FacadeDAO implements SignupUserDataAccessInterface, LoginUserDataAccessInterface, WorkoutDataAccessInterface {
    private final FirestoreDAO firestoreDAO;
    private final GoogleCalendarDAO googleCalendarDAO;
    private final ExercisesDAO exercisesDAO;

    public FacadeDAO(FirestoreDAO firestoreDAO,
                     GoogleCalendarDAO googleCalendarDAO,
                     ExercisesDAO exercisesDAO)
    {
        this.firestoreDAO = firestoreDAO;
        this.googleCalendarDAO = googleCalendarDAO;
        this.exercisesDAO = exercisesDAO;
    }

    @Override
    public User get(String username) throws ExecutionException, InterruptedException {
        return firestoreDAO.getUserFromName(username);
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
    public boolean existsByType(String type) {
        return false;
    }

    @Override
    public boolean existsByDifficulty(String type) {
        return false;
    }

    @Override
    public void GetExercisesInfo(Workout workout, String muscle) {

    }

    @Override
    public void FindOfType(Workout workout, String type) {

    }

    @Override
    public void ExercisesOnDifficulty(Workout workout, String difficulty) {

    }

    @Override
    public Workout getWorkout(String workout) {
        return null;
    }

    @Override
    public void save(User user) throws ExecutionException, InterruptedException {
        firestoreDAO.save(user);
    }
}
