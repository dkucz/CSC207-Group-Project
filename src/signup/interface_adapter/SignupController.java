package signup.interface_adapter;

import signup.use_case.SignupInputBoundary;
import signup.use_case.SignupInputData;

public class SignupController {
    final SignupInputBoundary signupInteractor;
    public SignupController(SignupInputBoundary signupInteractor)
    {
        this.signupInteractor = signupInteractor;
    }

    public void execute(String username, String gmail, String password, String repeatPassword)
    {
        SignupInputData signupInputData = new SignupInputData(username, gmail, password, repeatPassword);
        signupInteractor.execute(signupInputData);
    }
}
