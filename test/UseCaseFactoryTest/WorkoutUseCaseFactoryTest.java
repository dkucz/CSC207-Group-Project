package UseCaseFactoryTest;

import static org.junit.jupiter.api.Assertions.*;

import Workout.data_access.WorkoutDataAccessInterface;
import Workout.interface_adapter.WorkoutController;
import Workout.interface_adapter.WorkoutViewModel;
import Workout.view.WorkoutView;
import app.ViewManagerModel;
import app.WorkoutUseCaseFactory;
import data_access.FacadeDAO;
import data_access.GoogleCalendarDAO;
import login.interface_adapter.LoginViewModel;
import menu.interface_adapter.MenuViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import signup.interface_adapter.SignupViewModel;

import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class WorkoutUseCaseFactoryTest {

    @Test
    public void testCreateWorkoutUseCase() {
        // Mock dependencies
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        WorkoutViewModel workoutViewModel = Mockito.mock(WorkoutViewModel.class);
        MenuViewModel menuViewModel = Mockito.mock(MenuViewModel.class);
        WorkoutDataAccessInterface exerciseDAO = Mockito.mock(WorkoutDataAccessInterface.class);

        try {
            WorkoutView workoutView = WorkoutUseCaseFactory.create(viewManagerModel, workoutViewModel, menuViewModel, exerciseDAO);
            assertNotNull(workoutView);
        } catch (Exception e) {
            fail("Exception not expected: " + e.getMessage());
        }
    }

    @Test
    public void testCreateMenuView() throws GeneralSecurityException, IOException {
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        MenuViewModel menuViewModel = Mockito.mock(MenuViewModel.class);
        WorkoutViewModel workoutViewModel = Mockito.mock(WorkoutViewModel.class);
        FacadeDAO googleCalendar = Mockito.mock(FacadeDAO.class);
        WorkoutUseCaseFactory.create(viewManagerModel, workoutViewModel, menuViewModel, googleCalendar);
    }
}
