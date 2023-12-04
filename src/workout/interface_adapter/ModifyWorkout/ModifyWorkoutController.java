package workout.interface_adapter.ModifyWorkout;

import workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import entity.User;

import java.util.concurrent.ExecutionException;

public class ModifyWorkoutController {
    private ModifyWorkoutInputBoundary modInteractor;

    public ModifyWorkoutController(ModifyWorkoutInputBoundary modInteractor) {
        this.modInteractor = modInteractor;
    }
    public void export(User user, String name, int day) throws ExecutionException, InterruptedException {
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
