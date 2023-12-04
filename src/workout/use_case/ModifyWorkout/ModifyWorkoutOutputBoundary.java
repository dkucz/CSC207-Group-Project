package workout.use_case.ModifyWorkout;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

public interface ModifyWorkoutOutputBoundary {
    void prepareSuccessView(ModifyWorkoutOutputData outputData) throws GeneralSecurityException, IOException;

    void prepareFailView(ModifyWorkoutOutputData outputData);

    String convertToString(String[][] schedule);

    String[][] convertToNestedArray(ArrayList<ArrayList<String>> schedule);
}
