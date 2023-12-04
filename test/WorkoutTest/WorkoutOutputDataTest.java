package WorkoutTest;

import entity.Workout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import workout.use_case.SearchWorkout.WorkoutOutputData;

public class WorkoutOutputDataTest {
    @Test
    void testGetters() {
        Workout workout = new Workout(); // Replace with actual instantiation logic if needed
        String exerciseInfo = "Sample Exercise Info";
        boolean useCaseFailed = false;

        WorkoutOutputData outputData = new WorkoutOutputData(exerciseInfo, workout, useCaseFailed);

        Assertions.assertEquals(exerciseInfo, outputData.getExercise());
        Assertions.assertEquals(workout, outputData.getWorkout());
    }

    @Test
    void testUseCaseFailed() {
        Workout workout = new Workout(); // Replace with actual instantiation logic if needed
        String exerciseInfo = "Sample Exercise Info";
        boolean useCaseFailed = true;

        WorkoutOutputData outputData = new WorkoutOutputData(exerciseInfo, workout, useCaseFailed);
    }
}