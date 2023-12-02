package menu.use_case;

import com.google.api.services.storage.Storage;
import entity.User;
import menu.interface_adapter.CreateEventPresenter;

public class CreateEventInteractor {

    private final CreateEventPresenter createEventPresenter;
    public CreateEventInteractor(CreateEventPresenter c){
        this.createEventPresenter = c;

    }



    public void execute(User u){
        this.createEventPresenter.prepareSuccessView(u);
    }





}