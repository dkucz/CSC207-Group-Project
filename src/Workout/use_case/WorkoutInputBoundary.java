package Workout.use_case;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface WorkoutInputBoundary {
    void execute(WorkoutInputData workoutInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException;

    void execute();

    void export(String user, String name, int day);
}
