package Workout.use_case;

public class WorkoutInputData {

    private String workout;
    private String muscle;
    private String type;
    private String difficulty;

    public WorkoutInputData(String workout, String muscle)
    {
        this.workout = workout;
        this.muscle = muscle;

    }
    public WorkoutInputData(String workout, String muscle, String type)
    {
        this.workout = workout;
        this.muscle = muscle;
        this.type = type;
    }
    public WorkoutInputData(String workout, String muscle, String type, String difficulty)
    {
        this.workout = workout;
        this.muscle = muscle;
        this.type = type;
        this.difficulty = difficulty;
    }
    public String getWorkout() {
        return this.workout;
    }
    public String getMuscle(){ return this.muscle; }

    public String getType() {return this.type;}

    public String getDifficulty() {
        return this.difficulty;
    }
}