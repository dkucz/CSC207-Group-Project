package WorkoutTest;


import Workout.interface_adapter.WorkoutPresenter;
import Workout.interface_adapter.WorkoutState;
import Workout.interface_adapter.WorkoutViewModel;
import Workout.use_case.WorkoutOutputData;
import app.ViewManagerModel;
import entity.User;
import entity.Workout;
import menu.interface_adapter.MenuState;
import menu.interface_adapter.MenuViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WorkoutPresenterTest {
    private ViewManagerModel viewManagerModel;
    private MenuViewModel menuViewModel;
    private WorkoutViewModel workoutViewModel;
    private WorkoutPresenter workoutPresenter;

    @Before
    public void setUp() {
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        workoutViewModel = new WorkoutViewModel();
        workoutPresenter = new WorkoutPresenter(viewManagerModel, menuViewModel, workoutViewModel);
    }

    @Test
    public void testPrepareSuccessView() {
        Workout workout = new Workout();
        workout.setExercisesInfo("Exercise Info");
        WorkoutOutputData workoutOutputData = new WorkoutOutputData("Exercise Info",
                workout, false);

        // Act
        workoutPresenter.prepareSuccessView(workoutOutputData);

        // Assert
        WorkoutState state = workoutViewModel.getState();
        Assertions.assertEquals("Exercise Info", state.getWorkout().getExercisesInfo());
    }

    @Test
    public void testPrepareFailView() {
        String error = "Invalid input";
        workoutPresenter.prepareFailView(error);
    }

    @Test
    public void testPrepareMenuView() {
        // Arrange
        User user = new User();

        // Act
        workoutPresenter.prepareMenuView(user);
    }
}
