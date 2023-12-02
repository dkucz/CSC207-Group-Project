package LoginTest;

import login.use_case.LoginInputData;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LoginInputDataTest {

    @Test
    public void DataTest(){
        LoginInputData input = new LoginInputData("testUser", "testPassword");
        Assertions.assertEquals("testUser", input.getUsername());
        Assertions.assertEquals("testPassword", input.getPassword());
    }
}
