package WorkoutTest;

import workout.interface_adapter.SearchWorkout.WorkoutController;
import workout.use_case.SearchWorkout.WorkoutInputBoundary;
import workout.use_case.SearchWorkout.WorkoutInputData;
import entity.User;
import entity.Workout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class WorkoutControllerTest {
    private WorkoutInputBoundary workoutUseCaseInteractor;

    @Test
    public void successTest() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        WorkoutInputBoundary workoutInteractor = new WorkoutInputBoundary() {
            @Override
            public void execute(WorkoutInputData workoutInputData) {
                Assertions.assertEquals("bench press", workoutInputData.getWorkoutName());
                Assertions.assertEquals("muscle", workoutInputData.getMuscle());
            }

            @Override
            public void export(User user, String name, int day) {

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
            public void export(User user, String name, int day) {

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
            public void export(User user, String name, int day) {

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
        @Test
        public void executeTest() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
            WorkoutInputBoundary workoutInteractor = new WorkoutInputBoundary() {
                @Override
                public void execute(WorkoutInputData workoutInputData) {}

                @Override
                public void export(User user, String name, int day) {}

                @Override
                public void execute(User user) {
                    Assertions.assertEquals("testUser", user.getUsername());
                    Assertions.assertEquals("pass", user.getPassword());
                    Assertions.assertEquals("gmail", user.getGmail());
                }
            };
            WorkoutController workoutController = new WorkoutController(workoutInteractor);
            workoutController.execute(new User("testUser", "pass", "gmail"));
        }

        @Test
        public void exportTest() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
            WorkoutInputBoundary workoutInteractor = new WorkoutInputBoundary() {
                @Override
                public void execute(WorkoutInputData workoutInputData) {}

                @Override
                public void export(User user, String name, int day) {
                    Assertions.assertEquals("testUser", user.getUsername());
                    Assertions.assertEquals("pass", user.getPassword());
                    Assertions.assertEquals("gmail", user.getGmail());
                    Assertions.assertEquals(0, day);
                    Assertions.assertEquals("bench", name);
                }

                @Override
                public void execute(User user) {}
            };
            WorkoutController workoutController = new WorkoutController(workoutInteractor);
            workoutController.export(new User("testUser", "pass", "gmail"), "bench", 0);
        }
    }
