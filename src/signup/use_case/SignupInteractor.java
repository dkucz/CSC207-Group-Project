package signup.use_case;

import entity.UserFactory;
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
        } else if (signupInputData.getUsername().equals("") ||
                signupInputData.getPassword().equals("") ||
                signupInputData.getRepeatPassword().equals("")) {
            signupPresenter.prepareFailView("Username, password, or repeat password is empty");
        }
        else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            signupPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            User user = userFactory.create(signupInputData.getUsername(),
                    signupInputData.getPassword(), signupInputData.getGmail());
            signupDataAccess.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getUsername(),
                    now.toString(), false);
            signupPresenter.prepareSuccessView(signupOutputData);
        }
    }

    public void execute()
    {
        signupPresenter.prepareSuccessView();
    }
}