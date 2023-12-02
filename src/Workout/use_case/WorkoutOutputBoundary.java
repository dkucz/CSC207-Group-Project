package Workout.use_case;

public interface WorkoutOutputBoundary {
    void prepareSuccessView(WorkoutOutputData exercise);

    void prepareFailView(String error);

    void prepareSuccessView();
}
