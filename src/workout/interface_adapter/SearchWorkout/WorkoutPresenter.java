package workout.interface_adapter.SearchWorkout;

import workout.use_case.SearchWorkout.WorkoutOutputBoundary;
import workout.use_case.SearchWorkout.WorkoutOutputData;
import app.ViewManagerModel;
import entity.User;
import menu.interface_adapter.MenuState;
import menu.interface_adapter.MenuViewModel;

public class WorkoutPresenter implements WorkoutOutputBoundary {

    private MenuViewModel menuViewModel;
    private ViewManagerModel viewManagerModel;
    private WorkoutViewModel workoutViewModel;

    public WorkoutPresenter(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel, WorkoutViewModel workoutViewModel) {
        this.menuViewModel = menuViewModel;
        this.workoutViewModel = workoutViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(WorkoutOutputData data) {

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
