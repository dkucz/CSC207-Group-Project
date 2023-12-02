package LoginTest;

import org.junit.jupiter.api.Test;
import login.interface_adapter.LoginState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LoginStateTest {

    @Test
    void testLoginState() {
        String username = "testUser";
        String usernameError = "Invalid username";
        String password = "password123";
        String passwordError = "Incorrect password";

        LoginState loginState = new LoginState();
        loginState.setPassword("password123");
        loginState.setUsername("testUser");
        loginState.setUsernameError("Invalid username");
        loginState.setPasswordError("Incorrect password");

        assertEquals(username, loginState.getUsername());
        assertEquals(usernameError, loginState.getUsernameError());
        assertEquals(password, loginState.getPassword());
        assertEquals(passwordError, loginState.getPasswordError());
    }

    @Test
    void testDefaultConstructor() {
        LoginState loginState = new LoginState();

        assertEquals("", loginState.getUsername());
        assertNull(loginState.getUsernameError());
        assertEquals("", loginState.getPassword());
        assertNull(loginState.getPasswordError());
    }

    @Test
    void testCopyConstructor() {
        // Arrange
        LoginState originalState = new LoginState();
        originalState.setUsername("testUser");
        originalState.setUsernameError("Invalid username");
        originalState.setPassword("password123");
        originalState.setPasswordError("Incorrect password");

        LoginState copiedState = new LoginState(originalState);

        assertEquals(originalState.getUsername(), copiedState.getUsername());
        assertEquals(originalState.getUsernameError(), copiedState.getUsernameError());
        assertEquals(originalState.getPassword(), copiedState.getPassword());
        assertEquals(originalState.getPasswordError(), copiedState.getPasswordError());
    }
}
