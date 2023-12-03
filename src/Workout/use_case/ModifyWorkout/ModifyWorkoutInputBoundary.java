package Workout.use_case.ModifyWorkout;

import entity.User;

public interface ModifyWorkoutInputBoundary {
    void execute(User user, String name, int day);

    void export(User user, String name, int day);
}
