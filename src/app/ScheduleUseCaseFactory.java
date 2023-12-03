package app;

import Friend.data_access.AddFriend.AddFriendDAOInterface;
import Friend.interface_adapter.AddFriend.AddFriendController;
import Friend.interface_adapter.AddFriend.AddFriendPresenter;
import Friend.use_case.AddFriend.AddFriendInputBoundary;
import Friend.use_case.AddFriend.AddFriendInteractor;
import Friend.view.FriendViewManager;
import Workout.data_access.WorkoutDataAccessInterface;
import Workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import Workout.interface_adapter.ModifyWorkout.ModifyWorkoutPresenter;
import Workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import Workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import Workout.use_case.ModifyWorkout.ModifyWorkoutInteractor;
import Workout.use_case.ModifyWorkout.ModifyWorkoutOutputBoundary;
import Workout.view.ScheduleView;
import Workout.view.WorkoutView;
import data_access.ExercisesDAO;
import data_access.FacadeDAO;
import data_access.FirestoreDAO;
import data_access.GoogleCalendarDAO;
import login.interface_adapter.LoginController;
import login.view.LoginView;

import java.io.IOException;

public class ScheduleUseCaseFactory {

    public ScheduleUseCaseFactory(){};
    public static ScheduleView create(ModifyWorkoutViewModel viewModel, WorkoutDataAccessInterface facadeDAO) throws IOException {
    {
        ModifyWorkoutController controller = createModUseCase(viewModel, facadeDAO);

    }

        return new ScheduleView(viewModel);
    }

    public static ModifyWorkoutController createModUseCase(ModifyWorkoutViewModel viewModel, WorkoutDataAccessInterface facadeDAO) {
        ModifyWorkoutPresenter presenter = new ModifyWorkoutPresenter(viewModel);
        ModifyWorkoutInputBoundary interactor = new ModifyWorkoutInteractor(facadeDAO, presenter);
        return new ModifyWorkoutController(interactor);
    }

}
