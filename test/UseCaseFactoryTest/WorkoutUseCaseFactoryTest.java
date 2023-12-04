package UseCaseFactoryTest;

import workout.data_access.WorkoutDataAccessInterface;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import workout.view.WorkoutView;
import app.ViewManagerModel;
import app.WorkoutUseCaseFactory;
import data_access.FacadeDAO;
import menu.interface_adapter.MenuViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class WorkoutUseCaseFactoryTest {

    @Test
    public void testCreateWorkoutUseCase() {
        // Mock dependencies
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        WorkoutViewModel workoutViewModel = Mockito.mock(WorkoutViewModel.class);
        MenuViewModel menuViewModel = Mockito.mock(MenuViewModel.class);
        WorkoutDataAccessInterface exerciseDAO = Mockito.mock(WorkoutDataAccessInterface.class);
        ModifyWorkoutViewModel modifyWorkoutViewModel = Mockito.mock(ModifyWorkoutViewModel.class);
        ModifyWorkoutController modifyWorkoutController = Mockito.mock(ModifyWorkoutController.class);

        try {
            WorkoutView workoutView = WorkoutUseCaseFactory.create(viewManagerModel, workoutViewModel,
                    modifyWorkoutViewModel, modifyWorkoutController, menuViewModel, exerciseDAO);
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
        WorkoutUseCaseFactory.createWorkoutUseCase(viewManagerModel, workoutViewModel, menuViewModel, googleCalendar);
    }
}
