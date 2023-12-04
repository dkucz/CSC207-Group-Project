package menu.use_case;

import app.ViewManagerModel;
import menu.interface_adapter.SignoutPresenter;

public class SignoutInteractor implements SignoutInputBoundary {

    final SignoutOutputBoundary signoutPresenter;

    public SignoutInteractor(SignoutOutputBoundary s){

        this.signoutPresenter = s;

    }
    public void execute(){

        signoutPresenter.prepareSuccessView();

    }





}
