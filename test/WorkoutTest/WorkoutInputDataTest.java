package WorkoutTest;

import entity.Workout;
import org.junit.jupiter.api.Test;
import workout.use_case.SearchWorkout.WorkoutInputData;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutInputDataTest {
    @Test
    void testGetters() {
        Workout workout = new Workout(); // Create a Workout instance, replace with actual instantiation logic if needed
        String muscle = "Legs";
        String type = "Strength";
        String difficulty = "Intermediate";

        WorkoutInputData inputData1 = new WorkoutInputData(workout, muscle);
        WorkoutInputData inputData2 = new WorkoutInputData(workout, muscle, type);
        WorkoutInputData inputData3 = new WorkoutInputData(workout, muscle, type, difficulty);

        assertEquals(workout, inputData1.getWorkout());
        assertEquals(muscle, inputData1.getMuscle());
        assertNull(inputData1.getType());
        assertNull(inputData1.getDifficulty());

        assertEquals(workout, inputData2.getWorkout());
        assertEquals(muscle, inputData2.getMuscle());
        assertEquals(type, inputData2.getType());
        assertNull(inputData2.getDifficulty());

        assertEquals(workout, inputData3.getWorkout());
        assertEquals(muscle, inputData3.getMuscle());
        assertEquals(type, inputData3.getType());
        assertEquals(difficulty, inputData3.getDifficulty());
    }

    @Test
    void testGetWorkoutName() {
        Workout workout = new Workout(); // Create a Workout instance, replace with actual instantiation logic if needed
        String muscle = "Legs";
        workout.setExercisesInfo("legs");
        WorkoutInputData inputData = new WorkoutInputData(workout, muscle);

        // Assuming getExercisesInfo() returns a meaningful value
        assertNotNull(inputData.getWorkoutName());
    }
}
