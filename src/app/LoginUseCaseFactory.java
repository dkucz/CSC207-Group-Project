package app;

import data_access.GoogleCalendarDAO;
import entity.UserFactory;
import loggedin.interface_adapter.LoggedInViewModel;
import login.data_access.LoginUserDataAccessInterface;
import login.interface_adapter.LoginController;
import login.interface_adapter.LoginPresenter;
import login.interface_adapter.LoginViewModel;
import login.use_case.LoginInputBoundary;
import login.use_case.LoginInteractor;
import login.use_case.LoginOutputBoundary;
import login.view.LoginView;
import menu.interface_adapter.MenuViewModel;
import signup.interface_adapter.SignupController;
import signup.interface_adapter.SignupPresenter;
import signup.interface_adapter.SignupViewModel;
import signup.use_case.SignupOutputBoundary;
import signup.view.SignupView;

import javax.swing.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class LoginUseCaseFactory {
    public static LoginView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                                   SignupViewModel signupViewModel, MenuViewModel menuViewModel)
    {
        try {
            LoginController loginController = createLoginUseCase(viewManagerModel,
                    signupViewModel, loginViewModel, menuViewModel);
            return new LoginView(loginController, loginViewModel);
        } catch (IOException | GeneralSecurityException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }
        return null;
    }

    private static LoginController createLoginUseCase(ViewManagerModel viewManagerModel,
                                                      SignupViewModel signupViewModel,
                                                      LoginViewModel loginViewModel,
                                                      MenuViewModel menuViewModel)
            throws GeneralSecurityException, IOException {
        LoginUserDataAccessInterface loginDAO = new GoogleCalendarDAO("./accounts.csv", new UserFactory());
        LoginOutputBoundary loginPresenter = new LoginPresenter(viewManagerModel, menuViewModel, loginViewModel, signupViewModel);
        LoginInputBoundary loginInteractor = new LoginInteractor(loginDAO, loginPresenter);
        return new LoginController(loginInteractor);
    }
}
