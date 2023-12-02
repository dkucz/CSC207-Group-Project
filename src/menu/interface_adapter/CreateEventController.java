package menu.interface_adapter;

import entity.User;
import menu.use_case.CreateEventInteractor;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEventController {

    private final CreateEventInteractor createEventInteractor;
    public CreateEventController(CreateEventInteractor i){
        this.createEventInteractor = i;
    }

    public void execute(User u) throws GeneralSecurityException, IOException {
        this.createEventInteractor.execute(u);
    }







}
