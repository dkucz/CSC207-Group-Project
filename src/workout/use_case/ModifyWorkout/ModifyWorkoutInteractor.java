package workout.use_case.ModifyWorkout;

import workout.data_access.WorkoutDataAccessInterface;
import entity.User;
import entity.Week;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ModifyWorkoutInteractor implements ModifyWorkoutInputBoundary {
    final WorkoutDataAccessInterface workoutDAO;

    private ModifyWorkoutOutputBoundary modifyPresenter;

    public ModifyWorkoutInteractor(WorkoutDataAccessInterface workoutDAO, ModifyWorkoutOutputBoundary modifyPresenter) {
        this.workoutDAO = workoutDAO;
        this.modifyPresenter = modifyPresenter;
    }

//    public void execute(User user, String name, int day) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
//        System.out.println("1");
//        if (day == 1){
//            System.out.println("This is " + user.week.getMon().size());
//            if (canAdd(user.week.getMon())){
//                System.out.println("this works");
////                user.week.getMon().add(name);
//                Week week = user.getWeek();
//                week.getMon().add(name);
//                week.updateSchedule();
//                user.setWeek(week);
//                workoutDAO.save(user);
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                System.out.println("2");
//                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, name + " added to Monday"));
//            }
//            else{
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                System.out.println("2");
//                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
//            }
//        }
//        else if (day == 2){
//            if (canAdd(user.week.getTues())){
////                user.week.getTues().add(name);
////                user.week.updateSchedule();
//                Week week = user.getWeek();
//                week.getTues().add(name);
//                week.updateSchedule();
//                user.setWeek(week);
//                workoutDAO.save(user);
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                System.out.println("2");
//                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, name + " added to Tuesday"));
//            }
//            else{
//                System.out.println("2");
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
//            }
//        }
//        else if (day == 3){
//
//            if (canAdd(user.week.getWed())){
//                System.out.println("2");
////                user.week.getWed().add(name);
////                user.week.updateSchedule();
//                Week week = user.getWeek();
//                week.getWed().add(name);
//                week.updateSchedule();
//                user.setWeek(week);
//                workoutDAO.save(user);
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, name + " added to Wednesday"));
//            }
//            else{
//                System.out.println("2");
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
//            }
//        }
//        else if (day == 4){
//            if (canAdd(user.week.getThur())){
////                user.week.getThur().add(name);
////                user.week.updateSchedule();
//                Week week = user.getWeek();
//                week.getThur().add(name);
//                week.updateSchedule();
//                user.setWeek(week);
//                workoutDAO.save(user);
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPre3senter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, name + " added to Thursday"));
//            }
//            else{
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
//            }
//        }
//        else if (day == 5){
//            if (canAdd(user.week.getFri())){
//                Week week = user.getWeek();
//                week.getFri().add(name);
//                week.updateSchedule();
//                user.setWeek(week);
//                workoutDAO.save(user);
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, name + " added to Friday"));
//            }
//            else{
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
//            }
//        }
//        else if (day == 6){
//            if (canAdd(user.week.getSat())){
//                Week week = user.getWeek();
//                week.getSat().add(name);
//                week.updateSchedule();
//                user.setWeek(week);
////                user.week.getSat().add(name);
////                user.week.updateSchedule();
//                workoutDAO.save(user);
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, name + " added to Saturday"));
//            }
//            else{
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
//            }
//        }
//        else if (day == 7){
//            if (canAdd(user.week.getSun())){
//                Week week = user.getWeek();
//                week.getSun().add(name);
//                week.updateSchedule();
//                user.setWeek(week);
//                workoutDAO.save(user);
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareSuccessView(new ModifyWorkoutOutputData(schedule, name + " added to Sunday"));
//            }
//            else{
//                ArrayList<ArrayList<String>> schedule = user.week.getSchedule();
//                modifyPresenter.prepareFailView(new ModifyWorkoutOutputData(schedule, "You can only add 5 exercises to a day"));
//            }
//        }


//        else {
//            //throw new NullPointerException("Day must be between 1 and 7");
//            System.out.println("Day must be between 1 and 7");
//            //workoutDAO.addExercise(user, name, 1);
//        }
//    }

    @Override
    public void export(User user, String name, int day) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {

    }

    @Override
    public void execute(User user, String name, int day) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        workoutDAO.addExercise(user.getUsername(), name, day);
        System.out.println("Running Interactor");
        System.out.println(workoutDAO.hasFiveExercises(user.getUsername(), day));
        if (!workoutDAO.hasFiveExercises(user.getUsername(), day)){
            ArrayList<ArrayList<String>> schedule = workoutDAO.addExerciseToSchedule(user.getUsername(), day, name);
            System.out.println("Success");
            ModifyWorkoutOutputData  outputData = new ModifyWorkoutOutputData(schedule, name + " added to " + day);
            modifyPresenter.prepareSuccessView(outputData);


        }
        else {
            //ArrayList<ArrayList<String>> schedule = workoutDAO.addExerciseToSchedule(user.getUsername(), day, name);
            modifyPresenter.prepareFailView("You can only add 5 exercises to a day");
            System.out.println("Failure");
        }

    }

    @Override
    public void execute() {

    }

//    public boolean canAdd(ArrayList<String> day){
//        if (day.size() < 6){
//            return true;
//        }
//        else{
//            return false;
//        }
//
//    }


}
