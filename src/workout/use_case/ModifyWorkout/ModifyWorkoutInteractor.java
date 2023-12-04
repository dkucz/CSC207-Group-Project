package workout.use_case.ModifyWorkout;

import workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Week;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ModifyWorkoutInteractor implements ModifyWorkoutInputBoundary {
    final WorkoutDataAccessInterface workoutDAO;

    private ModifyWorkoutOutputBoundary modifyPresenter;

    public ModifyWorkoutInteractor(WorkoutDataAccessInterface workoutDAO, ModifyWorkoutOutputBoundary modifyPresenter) {
        this.workoutDAO = workoutDAO;
        this.modifyPresenter = modifyPresenter;
    }


    @Override
    public void export(User user, String name, int day) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {

    }

    @Override
    public void execute(User user, String name, int day, int hour) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        workoutDAO.addExercise(user.getUsername(), name, day);
        System.out.println("Running Interactor");
        if (!(day <= 7 && day >= 1) || !(hour <= 23 && hour >= 0)){
            throw new DateTimeException("Invalid Date");
        }
        else if (hour+6 > 23)
        {
            hour = (hour+6)%24;
        }

        System.out.println(workoutDAO.hasFiveExercises(user.getUsername(), day));
        workoutDAO.addExerciseToSchedule(user.getUsername(), day, name);
        ArrayList<ArrayList<String>> schedule = workoutDAO.getExerciseSchedule(user.getUsername());

        ModifyWorkoutOutputData  outputData = new ModifyWorkoutOutputData(schedule, day, hour);
        System.out.println(outputData.getSchedule());
        System.out.println("Success");
        modifyPresenter.prepareSuccessView(outputData);
    }

    @Override
    public void execute() {

    }
}
