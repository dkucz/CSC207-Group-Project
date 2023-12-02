package SignupTest;

import org.junit.jupiter.api.Test;
import signup.interface_adapter.SignupState;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SignupStateTest {

    @Test
    void testSignupState() {
        String username = "testUser";
        String usernameError = "Invalid username";
        String password = "password123";
        String passwordError = "Weak password";
        String repeatPassword = "password123";
        String repeatPasswordError = "Passwords do not match";
        String gmail = "test@example.com";

        SignupState signupState = new SignupState();
        signupState.setUsername(username);
        signupState.setUsernameError(usernameError);
        signupState.setPassword(password);
        signupState.setPasswordError(passwordError);
        signupState.setRepeatPassword(repeatPassword);
        signupState.setRepeatPasswordError(repeatPasswordError);
        signupState.setGmail(gmail);

        assertEquals(username, signupState.getUsername());
        assertEquals(usernameError, signupState.getUsernameError());
        assertEquals(password, signupState.getPassword());
        assertEquals(passwordError, signupState.getPasswordError());
        assertEquals(repeatPassword, signupState.getRepeatPassword());
        assertEquals(repeatPasswordError, signupState.getRepeatPasswordError());
        assertEquals(gmail, signupState.getGmail());
    }

    @Test
    void testDefaultConstructor() {
        SignupState signupState = new SignupState();

        assertEquals("", signupState.getUsername());
        assertNull(signupState.getUsernameError());
        assertEquals("", signupState.getPassword());
        assertNull(signupState.getPasswordError());
        assertEquals("", signupState.getRepeatPassword());
        assertNull(signupState.getRepeatPasswordError());
        assertEquals("", signupState.getGmail());
    }

    @Test
    void testCopyConstructor() {
        SignupState originalState = new SignupState();
        originalState.setUsername("testUser");
        originalState.setUsernameError("Invalid username");
        originalState.setPassword("password123");
        originalState.setPasswordError("Weak password");
        originalState.setRepeatPassword("password123");
        originalState.setRepeatPasswordError("Passwords do not match");
        originalState.setGmail("test@example.com");

        SignupState copiedState = new SignupState(originalState);

        assertEquals(originalState.getUsername(), copiedState.getUsername());
        assertEquals(originalState.getUsernameError(), copiedState.getUsernameError());
        assertEquals(originalState.getPassword(), copiedState.getPassword());
        assertEquals(originalState.getPasswordError(), copiedState.getPasswordError());
        assertEquals(originalState.getRepeatPassword(), copiedState.getRepeatPassword());
        assertEquals(originalState.getRepeatPasswordError(), copiedState.getRepeatPasswordError());
        assertEquals(originalState.getGmail(), copiedState.getGmail());
    }
}
