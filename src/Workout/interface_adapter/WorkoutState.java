package Workout.interface_adapter;

public class WorkoutState {

    private String workout = "";
    private String muscle = "";
    private String type = "";
    private String difficulty = "";

    public String getWorkout() {
        return workout;
    }

    public String getMuscle() {
        return muscle;
    }
    public void setMuscle(String muscle) {this.muscle = muscle;}

    public String getType() {
        return type;
    }
    public void setType(String muscle) {this.type = muscle;}

    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String muscle) {this.difficulty = muscle;}

}
