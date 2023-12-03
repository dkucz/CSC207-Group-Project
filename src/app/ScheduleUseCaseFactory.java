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
import Workout.use_case.ModifyWorkout.ModifyWorkoutInteractor;
import Workout.use_case.ModifyWorkout.ModifyWorkoutOutputBoundary;
import data_access.ExercisesDAO;
import data_access.FacadeDAO;
import data_access.FirestoreDAO;
import data_access.GoogleCalendarDAO;

import java.io.IOException;

public class ScheduleUseCaseFactory {

    public ScheduleUseCaseFactory(){};
    public static ModifyWorkoutController create(ModifyWorkoutViewModel viewModel) throws IOException {

        ModifyWorkoutPresenter presenter = new ModifyWorkoutPresenter(viewModel);

        GoogleCalendarDAO googleDAO = new GoogleCalendarDAO();
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        ExercisesDAO exercisesDAO = new ExercisesDAO();

        FacadeDAO appDAO = new FacadeDAO(firestoreDAO, googleDAO, exercisesDAO);

        ModifyWorkoutInteractor interactor = new ModifyWorkoutInteractor(appDAO, presenter);
        return new ModifyWorkoutController(interactor);
    }
}
