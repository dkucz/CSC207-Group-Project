package EntityTest;

import entity.Workout;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WorkoutTest {
    @Test
    public void workoutTest()
    {
        Workout workout = new Workout();
        workout.setExercisesInfo("bench press");
        Assertions.assertEquals("bench press", workout.getExercisesInfo());
    }
}
