package EntityTest;

import entity.Exercise;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ExerciseTest {
    @Test
    public void exerciseTest()
    {
        Exercise exercise = new Exercise();
        exercise.setName("bench press");
        exercise.getDifficulty();
        exercise.getMuscle();
        exercise.getType();
        exercise.getEquipment();
        exercise.getInstructions();
        Assertions.assertEquals("bench press", exercise.getName());
        Assertions.assertEquals("bench press", exercise.toString());
    }
}
