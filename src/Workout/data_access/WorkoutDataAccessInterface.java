package Workout.data_access;

import entity.User;
import entity.Workout;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface WorkoutDataAccessInterface {


    boolean existsByMuscle(String identifier) throws ExecutionException, InterruptedException ;

    boolean existsByType(String type);

    boolean existsByDifficulty(String type);


    void getExercisesInfo(Workout workout, String muscle);

    void findOfType(Workout workout, String type);

    void exercisesOnDifficulty(Workout workout, String difficulty);

    void addExercise(String user, String exerciseName, int day);
    public void save(User user) throws ExecutionException, InterruptedException;

    ArrayList<ArrayList<String>> getExerciseSchedule(String username) throws ExecutionException, InterruptedException;

    ArrayList<ArrayList<String>> addExerciseToSchedule(String username, int day, String exerciseName) throws ExecutionException, InterruptedException;

    boolean hasFiveExercises(String username, int day) throws ExecutionException, InterruptedException;

    boolean exerciseScheduleExists(String username) throws ExecutionException, InterruptedException;
    private void deleteFriendDocument(String username, String friendUsername) throws ExecutionException, InterruptedException {}


}