package Workout.interface_adapter;

import Workout.use_case.WorkoutInputBoundary;
import Workout.use_case.WorkoutInputData;
import login.use_case.LoginInputData;
import entity.Workout;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class WorkoutController {

    final WorkoutInputBoundary workoutUseCaseInteractor;

    public WorkoutController(WorkoutInputBoundary workoutUseCaseInteractor) {
        this.workoutUseCaseInteractor = workoutUseCaseInteractor;
    }

    public void execute(Workout workout, String muscle, String type, String difficulty) throws GeneralSecurityException,
            IOException {
        WorkoutInputData workoutInputData = new WorkoutInputData(
                workout, muscle, type, difficulty);

        workoutUseCaseInteractor.execute(workoutInputData);
        System.out.println(workoutInputData.getWorkout() + " " + workoutInputData.getDifficulty());
    }


    public void execute(Workout workout, String muscle, String type) throws GeneralSecurityException,
            IOException {
        WorkoutInputData workoutInputData = new WorkoutInputData(
                 workout, muscle, type);

        workoutUseCaseInteractor.execute(workoutInputData);
        System.out.println(workoutInputData.getWorkout() + " " + workoutInputData.getType());
    }

    public void execute(Workout workout, String muscle) throws GeneralSecurityException,
            IOException {
        WorkoutInputData workoutInputData = new WorkoutInputData(
                workout, muscle);

        workoutUseCaseInteractor.execute(workoutInputData);
        System.out.println(workoutInputData.getWorkout() + " " + workoutInputData.getMuscle());
    }
}


