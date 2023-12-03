package Workout.interface_adapter.ModifyWorkout;

import entity.Workout;

import java.util.Arrays;

public class ModifyWorkoutState {

    private String[][] schedule;
    public String[][] getSchedule() {
        System.out.println("Object: " + Arrays.deepToString(schedule));
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
}
