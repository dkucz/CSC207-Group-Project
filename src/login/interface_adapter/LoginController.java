package login.interface_adapter;

import login.use_case.LoginInputBoundary;
import login.use_case.LoginInputData;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class LoginController {
    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }


    public void execute(String username, String password) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }

    public void execute()
    {
        loginUseCaseInteractor.execute();
    }
}
