package LoginTest;

import app.ViewManagerModel;
import entity.User;
import login.interface_adapter.LoginPresenter;
import login.interface_adapter.LoginState;
import login.interface_adapter.LoginViewModel;
import login.use_case.LoginOutputData;
import menu.interface_adapter.MenuViewModel;
import menu.view.MenuView;
import org.junit.Before;
import org.junit.Test;
import signup.interface_adapter.SignupViewModel;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginPresenterTest {

    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;
    private LoginPresenter loginPresenter;
    private MenuViewModel menuViewModel;

    @Before
    public void setUp() {
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        viewManagerModel = new ViewManagerModel();
        menuViewModel = new MenuViewModel();
        loginViewModel.setMenuView(new MenuView(null, menuViewModel));
        loginPresenter = new LoginPresenter(viewManagerModel, menuViewModel, loginViewModel, signupViewModel);
    }

    @Test
    public void testPrepareSuccessView() throws GeneralSecurityException, IOException {
        User user = new User("testUser", "testPass", "test@gmail.com");
        LoginOutputData outputData = new LoginOutputData("testUser", user, false);

        loginPresenter.prepareSuccessView(outputData);

        // Verify that the LoginViewModel was updated with the new username
        LoginState loginState = loginViewModel.getState();

        // Verify that setActiveView was called on ViewManagerModel
        assertEquals(menuViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    public void testPrepareFailView() {
        loginPresenter.prepareFailView("Error message");

        assertEquals("Error message", loginViewModel.getState().getUsernameError());
    }

    @Test
    public void testSecondSuccessView()
    {
        loginPresenter.prepareSuccessView();
        LoginState loginState = loginViewModel.getState();
        assertNotNull(loginState);
    }
}
