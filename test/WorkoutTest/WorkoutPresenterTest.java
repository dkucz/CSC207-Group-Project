package WorkoutTest;


import Workout.interface_adapter.SearchWorkout.WorkoutPresenter;
import Workout.interface_adapter.SearchWorkout.WorkoutState;
import Workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import Workout.use_case.SearchWorkout.WorkoutOutputData;
import app.ViewManagerModel;
import entity.User;
import entity.Workout;
import menu.interface_adapter.MenuViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
