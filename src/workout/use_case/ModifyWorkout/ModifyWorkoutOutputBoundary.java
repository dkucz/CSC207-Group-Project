package workout.use_case.ModifyWorkout;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ModifyWorkoutOutputBoundary {
    void prepareSuccessView(ModifyWorkoutOutputData outputData) throws GeneralSecurityException, IOException;

    void prepareFailView(String outputData);
}
