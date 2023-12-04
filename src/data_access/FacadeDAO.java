package data_access;

import Workout.data_access.WorkoutDataAccessInterface;
import app.WorkoutUseCaseFactory;
import entity.User;
import entity.Workout;
import login.data_access.LoginUserDataAccessInterface;
import signup.data_access.SignupUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
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
    public boolean existsByMuscle(String identifier) throws ExecutionException, InterruptedException {
        return exercisesDAO.existsByMuscle(identifier);
    }

    @Override
    public boolean existsByType(String type) {
        return exercisesDAO.existsByType(type);
    }

    @Override
    public boolean existsByDifficulty(String type) {
        return exercisesDAO.existsByDifficulty(type);
    }

    @Override
    public void getExercisesInfo(Workout workout, String muscle) {
        exercisesDAO.getExercisesInfo(workout, muscle);
    }

    @Override
    public void findOfType(Workout workout, String type) {
        exercisesDAO.findOfType(workout, type);
    }

    @Override
    public void exercisesOnDifficulty(Workout workout, String difficulty) {
        exercisesDAO.exercisesOnDifficulty(workout, difficulty);
    }

    @Override
    public void save(User user) throws ExecutionException, InterruptedException {
        firestoreDAO.save(user);
    }

    @Override
    public ArrayList<ArrayList<String>> getExerciseSchedule(String username) throws ExecutionException, InterruptedException {
        return firestoreDAO.getExerciseSchedule(username);
    }

    @Override
    public ArrayList<ArrayList<String>> addExerciseToSchedule(String username, int day, String exerciseName) throws ExecutionException, InterruptedException {
        return null;
    }

    @Override
    public boolean hasFiveExercises(String username, int day) throws ExecutionException, InterruptedException {
        return false;
    }

    @Override
    public boolean exerciseScheduleExists(String username) throws ExecutionException, InterruptedException {
        return false;
    }

    public void addExercise(String userName, String exerciseName, int day)
    {
        System.out.println(userName + " likes doing " + exerciseName + "s on + " + day);//do stuff;


    }
}
