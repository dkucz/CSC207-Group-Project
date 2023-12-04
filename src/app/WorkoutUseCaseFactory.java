package app;

import workout.data_access.WorkoutDataAccessInterface;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.interface_adapter.SearchWorkout.WorkoutController;
import workout.interface_adapter.SearchWorkout.WorkoutPresenter;
import workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import workout.use_case.SearchWorkout.WorkoutInputBoundary;
import workout.use_case.SearchWorkout.WorkoutInteractor;
import workout.use_case.SearchWorkout.WorkoutOutputBoundary;
import workout.view.WorkoutView;
import menu.interface_adapter.MenuViewModel;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class WorkoutUseCaseFactory {
    public static WorkoutView create(ViewManagerModel viewManagerModel, WorkoutViewModel workoutViewModel, ModifyWorkoutViewModel modviewModel, ModifyWorkoutController modController, MenuViewModel menuViewModel, WorkoutDataAccessInterface appDAO) throws GeneralSecurityException, IOException {
        WorkoutController workoutController = createWorkoutUseCase(viewManagerModel,
                workoutViewModel, menuViewModel, appDAO);
        return new WorkoutView(workoutController, workoutViewModel, modController, modviewModel);
    }

    public static WorkoutController createWorkoutUseCase(ViewManagerModel viewManagerModel,
                                                         WorkoutViewModel workoutViewModel,
                                                         MenuViewModel menuViewModel,
                                                         WorkoutDataAccessInterface exerciseDAO) throws IOException, GeneralSecurityException {

        // Notice how we pass this method's parameters to the Presenter.
        WorkoutOutputBoundary presenter = new WorkoutPresenter(viewManagerModel, menuViewModel, workoutViewModel);
        WorkoutInputBoundary workoutInteractor = new WorkoutInteractor(exerciseDAO, presenter);

        return new WorkoutController(workoutInteractor);
    }
}
