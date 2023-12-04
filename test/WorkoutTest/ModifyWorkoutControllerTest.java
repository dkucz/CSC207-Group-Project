package WorkoutTest;

import entity.User;
import org.junit.Before;
import org.junit.Test;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;

import static org.mockito.Mockito.*;

public class ModifyWorkoutControllerTest {

    private ModifyWorkoutInputBoundary modInteractor;
    private ModifyWorkoutController modifyWorkoutController;

    @Before
    public void setUp() {
        modInteractor = mock(ModifyWorkoutInputBoundary.class);
        modifyWorkoutController = new ModifyWorkoutController(modInteractor);
    }

    @Test
    public void testExecuteWithValidInput() throws Exception {
        // Mock data and behavior for modInteractor
        User user = new User("Oliver", "kolivcao@gmail.com", "c");
        String name = "ExerciseName";
        int day = 3;
        int hour = 12;

        // Execute the method
        modifyWorkoutController.execute(user, name, day, hour);

        // Verify that the expected methods were called on modInteractor
        verify(modInteractor).execute(user, name, day, hour);
    }

    @Test
    public void testExecuteWithoutParameters() {
        // Execute the method without parameters
        modifyWorkoutController.execute();

        // Verify that the expected method was called on modInteractor
        verify(modInteractor).execute();
    }

    // Add more test cases to cover other scenarios and edge cases

}
