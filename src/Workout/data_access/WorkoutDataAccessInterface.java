package Workout.data_access;

import entity.User;
import entity.Workout;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface WorkoutDataAccessInterface {


    boolean existsByMuscle(String identifier) throws ExecutionException, InterruptedException ;

    boolean existsByType(String type);

    boolean existsByDifficulty(String type);


    void getExercisesInfo(Workout workout, String muscle);

    void findOfType(Workout workout, String type);

    void exercisesOnDifficulty(Workout workout, String difficulty);

    void addExercise(String user, String exerciseName, int day);
}
