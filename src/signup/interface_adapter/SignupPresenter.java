package signup.interface_adapter;

import login.interface_adapter.LoginState;
import login.interface_adapter.LoginViewModel;
import app.ViewManagerModel;
import signup.use_case.SignupOutputBoundary;
import signup.use_case.SignupOutputData;

public class SignupPresenter implements SignupOutputBoundary {
    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;
    public SignupPresenter(SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel,
                           ViewManagerModel viewManagerModel)
    {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the login view.
        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}
