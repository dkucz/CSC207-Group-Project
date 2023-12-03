package Workout.interface_adapter.ModifyWorkout;

import Workout.interface_adapter.SearchWorkout.WorkoutState;
import entity.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModifyWorkoutViewModel {

    public User currentUser;

    private ModifyWorkoutState state = new ModifyWorkoutState();

    public ModifyWorkoutViewModel() {
        super();
    }
    public void setState(ModifyWorkoutState state){this.state = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(){support.firePropertyChange("state", null, this.state);}

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
    public ModifyWorkoutState getState() {
        return null;
    }
}
