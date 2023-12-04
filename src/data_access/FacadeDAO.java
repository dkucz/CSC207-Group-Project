package data_access;

import workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Workout;
import login.data_access.LoginUserDataAccessInterface;
import signup.data_access.SignupUserDataAccessInterface;

import java.io.File;
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
    public void createCalendar() throws GeneralSecurityException, IOException {
        googleCalendarDAO.createCalendar();
    }

    @Override
    public boolean hasCalendar() throws GeneralSecurityException, IOException {
        return googleCalendarDAO.hasCalendar();
    }

    @Override
    public boolean existsByName(String identifier) throws ExecutionException, InterruptedException {
        return firestoreDAO.existsByName(identifier);
    }

    @Override
    public boolean existsByMuscle(String identifier) {
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
    public void deleteTokenFile() {
        File storedCredentials = new File("./tokens/StoredCredential");
        storedCredentials.delete();
    }

    @Override
    public ArrayList<ArrayList<String>> getExerciseSchedule(String username) throws ExecutionException, InterruptedException {
        return firestoreDAO.getExerciseSchedule(username);
    }

    @Override
    public ArrayList<ArrayList<String>> addExerciseToSchedule(String username, int day, String exerciseName) throws ExecutionException, InterruptedException {
        return firestoreDAO.addExerciseToSchedule(username, day, exerciseName);
    }

    @Override
    public boolean hasFiveExercises(String username, int day) throws ExecutionException, InterruptedException {
        return firestoreDAO.hasFiveExercises(username, day);
    }

    @Override
    public boolean exerciseScheduleExists(String username) throws ExecutionException, InterruptedException {
        return firestoreDAO.exerciseScheduleExists(username);
    }
    public void addExercise(String username, String exerciseName, int day) throws ExecutionException, InterruptedException {
       firestoreDAO.addExercise(username, exerciseName, day);
}}
