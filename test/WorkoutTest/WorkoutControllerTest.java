package WorkoutTest;

import Workout.interface_adapter.WorkoutController;
import Workout.use_case.WorkoutInputBoundary;
import Workout.use_case.WorkoutInputData;
import entity.User;
import entity.Workout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WorkoutControllerTest {
    private WorkoutInputBoundary workoutUseCaseInteractor;
    private WorkoutController workoutController;

    @Test
    public void successTest() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        WorkoutInputBoundary workoutInteractor = new WorkoutInputBoundary() {
            @Override
            public void execute(WorkoutInputData workoutInputData) {
                Assertions.assertEquals("bench press", workoutInputData.getWorkoutName());
                Assertions.assertEquals("muscle", workoutInputData.getMuscle());
            }

            @Override
            public void export(String user, String name, int day) {

            }

            @Override
            public void execute(User user) {

            }
        };
        WorkoutController workoutController = new WorkoutController(workoutInteractor);
        Workout workout = new Workout();
        workout.setExercisesInfo("bench press");
        workoutController.execute(workout, "muscle");
    }

    @Test
    public void successTest2() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        WorkoutInputBoundary workoutInteractor = new WorkoutInputBoundary() {
            @Override
            public void execute(WorkoutInputData workoutInputData) {
                Assertions.assertEquals("bench press", workoutInputData.getWorkoutName());
                Assertions.assertEquals("muscle", workoutInputData.getMuscle());
                Assertions.assertEquals("type", workoutInputData.getType());
            }

            @Override
            public void export(String user, String name, int day) {

            }

            @Override
            public void execute(User user) {

            }
        };
        WorkoutController workoutController = new WorkoutController(workoutInteractor);
        Workout workout = new Workout();
        workout.setExercisesInfo("bench press");
        workoutController.execute(workout, "muscle;type");
    }

    @Test
    public void successTest3() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        WorkoutInputBoundary workoutInteractor = new WorkoutInputBoundary() {
            @Override
            public void execute(WorkoutInputData workoutInputData) {
                Assertions.assertEquals("bench press", workoutInputData.getWorkoutName());
                Assertions.assertEquals("muscle", workoutInputData.getMuscle());
                Assertions.assertEquals("type", workoutInputData.getType());
                Assertions.assertEquals("difficulty", workoutInputData.getDifficulty());
            }

            @Override
            public void export(String user, String name, int day) {

            }

            @Override
            public void execute(User user) {

            }
        };
        WorkoutController workoutController = new WorkoutController(workoutInteractor);
        Workout workout = new Workout();
        workout.setExercisesInfo("bench press");
        workoutController.execute(workout, "muscle;type;difficulty");
    }
}