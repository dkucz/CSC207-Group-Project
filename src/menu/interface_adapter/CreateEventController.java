package menu.interface_adapter;

import entity.User;
import menu.use_case.CreateEventInteractor;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEventController {
    User cUser;

    public CreateEventController(){
    }
    public void execute() throws GeneralSecurityException, IOException {
        CreateEventInteractor i = new CreateEventInteractor();
        i.execute();
    }
}
