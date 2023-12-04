package workout.use_case.SearchWorkout;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface WorkoutInputBoundary {
    void execute(WorkoutInputData workoutInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException;

    void export(User user, String name, int day) throws ExecutionException, InterruptedException;

    void execute(User user);
}
