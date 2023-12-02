package LoginTest;

import entity.User;
import login.use_case.LoginOutputData;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LoginOutputDataTest {
    @Test
    public void OutputDataTest()
    {
        User user = new User("testUser", "testPassword", "test@gmail.com");
        LoginOutputData output = new LoginOutputData("testUser", user, false);
        Assertions.assertEquals("testUser", output.getUsername());
        Assertions.assertEquals("testPassword", output.getUser().getPassword());
        Assertions.assertEquals("test@gmail.com", output.getUser().getGmail());
        Assertions.assertNotNull(output.getUser());
    }
}
