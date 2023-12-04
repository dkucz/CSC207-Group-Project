package Workout.interface_adapter.ModifyWorkout;

import Workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import Workout.use_case.ModifyWorkout.ModifyWorkoutInputData;
import Workout.use_case.SearchWorkout.WorkoutInputBoundary;
import Workout.use_case.SearchWorkout.WorkoutOutputData;
import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class ModifyWorkoutController {
    private ModifyWorkoutInputBoundary modInteractor;

    public ModifyWorkoutController(ModifyWorkoutInputBoundary modInteractor) {
        this.modInteractor = modInteractor;
    }
    public void export(User user, String name, int day) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        System.out.println("Working");
        modInteractor.export(user, name, day);
        modInteractor.execute(user, name, day);
        System.out.println("Bruh working");
        System.out.println("Exported " + name + " to " + day);
    }

    public void execute(){
        modInteractor.execute();
    }
}
