package app;

import workout.data_access.WorkoutDataAccessInterface;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutPresenter;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.use_case.ModifyWorkout.ModifyWorkoutInputBoundary;
import workout.use_case.ModifyWorkout.ModifyWorkoutInteractor;
import workout.view.ScheduleView;

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
