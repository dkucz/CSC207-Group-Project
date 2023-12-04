package Workout.use_case.SearchWorkout;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Workout;

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
            workoutDAO.exercisesOnDifficulty(workout, difficulty);
            System.out.println("difficulty activated");
        }
        else if(workoutDAO.existsByType(type))
        {
            workoutDAO.findOfType(workout, type);
            System.out.println("type activated");
        }
        else if (!workoutDAO.existsByMuscle(muscle))
        {
            WorkoutOutputData workoutOutputData = new WorkoutOutputData("Input was invalid", workout, false);
            workoutPresenter.prepareFailView(muscle + " is not a valid muscle");
            return;
        } else
        {
            workoutDAO.getExercisesInfo(workout, muscle);
            System.out.println("muscle activated");
        }

            WorkoutOutputData workoutOutputData = new WorkoutOutputData(workout.getExercisesInfo(), workout, false);
            workoutPresenter.prepareSuccessView(workoutOutputData);
            System.out.println("working Interactor");
    }


    public void execute(User user)
    {
        workoutPresenter.prepareMenuView(user);
    }


    @Override
    public void export(User user, String name, int day) throws ExecutionException, InterruptedException {

        if (day >= 1 && day <= 7)
        {
            workoutDAO.addExercise(user.getUsername(), name, day);
        }
        else {
            throw new NullPointerException("Day must be between 1 and 7");
            //workoutDAO.addExercise(user, name, 1);
        }

    }
}
