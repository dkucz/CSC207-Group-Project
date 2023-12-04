package Workout.view;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class WorkoutViewManager implements PropertyChangeListener {
    private final WorkoutViewManagerModel workoutViewManagerModel;
    private ArrayList<JPanel> views = new ArrayList<>();
    // [0] - WorkoutView
    public WorkoutViewManager(WorkoutViewManagerModel w){
        this.workoutViewManagerModel = w;
        this.workoutViewManagerModel.addPropertyChangeListener(this);
    }


    public void addView(JPanel jpanel){
        this.views.add(jpanel);
    }


    public WorkoutViewManagerModel getWorkoutViewManagerModel(){
        return this.workoutViewManagerModel;
    }
    public WorkoutView getWorkoutView(){
        return (WorkoutView) this.views.get(0);
    }


    public void propertyChange(PropertyChangeEvent e){
        if (e.getSource().equals("view")){
            if (e.getNewValue().equals("Workout Creator")){
                this.views.get(0).setVisible(true);
            }
        }
    }







}
