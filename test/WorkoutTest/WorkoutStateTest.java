package WorkoutTest;

import entity.Workout;
import org.junit.jupiter.api.Test;
import workout.interface_adapter.SearchWorkout.WorkoutState;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutStateTest {
    @Test
    void testDefaultConstructor() {
        WorkoutState workoutState = new WorkoutState();

        assertNotNull(workoutState.getWorkout());
        assertNotNull(workoutState.getExercises());
        assertTrue(workoutState.getExercises().isEmpty());
    }

    @Test
    void testCopyConstructor() {
        Workout originalWorkout = new Workout(); // Replace with actual instantiation logic if needed
        String originalExercises = "Original Exercises";

        WorkoutState originalState = new WorkoutState();
        originalState.setWorkout(originalWorkout);
        originalState.setExercises(originalExercises);

        WorkoutState copiedState = new WorkoutState(originalState);

        assertEquals(originalWorkout, copiedState.getWorkout());
        assertEquals(originalExercises, copiedState.getExercises());
    }

    @Test
    void testSetters() {
        WorkoutState workoutState = new WorkoutState();

        Workout newWorkout = new Workout(); // Replace with actual instantiation logic if needed
        String newExercises = "New Exercises";

        workoutState.setWorkout(newWorkout);
        workoutState.setExercises(newExercises);

        assertEquals(newWorkout, workoutState.getWorkout());
        assertEquals(newExercises, workoutState.getExercises());
    }
}