package app;

//import data_access.FileUserDataAccessObject;
//import signup.use_case.UserSignupDataAccessInterface;
//import entity.CommonUserFactory;

import entity.UserFactory;
import login.interface_adapter.LoginViewModel;
import signup.data_access.SignupUserDataAccessInterface;
import signup.interface_adapter.SignupController;
import signup.interface_adapter.SignupPresenter;
import signup.interface_adapter.SignupViewModel;
import signup.use_case.SignupInputBoundary;
import signup.use_case.SignupInteractor;
import signup.use_case.SignupOutputBoundary;
import signup.view.SignupView;

import javax.swing.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel,
                                    SignupUserDataAccessInterface signupDAO) throws GeneralSecurityException, IOException {
        SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, signupDAO);
        return new SignupView(signupController, signupViewModel);
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel,
                                                            SignupViewModel signupViewModel,
                                                            LoginViewModel loginViewModel,
                                                            SignupUserDataAccessInterface signupDAO) throws IOException, GeneralSecurityException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(signupViewModel, loginViewModel, viewManagerModel);

        UserFactory userFactory = new UserFactory();

        SignupInputBoundary signupInteractor = new SignupInteractor(
                signupDAO, signupOutputBoundary, userFactory);

        return new SignupController(signupInteractor);
    }
}
