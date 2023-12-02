package EntityTest;

import entity.FriendFactory;
import entity.Friend;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class FriendTest {
    @Test
    public void userTest()
    {
        Friend friend = new Friend("test");
        friend.setGmail("gmail");
        Assertions.assertEquals("test", friend.getUsername());
        Assertions.assertEquals("gmail", friend.getGmail());
    }

    @Test
    public void friendFactoryTest()
    {
        FriendFactory friendFactory = new FriendFactory();
        Friend friend = friendFactory.create("test", "gmail");
        Assertions.assertEquals("test", friend.getUsername());
        Assertions.assertEquals("gmail", friend.getGmail());
    }

    @Test
    public void testEmptyConstructor()
    {
        Friend friend = new Friend();
        Assertions.assertNotNull(friend);
    }
}
