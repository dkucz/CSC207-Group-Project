package workout.interface_adapter.ModifyWorkout;

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
