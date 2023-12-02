package Workout.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WorkoutViewManagerModel {
    private String activeView;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public void firePropertyChanged(){
        this.support.firePropertyChange("view", null, this.activeView);
    }
    public void addPropertyChangeListener(PropertyChangeListener x){
        this.support.addPropertyChangeListener(x);
    }


    public void setActiveView(String view){
        this.activeView = view;
    }
    public String getActiveView(){
        return this.activeView;
    }






}
