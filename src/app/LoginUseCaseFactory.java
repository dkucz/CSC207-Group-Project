package app;

import login.data_access.LoginUserDataAccessInterface;
import login.interface_adapter.LoginController;
import login.interface_adapter.LoginPresenter;
import login.interface_adapter.LoginViewModel;
import login.use_case.LoginInputBoundary;
import login.use_case.LoginInteractor;
import login.use_case.LoginOutputBoundary;
import login.view.LoginView;
import menu.interface_adapter.MenuViewModel;
import signup.interface_adapter.SignupViewModel;

public class LoginUseCaseFactory {
    public static LoginView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                                   SignupViewModel signupViewModel, MenuViewModel menuViewModel, LoginUserDataAccessInterface loginDAO)
    {
        LoginController loginController = createLoginUseCase(viewManagerModel,
                signupViewModel, loginViewModel, menuViewModel, loginDAO);
        return new LoginView(loginController, loginViewModel);
    }

    private static LoginController createLoginUseCase(ViewManagerModel viewManagerModel,
                                                      SignupViewModel signupViewModel,
                                                      LoginViewModel loginViewModel,
                                                      MenuViewModel menuViewModel, LoginUserDataAccessInterface loginDAO) {
        LoginOutputBoundary loginPresenter = new LoginPresenter(viewManagerModel, menuViewModel, loginViewModel, signupViewModel);
        LoginInputBoundary loginInteractor = new LoginInteractor(loginDAO, loginPresenter);
        return new LoginController(loginInteractor);
    }
}
