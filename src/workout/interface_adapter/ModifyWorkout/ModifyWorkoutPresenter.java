package workout.interface_adapter.ModifyWorkout;

import workout.use_case.ModifyWorkout.ModifyWorkoutOutputBoundary;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputData;

import java.util.ArrayList;

public class ModifyWorkoutPresenter implements ModifyWorkoutOutputBoundary {

    private ModifyWorkoutViewModel modViewModel;

    public ModifyWorkoutPresenter(ModifyWorkoutViewModel modViewModel) {
        this.modViewModel = modViewModel;
        //import ViewManager
        //set ModState
        //viewmodel set ModState

    }
    @Override
    public void prepareSuccessView(ModifyWorkoutOutputData outputData) {
        String[][] schedule = convertToNestedArray(outputData.getSchedule());
        System.out.println(outputData.getExerciseAdded());
        System.out.println(convertToString(schedule));
        ModifyWorkoutState workoutState = modViewModel.getState();
        //modviewModel is null
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
}

