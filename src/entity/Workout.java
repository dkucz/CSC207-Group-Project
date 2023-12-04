package entity;

import java.util.ArrayList;

public class Workout {
    /* Workout class (TBD if abstract) */
    private String exercise;
    private String type;
    private String difficulty;

    public ArrayList<String> routine = new ArrayList<>();

    public String getExercisesInfo() {
        return exercise;
    }
    public void setExercisesInfo(String exercise) {
        this.exercise = exercise;
    }

    public void routineAdd(String exercise) {
        if (routine.size() < 6)
        {
            routine.add(exercise);
        }
        else{
            System.out.println("You have reached the maximum number of exercises for this workout.");
            throw new NullPointerException("You have reached the maximum number of exercises for this workout.");
        }
    }

    public int routineSize() {
        return routine.size();
    }
}
