package Workout.interface_adapter;

import app.ViewModel;

import java.beans.PropertyChangeListener;

public class WorkoutViewModel extends ViewModel {

    public static final String SEARCH_LABEL = "Search for Exercise";
    public static final String MAKE_WORKOUT_LABEL = "Add Exercise";
    public static final String SAVE_LABEL = "Save Workout";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private WorkoutState state = new WorkoutState();

    public WorkoutViewModel() {
        super("Make Workout");
    }
    public void setState(WorkoutState state){this.state = state;}
    public WorkoutState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
