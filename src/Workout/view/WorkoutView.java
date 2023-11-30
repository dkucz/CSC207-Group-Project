package Workout.view;

import Workout.data_access.WorkoutDataAccessInterface;
import Workout.interface_adapter.WorkoutController;
import Workout.interface_adapter.WorkoutState;
import Workout.interface_adapter.WorkoutViewModel;
import app.ViewManagerModel;
import app.WorkoutUseCaseFactory;
import data_access.ExercisesDAO;
import login.view.LabelTextPanel;
import menu.interface_adapter.MenuViewModel;
import signup.interface_adapter.SignupViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutView extends JPanel implements ActionListener, PropertyChangeListener {
    private List<String> database; // Simulated database

    private JTextField searchField;
    private JTextArea resultArea;

    //placeholders blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

    public final String viewName = "Workout";

    private final WorkoutViewModel workoutViewModel;

    final JButton searchExercise;
    final JButton saveWorkout;
    final JButton exitWorkout;

    private final JTextField searchInputField = new JTextField(15);
    final JButton addExercise;

    public WorkoutView(WorkoutController workoutController, WorkoutViewModel workoutViewModel) {
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
                        try {
                            workoutController.execute(workoutState.getWorkout(), workoutState.getMuscle(),
                                    workoutState.getType(), workoutState.getDifficulty());
                        } catch (GeneralSecurityException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );

        saveWorkout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        WorkoutState workoutState = workoutViewModel.getState();
                        //frick
                    }
                }
        );

        exitWorkout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        WorkoutState workoutState = workoutViewModel.getState();
                        //call the other thing
                    }
                }
        );
        searchExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // clean architecture can eat my ass
                WorkoutDataAccessInterface workoutDataAccessInterface = new ExercisesDAO();
                workoutDataAccessInterface.GetExercisesInfo(searchInputField.getText());
            }
        });
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


    public void DatabaseSearchApp() {
        // Initialize the database with some sample data
        database = new ArrayList<>();
        database.add("Java");
        database.add("Python");
        database.add("C++");
        database.add("JavaScript");
        database.add("Ruby");

        // Create the main frame
        JFrame frame = new JFrame("Database Search App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold components with a BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Create a search bar panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Create a result area panel
        JPanel resultPanel = new JPanel();
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false); // Make it read-only


        // Add components to the search panel
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Add components to the result panel
        resultPanel.add(new JScrollPane(resultArea));

        // Add panels to the main panel
        mainPanel.add(searchPanel);
        mainPanel.add(resultPanel);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Set the frame visibility to true
        frame.setVisible(true);

        // Add ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the search method when the button is clicked
                WorkoutDataAccessInterface workoutDataAccessInterface = new ExercisesDAO();
                workoutDataAccessInterface.GetExercisesInfo(searchInputField.getText());
            }
        });
    }
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        WorkoutViewModel workoutViewModel = new WorkoutViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ExercisesDAO appDAO = new ExercisesDAO();
        WorkoutController workoutView = WorkoutUseCaseFactory.createWorkoutUseCase(viewManagerModel,
                workoutViewModel, menuViewModel, appDAO);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new WorkoutView(workoutView, workoutViewModel);
                new WorkoutView(workoutView, workoutViewModel);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
