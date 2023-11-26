package Workout.use_case;

public class WorkoutInputData {
    private String muscle;
    private String type;
    private String difficulty;

    public WorkoutInputData(String muscle)
    {
        this.muscle = muscle;

    }
    public WorkoutInputData(String muscle, String type)
    {
        this.muscle = muscle;
        this.type = type;
    }
    public WorkoutInputData(String muscle, String type, String difficulty)
    {
        this.muscle = muscle;
        this.type = type;
        this.difficulty = difficulty;
    }

    public String getMuscle(){ return this.muscle; }

    public String getType() {return this.type;}

    public String getDifficulty() {
        return this.difficulty;
    }
}
