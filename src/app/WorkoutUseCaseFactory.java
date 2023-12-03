package app;

import Workout.data_access.WorkoutDataAccessInterface;
import Workout.interface_adapter.WorkoutController;
import Workout.interface_adapter.WorkoutPresenter;
import Workout.interface_adapter.WorkoutViewModel;
import Workout.use_case.WorkoutInputBoundary;
import Workout.use_case.WorkoutInteractor;
import Workout.use_case.WorkoutOutputBoundary;
import Workout.view.WorkoutView;
import data_access.GoogleCalendarDAO;
import entity.UserFactory;
import login.interface_adapter.LoginViewModel;
import menu.interface_adapter.MenuViewModel;
import signup.data_access.SignupUserDataAccessInterface;
import signup.interface_adapter.SignupController;
import signup.interface_adapter.SignupPresenter;
import signup.interface_adapter.SignupViewModel;
import signup.use_case.SignupInputBoundary;
import signup.use_case.SignupInteractor;
import signup.use_case.SignupOutputBoundary;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class WorkoutUseCaseFactory {
    private WorkoutUseCaseFactory() {}

    public static WorkoutView create(ViewManagerModel viewManagerModel, WorkoutViewModel workoutViewModel, MenuViewModel menuViewModel, WorkoutDataAccessInterface appDAO) throws GeneralSecurityException, IOException {
        WorkoutController workoutController = WorkoutUseCaseFactory.createWorkoutUseCase(viewManagerModel,
                workoutViewModel, menuViewModel, appDAO);
        return new WorkoutView(workoutController, workoutViewModel);
    }

    private static WorkoutController createWorkoutUseCase(ViewManagerModel viewManagerModel,
                                                                       WorkoutViewModel workoutViewModel,
                                                                       MenuViewModel menuViewModel,
                                                                       WorkoutDataAccessInterface exerciseDAO) throws IOException, GeneralSecurityException {

        WorkoutOutputBoundary presenter = new WorkoutPresenter(viewManagerModel, menuViewModel, workoutViewModel);
        WorkoutInputBoundary workoutInteractor = new WorkoutInteractor(
                exerciseDAO, presenter);

        return new WorkoutController(workoutInteractor);
    }
}
