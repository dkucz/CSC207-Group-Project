package Workout.use_case;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.User;
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
        String muscle = workoutInputData.getMuscle();
        String difficulty = workoutInputData.getDifficulty();
        if (!userDAO.existsByName(muscle))
        {
            workoutPresenter.prepareFailView(muscle + ": is not valid");
        } else
        {
            try {
                String type = workoutInputData.getType();
                if (!userDAO.existsByType(type))
                {
                    workoutPresenter.prepareFailView("Not a valid type");
                }else
                {
                    User search = userDAO.get(muscle);
                    WorkoutOutputData workoutOutputData = new WorkoutOutputData(search.getUsername(), search, false);
                    workoutPresenter.prepareSuccessView(workoutOutputData);
                }
            }
            catch(Exception e){
                System.out.println("Doesn't have type parameter");
            };
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
