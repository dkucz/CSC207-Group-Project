package menu.interface_adapter;

import Workout.view.WorkoutViewManagerModel;
import entity.User;
import menu.use_case.CreateEventInputBoundary;
import menu.use_case.CreateEventInteractor;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEventController {

    private final CreateEventInputBoundary createEventInteractor;
    private WorkoutViewManagerModel viewManagerModel;

    public CreateEventController(CreateEventInputBoundary i){
        this.createEventInteractor = i;
    }

    public void execute(User u) throws GeneralSecurityException, IOException {
        this.createEventInteractor.execute(u);
    }







}
