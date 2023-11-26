package SignupTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import signup.interface_adapter.SignupController;
import signup.use_case.SignupInputBoundary;
import signup.use_case.SignupInputData;

import java.util.concurrent.ExecutionException;

class SignupControllerTest {
    @Test
    void execute_Success() throws ExecutionException, InterruptedException {
        SignupInputBoundary signupInteractor = new SignupInputBoundary() {
            @Override
            public void execute(SignupInputData inputData) {
                Assertions.assertEquals("testUser", inputData.getUsername());
                Assertions.assertEquals("password", inputData.getPassword());
                Assertions.assertEquals("gmail", inputData.getGmail());
                Assertions.assertEquals("password", inputData.getRepeatPassword());
            }

            @Override
            public void execute() {

            }
        };
        SignupController signupController = new SignupController(signupInteractor);
        signupController.execute("testUser", "gmail", "password", "password");
    }

    @Test
    void emptyExecute()
    {
        SignupInputBoundary signupInteractor = new SignupInputBoundary() {
            @Override
            public void execute(SignupInputData inputData) {
            }

            @Override
            public void execute() {
                Assertions.assertTrue(true);
            }
        };
        SignupController signupController = new SignupController(signupInteractor);
        signupController.execute();
    }
}
