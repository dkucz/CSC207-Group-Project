package Workout.view;

import Workout.interface_adapter.WorkoutController;
import Workout.interface_adapter.WorkoutState;
import Workout.interface_adapter.WorkoutViewModel;
import com.google.api.client.json.webtoken.JsonWebSignature;
import login.interface_adapter.LoginState;
import login.view.LabelTextPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WorkoutView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Workout";

    private final WorkoutViewModel workoutViewModel;

    final JButton searchExercise;
    final JButton saveWorkout;
    final JButton exitWorkout;

    private final JTextField searchInputField = new JTextField(15);
    final JButton addExercise;

    public WorkoutView(WorkoutController workoutController, WorkoutViewModel workoutViewModel, JButton killYourself, JButton search, JButton search1) {
        this.workoutViewModel = workoutViewModel;
        this.workoutViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Workout Screen");

        JPanel searchPanel = new JPanel ();
        searchExercise = new JButton(WorkoutViewModel.SEARCH_LABEL);
        searchPanel.add(searchExercise);
        LabelTextPanel searchInfo = new LabelTextPanel(new JLabel("Search"), searchInputField);

        JPanel buttons = new JPanel();
        addExercise = new JButton(WorkoutViewModel.MAKE_WORKOUT_LABEL);
        buttons.add(addExercise);
        saveWorkout = new JButton(WorkoutViewModel.SAVE_LABEL);
        buttons.add(saveWorkout);
        exitWorkout = new JButton(WorkoutViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(exitWorkout);

        addExercise.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        WorkoutState workoutState = workoutViewModel.getState();
                        workoutController.execute(workoutState.getUsername(), workoutState.getPassword());
                    }
                }
        );

        saveWorkout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        WorkoutState workoutState = workoutViewModel.getState();
                        workoutController.execute(workoutState.getUsername(), workoutState.getPassword());
                    }
                }
        );

        exitWorkout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        WorkoutState workoutState = workoutViewModel.getState();
                        workoutController.execute(workoutState.getUsername(), workoutState.getPassword());
                    }
                }
        );

        searchInputField.addKeyListener(

                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        WorkoutState currentState = workoutViewModel.getState();
                        currentState.setPassword(searchInputField.getText() + e.getKeyChar());
                        workoutViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }

                }
        );






    }






    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
