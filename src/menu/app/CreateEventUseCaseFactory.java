package menu.app;

import Workout.interface_adapter.WorkoutViewModel;
import Workout.view.WorkoutViewManager;
import Workout.view.WorkoutViewManagerModel;
import menu.interface_adapter.CreateEventController;
import menu.interface_adapter.CreateEventPresenter;
import menu.use_case.CreateEventInteractor;

public class CreateEventUseCaseFactory {


    public static CreateEventController createEventUseCase(WorkoutViewManagerModel model, WorkoutViewManager workoutViewManager, WorkoutViewModel workoutViewModel){
        CreateEventPresenter createEventPresenter = new CreateEventPresenter(workoutViewManager, workoutViewModel);
        CreateEventInteractor createEventInteractor = new CreateEventInteractor(createEventPresenter);
        return new CreateEventController(createEventInteractor, model);
    }












}
