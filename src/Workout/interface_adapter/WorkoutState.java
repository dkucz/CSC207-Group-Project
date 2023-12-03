package Workout.interface_adapter;

import entity.Workout;

public class WorkoutState {

    private Workout workout = new Workout();
    private String exercises = "";
//    private String type = "";
//    private String difficulty = "";


    public WorkoutState(){}

    public WorkoutState(WorkoutState copy)
    {
        workout = copy.workout;
        exercises = copy.exercises;
    }

    public Workout getWorkout() {
        return workout;
    }

    public String getExercises() {
        return exercises;
    }
    public void setWorkout(Workout workout) {this.workout = workout;}
    public void setExercises(String exercises) {this.exercises = exercises;}

//    public String getType() {
//        return type;
//    }
//    public void setType(String muscle) {this.type = muscle;}
//
//    public String getDifficulty() {
//        return difficulty;
//    }
//    public void setDifficulty(String muscle) {this.difficulty = muscle;}

}
