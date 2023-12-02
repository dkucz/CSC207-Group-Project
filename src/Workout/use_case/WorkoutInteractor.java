package Workout.use_case;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Workout;
import login.data_access.LoginUserDataAccessInterface;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class WorkoutInteractor implements WorkoutInputBoundary {
    final WorkoutDataAccessInterface workoutDAO;


    final WorkoutOutputBoundary workoutPresenter;

    public WorkoutInteractor(WorkoutDataAccessInterface workoutDAO,
                             WorkoutOutputBoundary workoutPresenter)
    {
        this.workoutDAO = workoutDAO;
        this.workoutPresenter = workoutPresenter;
    }

    public void execute(WorkoutInputData workoutInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        Workout workout = workoutInputData.getWorkout();
        String muscle = workoutInputData.getMuscle();
        //fix this condition cause its always returning false
        if (!workoutDAO.existsByMuscle(muscle))
        {
            workoutPresenter.prepareFailView(muscle + " is not a valid muscle");
        } else
        {
            workoutDAO.GetExercisesInfo(workout, muscle);
            WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.GetExercisesInfo(), workout, false);
            workoutPresenter.prepareSuccessView(workoutOutputData);
            System.out.println("working Interactor");

        }
    }
    public void execute2(WorkoutInputData workoutInputData) throws ExecutionException, InterruptedException {
        Workout workout = workoutInputData.getWorkout();
        String muscle = workoutInputData.getMuscle();
        String type = workoutInputData.getType();

        if (!workoutDAO.existsByMuscle(muscle)) {
            workoutPresenter.prepareFailView(muscle + ": is not valid");
            return;
        }

        if (!workoutDAO.existsByType(type)) {
            workoutPresenter.prepareFailView("Not a valid type");
            return;
        }

        try {
            WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.GetExercisesInfo(), workout, false);
            workoutPresenter.prepareSuccessView(workoutOutputData);
        } catch (Exception e) {
            System.out.println("Doesn't have type parameter");
        }
    }
    public void execute3(WorkoutInputData workoutInputData) throws ExecutionException, InterruptedException {
        Workout workout = workoutInputData.getWorkout();
        String muscle = workoutInputData.getMuscle();
        String type = workoutInputData.getType();
        String difficulty = workoutInputData.getDifficulty();

        if (!workoutDAO.existsByMuscle(muscle)) {
            workoutPresenter.prepareFailView(muscle + ": is not valid");
            return;
        }

        if (!workoutDAO.existsByType(type)) {
            workoutPresenter.prepareFailView("Not a valid type");
            return;
        }

        if (!workoutDAO.existsByDifficulty(difficulty)) {
            workoutPresenter.prepareFailView("Not a valid difficulty");
            return;
        }
        try {
            WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.GetExercisesInfo(), workout,
                    false);
            workoutPresenter.prepareSuccessView(workoutOutputData);
        } catch (Exception e) {
            System.out.println("Error fetching workout data: " + e.getMessage());
        }
    }


    public void execute()
    {
        workoutPresenter.prepareSuccessView();
    }


    private static void deleteTokenFile()
    {
    File storedCredentials = new File("./tokens/StoredCredential");
    storedCredentials.delete();
    }

    @Override
    public void export(String user, String name, int day){
        workoutDAO.addExercise(user, name, day);
    }
}
