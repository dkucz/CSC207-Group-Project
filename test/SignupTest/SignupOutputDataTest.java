package SignupTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import signup.use_case.SignupOutputData;

public class SignupOutputDataTest {
    @Test
    void outputDataTest(){
        SignupOutputData signupOutputData = new SignupOutputData("test", false);
        Assertions.assertEquals("test", signupOutputData.getUsername());
    }
}
