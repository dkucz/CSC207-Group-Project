package Workout.use_case.ModifyWorkout;

import Workout.use_case.SearchWorkout.WorkoutOutputData;

public interface ModifyWorkoutOutputBoundary {
    void prepareSuccessView(ModifyWorkoutOutputData outputData);

    void prepareFailView(ModifyWorkoutOutputData outputData);
}
