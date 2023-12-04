package menu.use_case;

import com.google.api.services.storage.Storage;
import entity.User;
import menu.interface_adapter.CreateEventPresenter;

public class CreateEventInteractor implements CreateEventInputBoundary {

    private final CreateEventOutputBoundary createEventPresenter;
    public CreateEventInteractor(CreateEventOutputBoundary c){
        this.createEventPresenter = c;

    }
    public void execute(User u){
        this.createEventPresenter.prepareSuccessView(u);
    }





}