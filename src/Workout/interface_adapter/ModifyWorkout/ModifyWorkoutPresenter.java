package Workout.interface_adapter.ModifyWorkout;

import Workout.use_case.ModifyWorkout.ModifyWorkoutOutputBoundary;
import Workout.use_case.ModifyWorkout.ModifyWorkoutOutputData;

import java.util.ArrayList;

public class ModifyWorkoutPresenter implements ModifyWorkoutOutputBoundary {

    private ModifyWorkoutViewModel modViewModel;

    public ModifyWorkoutPresenter(ModifyWorkoutViewModel modViewModel) {
        this.modViewModel = modViewModel;

    }
    @Override
    public void prepareSuccessView(ModifyWorkoutOutputData outputData) {
        String[][] schedule = convertToNestedArray(outputData.getSchedule());
        System.out.println(outputData.getExerciseAdded() + " added to " + outputData.getExerciseAdded());
        ModifyWorkoutState workoutState = modViewModel.getState();
        workoutState.setSchedule(schedule);
        this.modViewModel.setState(workoutState);
        this.modViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(ModifyWorkoutOutputData outputData) {
        String[][] schedule = convertToNestedArray(outputData.getSchedule());
        System.out.println("Nothing added to " + outputData.getExerciseAdded());
        ModifyWorkoutState workoutState = modViewModel.getState();
        workoutState.setSchedule(schedule);
        this.modViewModel.setState(workoutState);
        this.modViewModel.firePropertyChanged();
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
}

