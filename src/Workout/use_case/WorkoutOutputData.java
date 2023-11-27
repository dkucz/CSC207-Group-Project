package Workout.use_case;

import entity.Workout;

public class WorkoutOutputData {
    private final String exercise;
    private final Workout workout;
    private boolean useCaseFailed;

    public WorkoutOutputData(String exercise, Workout workout, boolean useCaseFailed) {
        this.exercise = exercise;
        this.useCaseFailed = useCaseFailed;
        this.workout = workout;
    }

    public String getExercise() {
        return exercise;
    }

    public Workout getWorkout() { return this.workout; }
}
