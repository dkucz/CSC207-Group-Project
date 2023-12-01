package Workout.interface_adapter;

import Workout.use_case.WorkoutOutputBoundary;
import Workout.use_case.WorkoutOutputData;
import app.ViewManagerModel;
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

    @Override
    public void prepareSuccessView() {

    }
}
