package UseCaseFactoryTest;

import static org.junit.jupiter.api.Assertions.*;

import app.LoginUseCaseFactory;
import app.ViewManagerModel;
import login.data_access.LoginUserDataAccessInterface;
import login.interface_adapter.LoginViewModel;
import menu.interface_adapter.MenuViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import signup.interface_adapter.SignupViewModel;
import login.view.LoginView;

public class LoginUseCaseFactoryTest {
    @Test
    public void testCreate() {
        // Mock dependencies
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        LoginViewModel loginViewModel = Mockito.mock(LoginViewModel.class);
        SignupViewModel signupViewModel = Mockito.mock(SignupViewModel.class);
        MenuViewModel menuViewModel = Mockito.mock(MenuViewModel.class);
        LoginUserDataAccessInterface loginDAO = Mockito.mock(LoginUserDataAccessInterface.class);

        // Call the method to create LoginView
        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, menuViewModel, loginDAO);

        // Verify that the LoginView is not null
        assertNotNull(loginView);

        // You can add more specific assertions based on your application logic
    }
}
