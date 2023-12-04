package workout.interface_adapter.ModifyWorkout;

import workout.use_case.ModifyWorkout.ModifyWorkoutOutputBoundary;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputData;
import data_access.GoogleCalendarDAO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;


public class ModifyWorkoutPresenter implements ModifyWorkoutOutputBoundary {

    private workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel modViewModel;

    public ModifyWorkoutPresenter(ModifyWorkoutViewModel modViewModel) {
        this.modViewModel = modViewModel;

    }
//    @Override
//    public void prepareSuccessView(ModifyWorkoutOutputData outputData) {
//        String[][] schedule = convertToNestedArray(outputData.getSchedule());
//        System.out.println(outputData.getExerciseAdded());
//        System.out.println(convertToString(schedule));
//        ModifyWorkoutState workoutState = modViewModel.getState();
//        //modviewModel is null
//        workoutState.setSchedule(schedule);
//        this.modViewModel.setState(workoutState);
//        this.modViewModel.firePropertyChanged();
//    }

    @Override
    public void prepareSuccessView(ModifyWorkoutOutputData outputData) throws GeneralSecurityException, IOException {
        System.out.println("FINALLY");
        System.out.println(outputData.getSchedule());
        int day = outputData.getExerciseDay();
        int hour = outputData.getExerciseHour();
        String chart = convertToString(convertToNestedArray(outputData.getSchedule()));
        System.out.println(chart);

        ArrayList<ArrayList<String>> schedule = outputData.getSchedule();
        ArrayList<String> list = schedule.get(day);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            stringBuilder.append(list.get(i));
            stringBuilder.append("\n");
        }
        String first = list.get(0).toString();
        String response = stringBuilder.toString();
        System.out.println(response);

        GoogleCalendarDAO googleCalendarDAO = new GoogleCalendarDAO();
        String googleID = googleCalendarDAO.findIdByName("Fitness Tracker");
        String startDate = getDateTimeForDay(day, hour+5);
        String endDate = getDateTimeForDay(day, hour+ 6);
        System.out.println("Start date: " + startDate);
        googleCalendarDAO.createEvent(googleID, first, response, startDate, endDate);
        //modviewModel is null
//        workoutState.setSchedule(schedule);
//        this.modViewModel.setState(workoutState);
//        this.modViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(ModifyWorkoutOutputData outputData) {

    }



    public static String getDateTimeForDay(int dayOfWeekNumber, int hour) {
        // Ensure the input is valid (0 to 6)
        if (dayOfWeekNumber < 0 || dayOfWeekNumber > 6) {
            throw new IllegalArgumentException("Invalid day of week number. It should be between 0 and 6.");
        }

        LocalDateTime currentDate = LocalDateTime.now();

        // Calculate the difference between the desired day of the week and the current day of the week
        int daysToAdd = dayOfWeekNumber - currentDate.getDayOfWeek().getValue();
        LocalDateTime desiredDate = currentDate.plusDays(daysToAdd);

        desiredDate = desiredDate.withHour(hour).withMinute(0).withSecond(0);
        char T = 'T';
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return desiredDate.format(formatter);
    }

    public String[][] convertToNestedArray(ArrayList<ArrayList<String>> arrayList) {
        int rows = arrayList.size();
        int cols = 5;

        String[][] nestedArray = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            ArrayList<String> innerList = arrayList.get(i);

            int innerListSize = innerList.size();
            if (innerListSize < cols) {
                // If inner list has less than 'cols' elements, fill remaining spots with "empty"
                for (int j = 0; j < cols; j++) {
                    nestedArray[i][j] = (j < innerListSize) ? innerList.get(j) : "empty";
                }
            } else {
                // If inner list has 'cols' or more elements, copy them to the nested array
                for (int j = 0; j < cols; j++) {
                    nestedArray[i][j] = innerList.get(j);
                }
            }
        }

        return nestedArray;
    }
    @Override
    public String convertToString(String[][] nestedArray) {
        StringBuilder result = new StringBuilder();

        result.append("{");
        for (int i = 0; i < nestedArray.length; i++) {
            result.append("{");
            for (int j = 0; j < nestedArray[i].length; j++) {
                result.append(nestedArray[i][j]);

                if (j < nestedArray[i].length - 1) {
                    result.append(", ");
                }
            }
            result.append("}");
            if (i < nestedArray.length - 1) {
                result.append(", ");
            }
        }

        result.append("}");

        return result.toString();
    }

    public void test(){
        System.out.println("Fuck You");
    }

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        GoogleCalendarDAO googleCalendarDAO = new GoogleCalendarDAO();
        String googleID = googleCalendarDAO.findIdByName("Fitness Tracker");
        String startDate = getDateTimeForDay(1, 8);
        String endDate = getDateTimeForDay(1, 9);
        System.out.println("Start date: " + startDate);
        googleCalendarDAO.createEvent(googleID, "baloney, subronie", "Workout at this time, " +
                "get to the gym", startDate, endDate);
    }
}

