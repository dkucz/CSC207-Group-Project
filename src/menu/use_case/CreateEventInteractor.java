package menu.use_case;

import menu.interface_adapter.CreateEventPresenter;

public class CreateEventInteractor {

    public CreateEventInteractor(){

    }
    public void execute(){
        CreateEventPresenter p = new CreateEventPresenter();
        p.prepareSuccessView();
    }
}