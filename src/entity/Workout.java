package entity;

public class Workout {
    /* Workout class (TBD if abstract) */
    private String exercise;
    private String difficulty;

    public String GetExercisesInfo() {
        return exercise;
    }
    public void SetExercisesInfo(String exercise) {
        this.exercise = exercise;
    }

    public String FindOfType() {
        return null;
    }

    public String ExercisesOnDifficulty() {
        return null;
    }
}
