package Workout.use_case;

import entity.Workout;

public class WorkoutOutputData {
    private final String exerciseInfo;
    private final Workout workout;
    private boolean useCaseFailed;

    public WorkoutOutputData(String exerciseInfo, Workout workout, boolean useCaseFailed) {
        this.exerciseInfo = exerciseInfo;
        this.workout = workout;
        this.useCaseFailed = useCaseFailed;
        System.out.println(exerciseInfo);
    }

    public String getExercise() {
        return exerciseInfo;
    }

    public Workout getWorkout() { return this.workout; }
}
