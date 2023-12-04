package login.use_case;

import login.data_access.LoginUserDataAccessInterface;
import entity.User;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDAO;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDAO, LoginOutputBoundary loginPresenter)
    {
        this.userDAO = userDAO;
        this.loginPresenter = loginPresenter;
    }

    public void execute(LoginInputData loginInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        userDAO.deleteTokenFile();
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDAO.existsByName(username))
        {
            loginPresenter.prepareFailView(username + ": Account does not exist");
        } else
        {
            String pwd = userDAO.get(username).getPassword();
            if (!pwd.equals(password))
            {
                loginPresenter.prepareFailView("Password is incorrect");
            }else
            {
                User user = userDAO.get(username);
                userDAO.createStoredCredentials();
                LoginOutputData loginOutputData = new LoginOutputData(user.getUsername(), user, false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }

    public void execute()
    {
        loginPresenter.prepareSuccessView();
    }
}
