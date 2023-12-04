package workout.use_case.ModifyWorkout;

import java.util.ArrayList;

public class ModifyWorkoutOutputData {

    private ArrayList<ArrayList<String>> schedule;
    private int exerciseDay;
    private int exerciseHour;

    public ModifyWorkoutOutputData(ArrayList<ArrayList<String>> schedule, int day, int hour) {
        this.schedule = schedule;
        this.exerciseDay = day;
        this.exerciseHour = hour;
    }
    public ArrayList<ArrayList<String>> getSchedule() {
        return this.schedule;
    }

    public int getExerciseDay() {
        return this.exerciseDay;
    }
    public int getExerciseHour() {
        return this.exerciseHour;
    }

}
