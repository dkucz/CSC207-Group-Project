package Workout.interface_adapter.ModifyWorkout;

import Workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import Workout.use_case.ModifyWorkout.ModifyWorkoutInputData;
import Workout.use_case.SearchWorkout.WorkoutInputBoundary;
import Workout.use_case.SearchWorkout.WorkoutOutputData;
import entity.User;

public class ModifyWorkoutController {
    private ModifyWorkoutInputBoundary modInteractor;

    public ModifyWorkoutController(ModifyWorkoutInputBoundary modInteractor) {
        this.modInteractor = modInteractor;
    }
    public void export(User user, String name, int day) {
        modInteractor.export(user, name, day);
        modInteractor.execute(user, name, day);
        System.out.println("Exported " + name + " to " + day);
    }
}
