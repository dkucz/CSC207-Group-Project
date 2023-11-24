package SignupTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import signup.use_case.SignupInputData;

public class SignupInputDataTest {
    @Test
    void InputDataTest()
    {
        SignupInputData signupInputData = new SignupInputData("test", "gmail",
                "pass", "pass");

        Assertions.assertEquals("test", signupInputData.getUsername());
        Assertions.assertEquals("gmail", signupInputData.getGmail());
        Assertions.assertEquals("pass", signupInputData.getPassword());
        Assertions.assertEquals("pass", signupInputData.getRepeatPassword());
    }
}
