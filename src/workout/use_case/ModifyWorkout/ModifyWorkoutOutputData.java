package workout.use_case.ModifyWorkout;

import java.util.ArrayList;

public class ModifyWorkoutOutputData {

    private ArrayList<ArrayList<String>> schedule;
    private String exerciseAdded;

    public ModifyWorkoutOutputData(ArrayList<ArrayList<String>> schedule, String exerciseAdded) {
        this.schedule = schedule;
        this.exerciseAdded = exerciseAdded;
    }
    public ArrayList<ArrayList<String>> getSchedule() {
        return this.schedule;
    }
    public String getExerciseAdded() {
        return this.exerciseAdded;
    }
}
