package workout.use_case.SearchWorkout;

import entity.User;

public interface WorkoutOutputBoundary {
    void prepareSuccessView(WorkoutOutputData exercise);

    void prepareFailView(String error);


    void prepareMenuView(User user);
}
