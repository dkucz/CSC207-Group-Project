package menu.app;

import Workout.interface_adapter.WorkoutViewModel;
import Workout.view.WorkoutViewManager;
import menu.interface_adapter.CreateEventController;
import menu.interface_adapter.CreateEventPresenter;
import menu.use_case.CreateEventInteractor;

public class CreateEventUseCaseFactory {


    private static CreateEventController createEventUseCase(WorkoutViewManager workoutViewManager, WorkoutViewModel workoutViewModel){
        CreateEventPresenter createEventPresenter = new CreateEventPresenter(workoutViewManager, workoutViewModel);
        CreateEventInteractor createEventInteractor = new CreateEventInteractor(createEventPresenter);
        return new CreateEventController(createEventInteractor);
    }












}
