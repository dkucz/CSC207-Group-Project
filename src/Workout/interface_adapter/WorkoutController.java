package Workout.interface_adapter;

import Friend.use_case.FriendPage.FriendInputData;
import Workout.use_case.WorkoutInputBoundary;
import Workout.use_case.WorkoutInputData;
import entity.User;
import login.use_case.LoginInputData;
import entity.Workout;
import menu.interface_adapter.MenuState;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class WorkoutController {

    final WorkoutInputBoundary workoutUseCaseInteractor;


    public WorkoutController(WorkoutInputBoundary workoutUseCaseInteractor) {
        this.workoutUseCaseInteractor = workoutUseCaseInteractor;
    }
    public void execute(String userName) throws ExecutionException, InterruptedException {
        FriendInputData friendInputData = new FriendInputData(userName);
    }

    public void execute(Workout workout, String inputText) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        String[] params = inputText.split(";", 3); // Split the input muscle into up to three parts

        // Assign the split muscles to muscle1, muscle2, and muscle3
        if (params.length > 0) {
            String muscle = params[0];
            WorkoutInputData workoutInputData = new WorkoutInputData(workout, muscle);
            workoutUseCaseInteractor.execute(workoutInputData);
        }

        if (params.length > 1) {
            String muscle = params[0];
            String type = params[1];
            WorkoutInputData workoutInputData = new WorkoutInputData(workout, muscle, type);
            workoutUseCaseInteractor.execute(workoutInputData);
        }

        if (params.length > 2) {
            String muscle = params[0];
            String type = params[1];
            String difficulty = params[2];
            WorkoutInputData workoutInputData = new WorkoutInputData(workout, muscle, type, difficulty);
            workoutUseCaseInteractor.execute(workoutInputData);
            System.out.println("I gave a " + muscle + ", a " + type + ", and a " + difficulty);
        }
    }

    public void export(String user, String name, int day) {
        workoutUseCaseInteractor.export(user, name, day);
    }
}


