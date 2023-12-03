package Workout.interface_adapter;

import Workout.use_case.WorkoutOutputBoundary;
import Workout.use_case.WorkoutOutputData;
import app.ViewManagerModel;
import com.google.gson.Gson;
import entity.User;
import menu.interface_adapter.MenuState;
import menu.interface_adapter.MenuViewModel;

public class WorkoutPresenter implements WorkoutOutputBoundary {

    private MenuViewModel menuViewModel;
    private ViewManagerModel viewManagerModel = null;
    private WorkoutViewModel workoutViewModel;

    public WorkoutPresenter(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel, WorkoutViewModel workoutViewModel) {
        this.menuViewModel = menuViewModel;
        this.workoutViewModel = workoutViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(WorkoutOutputData data) {
        //this.loginViewModel.menuView.setUser(data.getUser());

        WorkoutState workoutState = workoutViewModel.getState();
        workoutState.setExercises(data.getExercise());
        workoutState.setWorkout(data.getWorkout());
        this.workoutViewModel.setState(workoutState);
        this.workoutViewModel.firePropertyChanged();




        this.viewManagerModel.setActiveView(workoutViewModel.getViewName());

        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println(error);
    }



    public void prepareMenuView(User user) {
        MenuState menuState = new MenuState();
        menuState.setUser(user);
        this.menuViewModel.setState(menuState);
        menuViewModel.firePropertyChanged();
        System.out.println("creating Menu");
        viewManagerModel.setActiveView(menuViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
