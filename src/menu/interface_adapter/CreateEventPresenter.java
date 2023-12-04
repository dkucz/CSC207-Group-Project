package menu.interface_adapter;

import workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import workout.view.WorkoutViewManager;
import workout.view.WorkoutViewManagerModel;
import entity.User;
import menu.use_case.CreateEventOutputBoundary;

public class CreateEventPresenter implements CreateEventOutputBoundary {
    private final WorkoutViewManager workoutViewManager;
    private final WorkoutViewModel workoutViewModel;
    private final WorkoutViewManagerModel workoutViewManagerModel;
    public CreateEventPresenter(WorkoutViewManager w, WorkoutViewModel m){
        this.workoutViewManager = w;
        this.workoutViewModel = m;
        this.workoutViewManagerModel = this.workoutViewManager.getWorkoutViewManagerModel();

    }
    public void prepareSuccessView(User u){
        this.workoutViewManagerModel.setActiveView("Workout Creator");
        System.out.println("prepare success");
        this.workoutViewManagerModel.firePropertyChanged();
        this.workoutViewModel.setCurrentUser(u);
        this.workoutViewModel.firePropertyChanged();
    }































}
