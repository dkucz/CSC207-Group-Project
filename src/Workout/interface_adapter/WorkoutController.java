package Workout.interface_adapter;

import Workout.use_case.WorkoutInputBoundary;

public class WorkoutController {

    final WorkoutInputBoundary workoutInputBoundary;

    public WorkoutController(WorkoutInputBoundary workoutInputBoundary) {
        this.workoutInputBoundary = workoutInputBoundary;
    }

    public void execute(Object muscle, Object type, Object difficulty) {
    }
}
