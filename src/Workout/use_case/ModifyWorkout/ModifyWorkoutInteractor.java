package Workout.use_case.ModifyWorkout;

import Workout.data_access.WorkoutDataAccessInterface;
import entity.User;

import java.util.ArrayList;

public class ModifyWorkoutInteractor implements ModifyWorkoutInputBoundary {
    final WorkoutDataAccessInterface workoutDAO;

    private ModifyWorkoutOutputBoundary modifyPresenter;

    public ModifyWorkoutInteractor(WorkoutDataAccessInterface workoutDAO, ModifyWorkoutOutputBoundary modifyPresenter) {
        this.workoutDAO = workoutDAO;
        this.modifyPresenter = modifyPresenter;
    }

    public void execute(User user, String name, int day){

        if (day == 1){
            if (canAdd(user.week.getMon())){
                user.week.getMon().add(name);
                user.week.updateSchedule();
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, "Exercise added to Monday"));
            }
            else{
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
            }
        }
        else if (day == 2){
            if (canAdd(user.week.getTues())){
                user.week.getTues().add(name);
                user.week.updateSchedule();
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, "Exercise added to Monday"));
            }
            else{
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
            }
        }
        else if (day == 3){
            if (canAdd(user.week.getWed())){
                user.week.getWed().add(name);
                user.week.updateSchedule();
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, "Exercise added to Tuesday"));
            }
            else{
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
            }
        }
        else if (day == 4){
            if (canAdd(user.week.getThur())){
                user.week.getThur().add(name);
                user.week.updateSchedule();
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, "Exercise added to Wednesday"));
            }
            else{
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
            }
        }
        else if (day == 5){
            if (canAdd(user.week.getFri())){
                user.week.getFri().add(name);
                user.week.updateSchedule();
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, "Exercise added to Thursday"));
            }
            else{
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
            }
        }
        else if (day == 6){
            if (canAdd(user.week.getSat())){
                user.week.getSat().add(name);
                user.week.updateSchedule();
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, "Exercise added to Friday"));
            }
            else{
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
            }
        }
        else if (day == 7){
            if (canAdd(user.week.getSun())){
                user.week.getSun().add(name);
                user.week.updateSchedule();
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, "Exercise added to Saturday"));
            }
            else{
                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
            }
        }


        else {
            throw new NullPointerException("Day must be between 1 and 7");
            //workoutDAO.addExercise(user, name, 1);
        }
    }

    @Override
    public void export(User user, String name, int day) {
        workoutDAO.addExercise(user.getUsername(), name, day);
    }

    public boolean canAdd(ArrayList<String> day){
        if (day.size() < 6){
            return true;
        }
        else{
            return false;
        }

    }


}
