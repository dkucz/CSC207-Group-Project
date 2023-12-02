package LoginTest;

import login.interface_adapter.LoginController;
import login.use_case.LoginInputBoundary;
import login.use_case.LoginInputData;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class LoginControllerTest {
    @Test
    public void executeSuccess() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        LoginInputBoundary loginInteractor = new LoginInputBoundary() {
            @Override
            public void execute(LoginInputData loginInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
                Assertions.assertEquals("testUser", loginInputData.getUsername());
                Assertions.assertEquals("testPassword", loginInputData.getPassword());
            }

            @Override
            public void execute() {

            }
        };
        LoginController loginController = new LoginController(loginInteractor);
        loginController.execute("testUser", "testPassword");
    }

    @Test
    public void emptyExecute()
    {
        LoginInputBoundary loginInteractor = new LoginInputBoundary() {
            @Override
            public void execute(LoginInputData loginInputData) {
            }

            @Override
            public void execute() {
                Assertions.assertTrue(true);
            }
        };
        LoginController loginController = new LoginController(loginInteractor);
        loginController.execute();
    }
}
