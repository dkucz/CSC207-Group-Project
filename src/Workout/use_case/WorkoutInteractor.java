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
        String type = workoutInputData.getType();
        String difficulty = workoutInputData.getDifficulty();
        //fix this condition cause its always returning false
        if(workoutDAO.existsByDifficulty(difficulty))
        {
            workoutDAO.ExercisesOnDifficulty(workout, difficulty);
            System.out.println("difficulty activated");
        }
        else if(workoutDAO.existsByType(type))
        {
            workoutDAO.FindOfType(workout, type);
            System.out.println("type activated");
        }
        else if (!workoutDAO.existsByMuscle(muscle))
        {
            WorkoutOutputData workoutOutputData = new WorkoutOutputData("Input was invalid", workout, false);
            workoutPresenter.prepareFailView(muscle + " is not a valid muscle");
            return;
        } else
        {
            workoutDAO.GetExercisesInfo(workout, muscle);
            System.out.println("muscle activated");
        }

            WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.GetExercisesInfo(), workout, false);
            workoutPresenter.prepareSuccessView(workoutOutputData);
            System.out.println("working Interactor");
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
