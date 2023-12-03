package Workout.interface_adapter.ModifyWorkout;

import entity.Workout;

public class ModifyWorkoutState {

    private String[][] schedule;
    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
}
