package workout.view;

import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.interface_adapter.SearchWorkout.WorkoutController;
import workout.interface_adapter.SearchWorkout.WorkoutState;
import workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import com.google.gson.Gson;
import entity.Exercise;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.DateTimeException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class WorkoutView extends JPanel implements ActionListener, PropertyChangeListener {


    public final String viewname = "Workout View";
    private List<String> database; // Simulated database

    final JTextField searchField;
    final JTextArea resultArea;

    final JPanel buttonPanel;

    public boolean isShowing = false;

    public final String viewName = "Workout Creator";

    private final WorkoutViewModel workoutViewModel;

    private final ModifyWorkoutViewModel modWorkoutViewModel;

    final JButton saveWorkout;
    final JButton exitWorkout;

    final JButton addExercise;

    private final JTextField searchInputField = new JTextField(15);
    //final JButton addExercise;
    private List<Exercise> exerciseList;

    private Exercise standby;

    public WorkoutView(WorkoutController workoutController, WorkoutViewModel workoutViewModel, ModifyWorkoutController modController, ModifyWorkoutViewModel modWorkoutViewModel) {
        this.workoutViewModel = workoutViewModel;
        this.modWorkoutViewModel = modWorkoutViewModel;
        this.workoutViewModel.addPropertyChangeListener(this);


        JFrame frame = new JFrame("Workout Creator");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            // search bar panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton(WorkoutViewModel.SEARCH_LABEL);

        JPanel secondPanel = new JPanel();
        JLabel daySelect = new JLabel("Day(7):Hour(24)");
        JTextField dayInput = new JTextField(10);
        secondPanel.add(daySelect);
        secondPanel.add(dayInput);
        mainPanel.add(secondPanel);



        buttonPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(buttonPanel);

        // Create a result area panel
        JPanel resultPanel = new JPanel();
        resultPanel.setVisible(true);
        resultArea = new JTextArea(10, 30);// Make it read-only

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


        //resultPanel.add(new JScrollPane(resultArea));

        // Add the scroll pane to the main panel
        mainPanel.add(searchPanel);
        mainPanel.add(resultPanel);
        mainPanel.add(scrollPane);
        //mainPanel.add(resultPanel);
        mainPanel.add(buttons);


        frame.add(mainPanel);

        frame.setVisible(true);
            // Add ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(searchField.getText());
                    WorkoutState workoutState = workoutViewModel.getState();
                    try {
                        workoutController.execute(workoutState.getWorkout(), searchField.getText());

                    } catch (DateTimeException | IOException | NullPointerException | ExecutionException |
                             InterruptedException | GeneralSecurityException ex) {
                        JOptionPane.showMessageDialog(null,
                                "Give a valid input",
                                "Invalid",
                                JOptionPane.ERROR_MESSAGE);

                    }

                    Exercise[] exercises = new Gson().fromJson(workoutState.getExercises(), Exercise[].class);
                    System.out.println(exercises.toString());
                    exerciseList = Arrays.asList(exercises);
                    buttonPanel.removeAll();
                    buttonPanel.revalidate();
                    buttonPanel.repaint();
                    addButtons();


                }
            });

        addExercise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String [] inputs = dayInput.getText().split(":");
                    String name = inputs[0];
                    String hour = inputs[1];

                    modController.execute(workoutViewModel.currentUser, standby.getName(),
                            Integer.parseInt(name), Integer.parseInt(hour));
                    workoutController.export(workoutViewModel.currentUser, standby.getName(),
                            Integer.parseInt(name));

                    JOptionPane.showMessageDialog(null,
                            standby.getName() + "s has been added to your schedule",
                            "Confirm",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {

                    JOptionPane.showMessageDialog(null,
                            "Select a valid number day and/or exercise",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (GeneralSecurityException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                System.out.println(workoutViewModel.currentUser.getUsername());
            }
        });


        saveWorkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modController.execute();
//                ScheduleView scheduleView = new ScheduleView(modWorkoutViewModel);
//                scheduleView.setVisible(true);
            }
        });


        exitWorkout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){
//                workoutController.execute(workoutViewModel.currentUser);
//                System.out.println(workoutViewModel.currentUser.getUsername());
                frame.dispose();
            }

        });


    }

    private void addButtons() {
        for (Exercise exercise : exerciseList) {
            JButton button = new JButton(exercise.getName());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayFullEntry(exercise);
                    standby = exercise;
                    System.out.println(standby);
                }
            });
            button.setBorderPainted(false); // Remove the button border
            button.setContentAreaFilled(false);
            buttonPanel.add(button);


            buttonPanel.revalidate();
            buttonPanel.repaint();
        }
    }


    private void displayFullEntry(Exercise exercise) {
        String totalInfo = exercise.toString() + "\n\n" +
                "Type: " + exercise.getType() + "\n" +
                "Muscle: " + exercise.getMuscle() + "\n" +
                "Equipment: " + exercise.getEquipment() + "\n" +
                "Difficulty: " + exercise.getDifficulty() + "\n" +
                "Instructions: " + exercise.getInstructions();
        System.out.println(totalInfo);
        resultArea.setText(totalInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

//    public static void main(String[] args) throws GeneralSecurityException, IOException {
//        WorkoutViewModel workoutViewModel = new WorkoutViewModel();
//        SignupViewModel signupViewModel = new SignupViewModel();
//        MenuViewModel menuViewModel = new MenuViewModel();
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        ModifyWorkoutViewModel modviewModel = new ModifyWorkoutViewModel();
//        ExercisesDAO appDAO = new ExercisesDAO();
//        FirestoreDAO firestoreDAO = new FirestoreDAO();
//        GoogleCalendarDAO google = new GoogleCalendarDAO();
//        FacadeDAO DAO = new FacadeDAO(firestoreDAO, google, appDAO);
//        WorkoutController workoutController = WorkoutUseCaseFactory.createWorkoutUseCase(viewManagerModel,
//                workoutViewModel, menuViewModel, DAO);
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                //new WorkoutView(workoutView, workoutViewModel);
//                new WorkoutView(workoutController, workoutViewModel, modviewModel);
//            }
//        });
//    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
