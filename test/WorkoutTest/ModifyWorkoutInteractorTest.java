package WorkoutTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Week;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputBoundary;
import workout.use_case.ModifyWorkout.ModifyWorkoutInteractor;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputData;

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
    public void testExecute() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        // Arrange
        User user = new User("username", "password", "gmail");  // Replace with your actual User creation logic
        String exerciseName = "ExerciseName";
        int day = 1;
        int hour = 10;

        // Mocking behavior of workoutDAO methods
        when(workoutDAO.hasFiveExercises(anyString(), anyInt())).thenReturn(false);
        when(workoutDAO.getExerciseSchedule(anyString())).thenReturn(new ArrayList<>());

        // Act
        modifyWorkoutInteractor.execute(user, exerciseName, day, hour);

        // Assert
        // Add assertions based on the expected behavior of your execute method
        verify(workoutDAO).addExercise(eq(user.getUsername()), eq(exerciseName), eq(day));
        verify(workoutDAO).addExerciseToSchedule(eq(user.getUsername()), eq(day), eq(exerciseName));
        verify(modifyPresenter).prepareSuccessView(any(ModifyWorkoutOutputData.class));
        // Add more assertions as needed
    }
    @Test
    public void testEmptyExecute() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        modifyWorkoutInteractor.execute();
        modifyWorkoutInteractor.export(new User("user", "pass", "gmail"), "user", 0);
    }

    @Test(expected = DateTimeException.class)
    public void testInvalidDate() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        // Arrange
        User user = new User("username", "password", "gmail");  // Replace with your actual User creation logic
        String exerciseName = "ExerciseName";
        int invalidDay = 8;  // Day outside the valid range
        int validHour = 12;

        // Act
        modifyWorkoutInteractor.execute(user, exerciseName, invalidDay, validHour);

        // Assert
        // The test expects a DateTimeException to be thrown, so no further assertions are needed
    }

}