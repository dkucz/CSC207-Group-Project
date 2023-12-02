package EntityTest;

import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class UserTest {
    @Test
    public void userTest()
    {
        User user = new User("test", "pass", "gmail");
        Assertions.assertEquals("test", user.getUsername());
        Assertions.assertEquals("pass", user.getPassword());
        Assertions.assertEquals("gmail", user.getGmail());
    }

    @Test
    public void userFactoryTest()
    {
        UserFactory userFactory = new UserFactory();
        User user = userFactory.create("test", "pass", "gmail");
        Assertions.assertEquals("test", user.getUsername());
        Assertions.assertEquals("pass", user.getPassword());
        Assertions.assertEquals("gmail", user.getGmail());
    }

    @Test
    public void testEmptyConstructor()
    {
        User user = new User();
        Assertions.assertNotNull(user);
    }
}
