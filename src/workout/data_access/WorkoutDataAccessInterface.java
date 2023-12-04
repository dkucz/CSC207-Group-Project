package workout.data_access;

import entity.User;
import entity.Workout;

import java.util.concurrent.ExecutionException;

public interface WorkoutDataAccessInterface {


    boolean existsByMuscle(String identifier) throws ExecutionException, InterruptedException ;

    boolean existsByType(String type);

    boolean existsByDifficulty(String type);


    void getExercisesInfo(Workout workout, String muscle);

    void findOfType(Workout workout, String type);

    void exercisesOnDifficulty(Workout workout, String difficulty);

    void addExercise(String user, String exerciseName, int day) throws ExecutionException, InterruptedException;
    public void save(User user) throws ExecutionException, InterruptedException;
}