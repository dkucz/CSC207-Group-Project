package WorkoutTest;

import org.junit.Before;
import org.junit.Test;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutState;

import static org.junit.Assert.*;

public class ModifyWorkoutStateTest {

    private ModifyWorkoutState modifyWorkoutState;

    @Before
    public void setUp() {
        modifyWorkoutState = new ModifyWorkoutState();
    }

    @Test
    public void testGetScheduleInitiallyNull() {
        // Verify that getSchedule returns null initially
        assertNull(modifyWorkoutState.getSchedule());
    }

    @Test
    public void testSetAndGetSchedule() {
        // Set a schedule
        String[][] schedule = {{"Exercise1", "Exercise2"}, {"Exercise3", "Exercise4"}};
        modifyWorkoutState.setSchedule(schedule);

        // Verify that getSchedule returns the set schedule
        assertArrayEquals(schedule, modifyWorkoutState.getSchedule());
    }

    @Test
    public void testSetAndGetScheduleMultipleTimes() {
        // Set and reset the schedule multiple times
        String[][] schedule1 = {{"Exercise1", "Exercise2"}, {"Exercise3", "Exercise4"}};
        String[][] schedule2 = {{"Exercise5", "Exercise6"}, {"Exercise7", "Exercise8"}};

        modifyWorkoutState.setSchedule(schedule1);
        assertArrayEquals(schedule1, modifyWorkoutState.getSchedule());

        modifyWorkoutState.setSchedule(schedule2);
        assertArrayEquals(schedule2, modifyWorkoutState.getSchedule());
    }

    // Add more test cases as needed to cover other scenarios

}
