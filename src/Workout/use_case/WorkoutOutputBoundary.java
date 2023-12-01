package Workout.use_case;

public interface WorkoutOutputBoundary {
    void prepareSuccessView(WorkoutOutputData user);

    void prepareFailView(String error);

    void prepareSuccessView();
}
