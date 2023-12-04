package Workout.use_case.ModifyWorkout;

import Workout.use_case.SearchWorkout.WorkoutOutputData;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ModifyWorkoutOutputBoundary {
    void prepareSuccessView(ModifyWorkoutOutputData outputData) throws GeneralSecurityException, IOException;

    void prepareFailView(ModifyWorkoutOutputData outputData);
}
