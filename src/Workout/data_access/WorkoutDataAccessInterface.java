package Workout.data_access;

import entity.User;
import entity.Workout;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface WorkoutDataAccessInterface {

    boolean existsByName(String identifier);

    boolean existsByType(String type);

    boolean existsByDifficulty(String type);


    void GetExercisesInfo(String muscle);

    void FindOfType(String type);

    void ExercisesOnDifficulty(String difficulty);

    Workout get(String workout);
}
