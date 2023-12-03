package Workout.data_access;

import entity.Workout;

import java.util.concurrent.ExecutionException;

public interface WorkoutDataAccessInterface {

    boolean existsByName(String identifier) throws ExecutionException, InterruptedException;

    boolean existsByType(String type);

    boolean existsByDifficulty(String type);


    void GetExercisesInfo(Workout workout, String muscle);

    void FindOfType(Workout workout, String type);

    void ExercisesOnDifficulty(Workout workout, String difficulty);

    Workout getWorkout(String workout);
}
