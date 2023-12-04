package workout.use_case.ModifyWorkout;

public interface ModifyWorkoutOutputBoundary {
    void prepareSuccessView(ModifyWorkoutOutputData outputData);

    void prepareFailView(ModifyWorkoutOutputData outputData);
}
