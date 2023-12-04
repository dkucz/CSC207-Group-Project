package MenuTest;

import entity.User;
import menu.interface_adapter.MenuState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {

    @Test
    public void testDefaultConstructor() {
        MenuState menuState = new MenuState();

        assertNull(menuState.getCurrentUser());
    }

    @Test
    public void testSetUserAndGetUser() {
        MenuState menuState = new MenuState();
        User user = new User("testUser", "testpass", "test@gmail.com");

        menuState.setUser(user);

        assertEquals(user, menuState.getCurrentUser());
    }

    @Test
    public void testGetGmail() {
        MenuState menuState = new MenuState();
        User user = new User("testUser", "testpass", "test@gmail.com");
        menuState.setUser(user);

        assertEquals("test@gmail.com", menuState.getGmail());
    }

    @Test
    public void testGetUsername() {
        MenuState menuState = new MenuState();
        User user = new User("testUser", "testpass", "test@gmail.com");
        menuState.setUser(user);

        assertEquals("testUser", menuState.getUsername());
    }



}