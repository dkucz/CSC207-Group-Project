package Workout.use_case;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface WorkoutInputBoundary {
    void execute(WorkoutInputData workoutInputData) throws GeneralSecurityException, IOException;

    void execute();
}
