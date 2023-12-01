package entity;

public class Workout {
    /* Workout class (TBD if abstract) */
    private String exercise;
    private String type;
    private String difficulty;

    public String GetExercisesInfo() {
        return exercise;
    }
    public void SetExercisesInfo(String exercise) {
        this.exercise = exercise;
    }

//    public String FindOfType() {
//        return type;
//    }
//    public void SetType(String type) {
//        this.type = type;
//    }
//
//    public String ExercisesOnDifficulty() {
//        return difficulty;
//    }
//    public void SetDifficulty(String difficulty) {
//        this.difficulty = difficulty;
//    }
}
