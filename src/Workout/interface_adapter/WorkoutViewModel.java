package Workout.interface_adapter;

import app.ViewModel;
import entity.User;
import login.interface_adapter.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WorkoutViewModel extends ViewModel {

    public static final String SEARCH_LABEL = "Search for Exercise";
    public static final String MAKE_WORKOUT_LABEL = "Add Exercise";
    public static final String SAVE_LABEL = "Save Workout";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    public User currentUser;

    private WorkoutState state = new WorkoutState();

    public WorkoutViewModel() {
        super("Make Workout");
    }
    public void setState(WorkoutState state){this.state = state;}
    public WorkoutState getState() {
        return state;
    }
    public void setCurrentUser(User u){
        this.currentUser = u;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(){support.firePropertyChange("state", null, this.state);}

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

































































































































































}
