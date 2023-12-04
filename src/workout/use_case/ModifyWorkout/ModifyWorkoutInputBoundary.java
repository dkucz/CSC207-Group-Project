package workout.use_case.ModifyWorkout;

import entity.User;

import java.util.concurrent.ExecutionException;

public interface ModifyWorkoutInputBoundary {
    void execute(User user, String name, int day) throws ExecutionException, InterruptedException;

    void export(User user, String name, int day) throws ExecutionException, InterruptedException;

    void execute();
}
