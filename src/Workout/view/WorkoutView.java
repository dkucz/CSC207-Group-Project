package Workout.view;

import Workout.data_access.WorkoutDataAccessInterface;
import Workout.interface_adapter.WorkoutController;
import Workout.interface_adapter.WorkoutState;
import Workout.interface_adapter.WorkoutViewModel;
import app.ViewManagerModel;
import app.WorkoutUseCaseFactory;
import data_access.ExercisesDAO;
import com.google.gson.Gson;
import entity.Exercise;
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
import java.util.Arrays;
import java.util.List;

public class WorkoutView extends JPanel implements ActionListener, PropertyChangeListener {
    private List<String> database; // Simulated database

    private JTextField searchField;
    private JTextArea resultArea;

    //placeholders blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

    public final String viewName = "Workout Creator";

    private final WorkoutViewModel workoutViewModel;

//    final JButton searchExercise;
    final JButton saveWorkout;
    final JButton exitWorkout;

    final JButton addExercise;

    private final JTextField searchInputField = new JTextField(15);
    //final JButton addExercise;
    private List<Exercise> exerciseList;

    public WorkoutView(WorkoutController workoutController, WorkoutViewModel workoutViewModel) {
        this.workoutViewModel = workoutViewModel;
        this.workoutViewModel.addPropertyChangeListener(this);

            // Create the main frame
        JFrame frame = new JFrame("Workout Creator");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // panel to hold components with a BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            // search bar panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton(WorkoutViewModel.SEARCH_LABEL);

            // Create a result area panel
        JPanel resultPanel = new JPanel();
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false); // Make it read-only

        JPanel buttons = new JPanel();
        addExercise = new JButton(WorkoutViewModel.MAKE_WORKOUT_LABEL);
        buttons.add(addExercise);
        saveWorkout = new JButton(WorkoutViewModel.SAVE_LABEL);
        buttons.add(saveWorkout);
        exitWorkout = new JButton(WorkoutViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(exitWorkout);


            // Add components to the search panel
        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        resultPanel.add(new JScrollPane(resultArea));

        mainPanel.add(searchPanel);
        mainPanel.add(resultPanel);
        mainPanel.add(buttons);
        frame.add(mainPanel);

            // Set the frame visibility to true
        frame.setVisible(true);

            // Add ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Call the search method when the button is clicked
                    //WorkoutDataAccessInterface workoutDataAccessInterface = new ExercisesDAO();
                    System.out.println(searchField.getText());
                    //workoutDataAccessInterface.GetExercisesInfo(searchField.getText());

                    //change the way this works so appropriate conditions allow execute 2, 3, or 4 arugmenets
                    WorkoutState workoutState = workoutViewModel.getState();
                    try {
                        //workoutController.execute(workoutState.getWorkout(), workoutState.getExercises());
                        workoutController.execute(workoutState.getWorkout(), searchField.getText());


                        //resultArea.setText(workoutState.getExercises());
                    } catch (GeneralSecurityException ex) {
                        throw new RuntimeException(ex);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    Exercise[] exercises = new Gson().fromJson(workoutState.getExercises(), Exercise[].class);
                    exerciseList = Arrays.asList(exercises);
                    displayNames();

                }
            });


        resultArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int offset = resultArea.viewToModel(evt.getPoint());
                for (Exercise exercise : exerciseList) {
                    if (offset >= exercise.getName().indexOf(exercise.getName()) &&
                            offset <= exercise.getName().indexOf(exercise.getName()) + exercise.getName().length()) {
                        displayFullEntry(exercise);
                        break;
                    }
                }
            }
        });






    }

    private void displayNames() {
        StringBuilder resultText = new StringBuilder();
        for (Exercise exercise : exerciseList) {
            resultText.append(exercise.getName()).append("\n");
            System.out.println(exercise.getName());
        }
        resultArea.setText(resultText.toString());
    }


    private void displayFullEntry(Exercise exercise) {
        resultArea.setText(exercise.toString() + "\n\n" +
                "Type: " + exercise.getType() + "\n" +
                "Muscle: " + exercise.getMuscle() + "\n" +
                "Equipment: " + exercise.getEquipment() + "\n" +
                "Difficulty: " + exercise.getDifficulty() + "\n" +
                "Instructions: " + exercise.getInstructions());
    }
//    public void DatabaseSearchApp() {
//        this.workoutViewModel = workoutViewModel;
//        this.workoutViewModel.addPropertyChangeListener(this);
//
//
//        JLabel title = new JLabel("Workout Screen");
//
//        JPanel searchPanel = new JPanel ();
//        searchExercise = new JButton(WorkoutViewModel.SEARCH_LABEL);
//        searchPanel.add(searchExercise);
//        LabelTextPanel searchInfo = new LabelTextPanel(new JLabel("Search"), searchInputField);
//
//        JPanel buttons = new JPanel();
//        addExercise = new JButton(WorkoutViewModel.MAKE_WORKOUT_LABEL);
//        buttons.add(addExercise);
//        saveWorkout = new JButton(WorkoutViewModel.SAVE_LABEL);
//        buttons.add(saveWorkout);
//        exitWorkout = new JButton(WorkoutViewModel.CANCEL_BUTTON_LABEL);
//        buttons.add(exitWorkout);
//
//        addExercise.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        WorkoutState workoutState = workoutViewModel.getState();
//                        try {
//                            workoutController.execute(workoutState.getWorkout(), workoutState.getMuscle(),
//                                    workoutState.getType(), workoutState.getDifficulty());
//                        } catch (GeneralSecurityException ex) {
//                            throw new RuntimeException(ex);
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    }
//                }
//        );
//
//        saveWorkout.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        WorkoutState workoutState = workoutViewModel.getState();
//                        //frick
//                    }
//                }
//        );
//
//        exitWorkout.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent e) {
//                        WorkoutState workoutState = workoutViewModel.getState();
//                        //call the other thing
//                    }
//                }
//        );
//        searchExercise.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // clean architecture can eat my ass
//                WorkoutDataAccessInterface workoutDataAccessInterface = new ExercisesDAO();
//                workoutDataAccessInterface.GetExercisesInfo(searchInputField.getText());
//            }
//        });
//        searchInputField.addKeyListener(
//
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        WorkoutState currentState = workoutViewModel.getState();
//                        currentState.setPassword(searchInputField.getText() + e.getKeyChar());
//                        workoutViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//
//                    }
//
//                }
//        );
//
//
//
//    }
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        WorkoutViewModel workoutViewModel = new WorkoutViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ExercisesDAO appDAO = new ExercisesDAO();
        WorkoutController workoutController = WorkoutUseCaseFactory.createWorkoutUseCase(viewManagerModel,
                workoutViewModel, menuViewModel, appDAO);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new WorkoutView(workoutView, workoutViewModel);
                new WorkoutView(workoutController, workoutViewModel);
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
