package app;

import data_access.GoogleCalendarDAO;
//import data_access.FileUserDataAccessObject;
//import signup.use_case.UserSignupDataAccessInterface;
//import entity.CommonUserFactory;
import app.UserFactory;
import signup.interface_adapter.*;
import login.interface_adapter.*;
import signup.use_case.SignupInputBoundary;
import signup.use_case.SignupInteractor;
import signup.use_case.SignupOutputBoundary;
import signup.view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException {
        UserSignupDataAccessInterface userDataAccessObject = new FileUserDataAccessObject("./accounts.csv", new UserFactory());

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(signupViewModel, loginViewModel, viewManagerModel);

        UserFactory userFactory = new UserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }
}
