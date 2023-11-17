package login.use_case;

import login.data_access.LoginUserDataAccessInterface;
import entity.User;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class LoginInteractor implements LoginInputBoundary {
    final LoginUserDataAccessInterface userDAO;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDAO, LoginOutputBoundary loginPresenter)
    {
        this.userDAO = userDAO;
        this.loginPresenter = loginPresenter;
    }

    public void execute(LoginInputData loginInputData) throws GeneralSecurityException, IOException {
        deleteTokenFile();
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDAO.existsByName(username))
        {
            loginPresenter.prepareFailView(username + ": Account does not exist");
        } else
        {
            String pwd = userDAO.get(username).getPassword();
            if (pwd != password)
            {
                loginPresenter.prepareFailView("Password is incorrect");
            }else
            {
                User user = userDAO.get(username);
                userDAO.createStoredCredentials();
                LoginOutputData loginOutputData = new LoginOutputData(user.getUsername(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }

    public void execute()
    {
        loginPresenter.prepareSuccessView();
    }

    private void deleteTokenFile()
    {
    File storedCredentials = new File("./tokens/StoredCredentials");
    storedCredentials.delete();
    }
}