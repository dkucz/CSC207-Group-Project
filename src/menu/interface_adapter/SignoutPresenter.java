package menu.interface_adapter;

import app.ViewManagerModel;
import login.interface_adapter.LoginViewModel;
import menu.use_case.SignoutOutputBoundary;

public class SignoutPresenter implements SignoutOutputBoundary {

    private final LoginViewModel loginViewModel;

    private final MenuViewModel menuViewModel;

    private ViewManagerModel viewManagerModel;

    public SignoutPresenter(LoginViewModel l, MenuViewModel m, ViewManagerModel v){

        this.loginViewModel = l;

        this.menuViewModel = m;

        this.viewManagerModel = v;

    }
    public void prepareSuccessView(){

        viewManagerModel.setActiveView(loginViewModel.getViewName());

        viewManagerModel.firePropertyChanged();

    }



}
