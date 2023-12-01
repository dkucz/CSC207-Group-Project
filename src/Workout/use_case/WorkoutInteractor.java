package Workout.use_case;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.Workout;
import login.data_access.LoginUserDataAccessInterface;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class WorkoutInteractor implements WorkoutInputBoundary {
    final WorkoutDataAccessInterface userDAO;
    final WorkoutOutputBoundary workoutPresenter;

    public WorkoutInteractor(WorkoutDataAccessInterface userDAO, WorkoutOutputBoundary workoutPresenter)
    {
        this.userDAO = userDAO;
        this.workoutPresenter = workoutPresenter;
    }

    public void execute(WorkoutInputData workoutInputData) throws GeneralSecurityException, IOException {
        String workoutName = workoutInputData.getWorkout();
        String muscle = workoutInputData.getMuscle();
        if (!userDAO.existsByName(muscle))
        {
            workoutPresenter.prepareFailView(muscle + " is not a valid muscle");
        } else
        {
                Workout workout = userDAO.get(workoutName);
                WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.GetExercisesInfo(), workout, false);
                workoutPresenter.prepareSuccessView(workoutOutputData);

        }
    }
    public void execute2(WorkoutInputData workoutInputData) {
        String workoutName = workoutInputData.getWorkout();
        String muscle = workoutInputData.getMuscle();
        String type = workoutInputData.getType();

        if (!userDAO.existsByName(muscle)) {
            workoutPresenter.prepareFailView(muscle + ": is not valid");
            return;
        }

        if (!userDAO.existsByType(type)) {
            workoutPresenter.prepareFailView("Not a valid type");
            return;
        }

        try {
            Workout workout = userDAO.get(workoutName);
            WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.FindOfType(), workout, false);
            workoutPresenter.prepareSuccessView(workoutOutputData);
        } catch (Exception e) {
            System.out.println("Doesn't have type parameter");
        }
    }
    public void execute3(WorkoutInputData workoutInputData) {
        String workoutName = workoutInputData.getWorkout();
        String muscle = workoutInputData.getMuscle();
        String type = workoutInputData.getType();
        String difficulty = workoutInputData.getDifficulty();

        if (!userDAO.existsByName(muscle)) {
            workoutPresenter.prepareFailView(muscle + ": is not valid");
            return;
        }

        if (!userDAO.existsByType(type)) {
            workoutPresenter.prepareFailView("Not a valid type");
            return;
        }

        if (!userDAO.existsByDifficulty(difficulty)) {
            workoutPresenter.prepareFailView("Not a valid difficulty");
            return;
        }
        try {
            Workout workout = userDAO.get(workoutName);
            WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.ExercisesOnDifficulty(), workout,
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
}
