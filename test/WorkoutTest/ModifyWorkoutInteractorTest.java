package WorkoutTest;

import entity.Workout;
import org.junit.Before;
import org.junit.Test;
import workout.data_access.WorkoutDataAccessInterface;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import workout.use_case.ModifyWorkout.ModifyWorkoutInteractor;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputBoundary;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputData;
import workout.use_case.SearchWorkout.WorkoutInputData;
import workout.use_case.SearchWorkout.WorkoutInteractor;
import workout.use_case.SearchWorkout.WorkoutOutputBoundary;
import entity.User;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

public class ModifyWorkoutInteractorTest {

    private WorkoutDataAccessInterface workoutDAO;
    private ModifyWorkoutOutputBoundary modifyPresenter;
    private ModifyWorkoutInteractor modifyWorkoutInteractor;

    @Before
    public void setUp() {
        workoutDAO = mock(WorkoutDataAccessInterface.class);
        modifyPresenter = mock(ModifyWorkoutOutputBoundary.class);
        modifyWorkoutInteractor = new ModifyWorkoutInteractor(workoutDAO, modifyPresenter);
    }

    @Test
    public void testExecuteWithValidInput() throws Exception {
        // Mock data and behavior for workoutDAO
        User user = new User("Oliver", "kolivcao@gmail.com", "c");
        String name = "ExerciseName";
        int day = 3;
        int hour = 12;

        when(workoutDAO.hasFiveExercises(user.getUsername(), day)).thenReturn(false);
        when(workoutDAO.getExerciseSchedule(user.getUsername())).thenReturn(new ArrayList<>());

        // Execute the method
        modifyWorkoutInteractor.execute(user, name, day, hour);

        // Verify that the expected methods were called on workoutDAO and modifyPresenter
        verify(workoutDAO).addExercise(user.getUsername(), name, day);
        verify(workoutDAO).hasFiveExercises(user.getUsername(), day);
        verify(workoutDAO).addExerciseToSchedule(user.getUsername(), day, name);
        verify(workoutDAO).getExerciseSchedule(user.getUsername());
        verify(modifyPresenter).prepareSuccessView(any(ModifyWorkoutOutputData.class));
    }

    @Test
    public void testExecuteWithOverHour() throws Exception {
        // Mock data and behavior for workoutDAO
        User user = new User("Oliver", "kolivcao@gmail.com", "c");
        String name = "ExerciseName";
        int day = 3;
        int hour = 20;

        when(workoutDAO.hasFiveExercises(user.getUsername(), day)).thenReturn(false);
        when(workoutDAO.getExerciseSchedule(user.getUsername())).thenReturn(new ArrayList<>());

        // Execute the method
        modifyWorkoutInteractor.execute(user, name, day, hour);

        // Verify that the expected methods were called on workoutDAO and modifyPresenter
        verify(workoutDAO).addExercise(user.getUsername(), name, day);
        verify(workoutDAO).hasFiveExercises(user.getUsername(), day);
        verify(workoutDAO).addExerciseToSchedule(user.getUsername(), day, name);
        verify(workoutDAO).getExerciseSchedule(user.getUsername());
        verify(modifyPresenter).prepareSuccessView(any(ModifyWorkoutOutputData.class));
    }

    @Test(expected = DateTimeException.class)
    public void testExecuteWithInvalidDateTime() throws Exception {
        // Test case for an invalid date/time
        User user = new User("Oliver", "kolivcao@gmail.com", "c");
        String name = "ExerciseName";
        int day = 8; // Invalid day
        int hour = 25; // Invalid hour

        modifyWorkoutInteractor.execute(user, name, day, hour);
    }

    @Test
    public void testExecuteWithFiveExercisesAlreadyAdded() throws Exception {
        // Test case where five exercises are already added for the day
        User user = new User("Oliver", "kolivcao@gmail.com", "c");
        String name = "ExerciseName";
        int day = 3;
        int hour = 12;

        when(workoutDAO.hasFiveExercises(user.getUsername(), day)).thenReturn(true);

        // Execute the method
        modifyWorkoutInteractor.execute(user, name, day, hour);

        // Verify that the expected methods were called on workoutDAO and modifyPresenter
        verify(workoutDAO).addExercise(user.getUsername(), name, day);
        verify(workoutDAO).hasFiveExercises(user.getUsername(), day);
        verify(modifyPresenter).prepareFailView("You can only add 5 exercises to a day");
    }


    ModifyWorkoutController workoutController = new ModifyWorkoutController(new ModifyWorkoutInputBoundary() {

        @Override
        public void execute(User user, String name, int day, int hour) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {

        }


        @Override
        public void execute() {

        }
    });


    // Add more tests to cover other scenarios and edge cases

}
