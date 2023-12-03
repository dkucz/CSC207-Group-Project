package menu.interface_adapter;

import Workout.view.WorkoutViewManagerModel;
import entity.User;
import menu.use_case.CreateEventInteractor;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEventController {

    private final CreateEventInteractor createEventInteractor;
    private WorkoutViewManagerModel viewManagerModel;

    public CreateEventController(CreateEventInteractor i, WorkoutViewManagerModel b){
        this.createEventInteractor = i;
        this.viewManagerModel = b;
    }

    public void execute(User u) throws GeneralSecurityException, IOException {
        this.createEventInteractor.execute(u);
        this.viewManagerModel.setActiveView("Workout Creator");
    }







}
