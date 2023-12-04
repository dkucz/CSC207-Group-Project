package WorkoutTest;

import entity.User;
import entity.Workout;
import org.junit.jupiter.api.Test;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.interface_adapter.SearchWorkout.WorkoutController;
import workout.interface_adapter.SearchWorkout.WorkoutState;
import workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import workout.use_case.ModifyWorkout.ModifyWorkoutInteractor;
import workout.use_case.SearchWorkout.WorkoutInputBoundary;
import workout.use_case.SearchWorkout.WorkoutInputData;
import workout.use_case.SearchWorkout.WorkoutInteractor;
import workout.view.WorkoutView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WorkoutViewTest {
    @Test
    void testSearchButtonAction() {
        WorkoutController controller = new WorkoutController(new WorkoutInputBoundary() {
            @Override
            public void execute(WorkoutInputData workoutInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {

            }

            @Override
            public void export(User user, String name, int day) throws ExecutionException, InterruptedException {

            }

            @Override
            public void execute(User user) {

            }
        });
        ModifyWorkoutController workoutController = new ModifyWorkoutController(new ModifyWorkoutInputBoundary() {
            @Override
            public void execute(User user, String name, int day) throws ExecutionException, InterruptedException {

            }

            @Override
            public void export(User user, String name, int day) throws ExecutionException, InterruptedException {

            }

            @Override
            public void execute() {

            }
        });
        WorkoutView view = new WorkoutView(controller, new WorkoutViewModel(), workoutController, new ModifyWorkoutViewModel());
    }
}