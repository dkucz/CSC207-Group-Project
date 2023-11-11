package signup.use_case;

import app.UserFactory;
import entity.User;
import signup.data_access.SignupUserDataAccessInterface;

import java.time.LocalDateTime;

public class SignupInteractor implements SignupInputBoundary {
    final SignupUserDataAccessInterface signupDataAccess;
    final SignupOutputBoundary signupPresenter;
    final UserFactory userFactory;

    public SignupInteractor(SignupUserDataAccessInterface signupDataAccess,
                            SignupOutputBoundary signupPresenter, UserFactory userFactory)
    {
        this.signupDataAccess = signupDataAccess;
        this.signupPresenter = signupPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignupInputData signupInputData) {
        if (signupDataAccess.existsByName(signupInputData.getUsername())) {
            signupPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            signupPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.create(signupInputData.getUsername(), signupInputData.getPassword());
            signupDataAccess.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(),
                    now.toString(), false);
            signupPresenter.prepareSuccessView(signupOutputData);
        }
    }
}
