package UseCaseFactoryTest;
import static org.junit.jupiter.api.Assertions.*;

import app.SignupUseCaseFactory;
import app.ViewManagerModel;
import login.interface_adapter.LoginViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import signup.interface_adapter.SignupViewModel;
import signup.data_access.SignupUserDataAccessInterface;
import signup.view.SignupView;

public class SignupUseCaseFactoryTest {
    @Test
    public void testCreate() {
        // Mock dependencies
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        LoginViewModel loginViewModel = Mockito.mock(LoginViewModel.class);
        SignupViewModel signupViewModel = Mockito.mock(SignupViewModel.class);
        SignupUserDataAccessInterface signupDAO = Mockito.mock(SignupUserDataAccessInterface.class);

        // Call the method to create SignupView
        try {
            SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, signupDAO);

            // Verify that the SignupView is not null
            assertNotNull(signupView);

            // You can add more specific assertions based on your application logic
        } catch (Exception e) {
            // Handle exceptions or fail the test if an exception is not expected
            fail("Exception not expected: " + e.getMessage());
        }
    }
}
