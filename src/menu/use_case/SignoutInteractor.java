package menu.use_case;

import app.ViewManagerModel;
import menu.interface_adapter.SignoutPresenter;

public class SignoutInteractor{

    final SignoutPresenter signoutPresenter;

    public SignoutInteractor(SignoutPresenter s){

        this.signoutPresenter = s;

    }
    public void execute(){

        signoutPresenter.prepareSuccessView();

    }





}
