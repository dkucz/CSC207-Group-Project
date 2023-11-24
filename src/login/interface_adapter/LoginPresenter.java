package login.interface_adapter;

import app.ViewManagerModel;
import login.use_case.LoginOutputBoundary;
import login.use_case.LoginOutputData;
import menu.interface_adapter.MenuState;
import menu.interface_adapter.MenuViewModel;
import signup.interface_adapter.SignupViewModel;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final MenuViewModel menuViewModel;
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          MenuViewModel menuViewModel,
                          LoginViewModel loginViewModel, SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        // Get Menu View and update it
        this.loginViewModel.menuView.setUser(response.getUser());

        MenuState menuState = menuViewModel.getState();
        menuState.setUsername(response.getUsername());
        menuState.setUser(response.getUser());
        this.menuViewModel.setState(menuState);
        this.menuViewModel.firePropertyChanged();



        this.viewManagerModel.setActiveView(menuViewModel.getViewName());

        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView()
    {
        loginViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}
