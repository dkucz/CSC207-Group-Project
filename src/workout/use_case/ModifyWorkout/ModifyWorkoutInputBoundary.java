package workout.use_case.ModifyWorkout;

import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface ModifyWorkoutInputBoundary {
    void execute(User user, String name, int day, int hour) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException;

    void export(User user, String name, int day) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException;

    void execute();
}
