package workout.interface_adapter.ModifyWorkout;

import workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class ModifyWorkoutController {
    private ModifyWorkoutInputBoundary modInteractor;

    public ModifyWorkoutController(ModifyWorkoutInputBoundary modInteractor) {
        this.modInteractor = modInteractor;
    }
    public void execute(User user, String name, int day, int hour) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        System.out.println("Working");
        //modInteractor.export(user, name, day);
        modInteractor.execute(user, name, day, hour);
        System.out.println("Bruh working");
        System.out.println("Exported " + name + " to " + day);
    }

    public void execute(){
        modInteractor.execute();
    }
}
