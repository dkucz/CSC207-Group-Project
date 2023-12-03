package SignupTest;

import login.interface_adapter.LoginState;
import login.interface_adapter.LoginViewModel;
import app.ViewManagerModel;
import signup.interface_adapter.SignupPresenter;
import signup.interface_adapter.SignupViewModel;
import signup.use_case.SignupOutputData;
import org.junit.Before;
import org.junit.Test;
import signup.interface_adapter.SignupState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SignupPresenterTest {

    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private ViewManagerModel viewManagerModel;
    private SignupPresenter signupPresenter;

    @Before
    public void setUp() {
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        viewManagerModel = new ViewManagerModel();
        signupPresenter = new SignupPresenter(signupViewModel, loginViewModel, viewManagerModel);
    }

    @Test
    public void testPrepareSuccessView() {
        SignupOutputData outputData = new SignupOutputData("testUser", false);

        signupPresenter.prepareSuccessView(outputData);

        // Verify that the LoginViewModel was updated with the new username
        LoginState loginState = loginViewModel.getState();
        assertEquals("testUser", loginState.getUsername());

        // Verify that setActiveView was called on ViewManagerModel
        assertEquals(loginViewModel.getViewName(), viewManagerModel.getActiveView());
    }

    @Test
    public void testPrepareFailView() {
        signupPresenter.prepareFailView("Error message");

        SignupState signupState = signupViewModel.getState();
        assertEquals("Error message", signupState.getUsernameError());
    }

    @Test
    public void testSecondSuccessView()
    {
        signupPresenter.prepareSuccessView();
        SignupState signupState = signupViewModel.getState();
        assertNotNull(signupState);
    }
}
