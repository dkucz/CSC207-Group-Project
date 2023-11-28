package Workout.interface_adapter;

import Workout.use_case.WorkoutInputBoundary;
import Workout.use_case.WorkoutInputData;
import login.use_case.LoginInputData;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class WorkoutController {

    final WorkoutInputBoundary workoutUseCaseInteractor;

    public WorkoutController(WorkoutInputBoundary workoutInputBoundary, WorkoutInputBoundary workoutUseCaseInteractor) {
        this.workoutUseCaseInteractor = workoutUseCaseInteractor;
    }

    public void execute(String workout, String muscle, String type, String difficulty) throws GeneralSecurityException,
            IOException {
        WorkoutInputData workoutInputData = new WorkoutInputData(
                workout, muscle, type, difficulty);

        workoutUseCaseInteractor.execute(workoutInputData);
        System.out.println(workoutInputData.getWorkout() + " " + workoutInputData.getMuscle());
    }
}
