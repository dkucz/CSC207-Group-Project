package WorkoutTest;

import Workout.data_access.WorkoutDataAccessInterface;
import Workout.use_case.WorkoutInputData;
import Workout.use_case.WorkoutInteractor;
import Workout.use_case.WorkoutOutputBoundary;
import entity.User;
import entity.Workout;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

public class WorkoutInteractorTest {

    private WorkoutDataAccessInterface workoutDAO;
    private WorkoutOutputBoundary workoutPresenter;
    private WorkoutInteractor workoutInteractor;

    @Before
    public void setUp() {
        workoutDAO = mock(WorkoutDataAccessInterface.class);
        workoutPresenter = mock(WorkoutOutputBoundary.class);
        workoutInteractor = new WorkoutInteractor(workoutDAO, workoutPresenter);
    }

    @Test
    public void testExecuteWithDifficulty() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        // Arrange
        WorkoutInputData inputData = new WorkoutInputData(new Workout(), "bicep", "push", "easy");

        when(workoutDAO.existsByDifficulty("easy")).thenReturn(true);

        // Act
        workoutInteractor.execute(inputData);

        // Assert
        verify(workoutDAO).ExercisesOnDifficulty(inputData.getWorkout(), "easy");
        // Add additional assertions based on the expected behavior
    }

    @Test
    public void testExecuteWithType() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        // Arrange
        WorkoutInputData inputData = new WorkoutInputData(new Workout(), "bicep", "cardio", "easy");

        when(workoutDAO.existsByDifficulty(anyString())).thenReturn(false);
        when(workoutDAO.existsByType("cardio")).thenReturn(true);

        // Act
        workoutInteractor.execute(inputData);

        // Assert
        verify(workoutDAO).FindOfType(inputData.getWorkout(), "cardio");
        // Add additional assertions based on the expected behavior
    }

    @Test
    public void testExecuteWithInvalidMuscle() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        // Arrange
        WorkoutInputData inputData = new WorkoutInputData(new Workout(), "invalidMuscle", "push", "easy");

        when(workoutDAO.existsByDifficulty(anyString())).thenReturn(false);
        when(workoutDAO.existsByType(anyString())).thenReturn(false);
        when(workoutDAO.existsByMuscle("invalidMuscle")).thenReturn(false);

        // Act
        workoutInteractor.execute(inputData);

        // Assert
        verify(workoutPresenter).prepareFailView("invalidMuscle is not a valid muscle");
        // Add additional assertions based on the expected behavior
    }

    @Test
    public void testExecuteWithValidMuscle() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        // Arrange
        WorkoutInputData inputData = new WorkoutInputData(new Workout(), "validMuscle", "push", "easy");

        when(workoutDAO.existsByDifficulty(anyString())).thenReturn(false);
        when(workoutDAO.existsByType(anyString())).thenReturn(false);
        when(workoutDAO.existsByMuscle("validMuscle")).thenReturn(true);

        // Act
        workoutInteractor.execute(inputData);

        // Assert
        verify(workoutDAO).GetExercisesInfo(inputData.getWorkout(), "validMuscle");
        verify(workoutPresenter).prepareSuccessView(any());
    }

    @Test
    public void testExecuteMenuView() {
        // Arrange
        User user = new User();
        int separator = 123;

        // Act
        workoutInteractor.execute(user, separator);

        // Assert
        verify(workoutPresenter).prepareMenuView(user);
    }

    @Test
    public void testExport() {
        // Arrange
        String user = "testUser";
        String name = "exerciseName";
        int day = 1;

        // Act
        workoutInteractor.export(user, name, day);

        // Assert
        verify(workoutDAO).addExercise(user, name, day);
    }
}
