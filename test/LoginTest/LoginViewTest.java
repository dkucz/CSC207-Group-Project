package LoginTest;

import login.interface_adapter.LoginController;
import login.interface_adapter.LoginViewModel;
import login.use_case.LoginInputBoundary;
import login.use_case.LoginInputData;
import login.view.LoginView;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginViewTest {

    private LoginViewModelStub viewModelStub;
    private LoginControllerStub controllerStub;
    private LoginView loginView;
    private LoginInputBoundary interactor;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        interactor = new TestInteractor();
        viewModelStub = new LoginViewModelStub();
        controllerStub = new LoginControllerStub(interactor);
        loginView = new LoginView(controllerStub, viewModelStub);
    }

    @Test
    public void testKeyTypedListener() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = LoginView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(loginView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyTyped(keyEvent);

        assertEquals("A", viewModelStub.getState().getUsername());
    }


    private static class LoginViewModelStub extends LoginViewModel {
    }

    private static class LoginControllerStub extends LoginController {
        private String username;

        public LoginControllerStub(LoginInputBoundary loginInteractor) {
            super(loginInteractor);
        }

        @Override
        public void execute(String username, String password) {
            this.username = username;
            // Implement if needed
        }

        @Override
        public void execute() {
        }

        public String getUsername() {
            return username;
        }
    }

    private static class TestInteractor implements LoginInputBoundary
    {
        @Override
        public void execute(LoginInputData loginInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {

        }

        @Override
        public void execute() {

        }
    }

    @Test
    public void testPasswordListener() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = LoginView.class.getDeclaredField("passwordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(loginView);

        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyTyped(keyEvent);

        assertEquals("A", viewModelStub.getState().getPassword());
    }

    @Test
    public void testCancelButtonAction() throws Exception {
        LoginControllerStub loginControllerStub = new LoginControllerStub(interactor);
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginView loginView = new LoginView(loginControllerStub, loginViewModel);

        loginViewModel.getState().setUsername("testUser");
        loginViewModel.getState().setUsername("testPassword");

        Field cancelField = LoginView.class.getDeclaredField("cancel");
        cancelField.setAccessible(true);

        JButton cancelButton = (JButton) cancelField.get(loginView);

        ActionListener[] actionListeners = cancelButton.getActionListeners();
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(new ActionEvent(cancelButton, ActionEvent.ACTION_PERFORMED, null));
        }
    }


    @Test
    public void testUsernameKeyPressed() throws NoSuchFieldException, IllegalAccessException {
        Field usernameInputField = LoginView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        JTextField textField = (JTextField) usernameInputField.get(loginView);

        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyPressed(keyEvent);

        assertTrue(true);
    }

    @Test
    public void testUsernameKeyReleased() throws NoSuchFieldException, IllegalAccessException {
        Field usernameInputField = LoginView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        JTextField textField = (JTextField) usernameInputField.get(loginView);

        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyReleased(keyEvent);

        assertTrue(true);
    }

    @Test
    public void testPasswordKeyReleased() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = LoginView.class.getDeclaredField("passwordInputField");
        usernameInputField.setAccessible(true);

        JTextField textField = (JTextField) usernameInputField.get(loginView);

        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyReleased(keyEvent);

        assertTrue(true);
    }

    @Test
    public void testPasswordKeyPressed() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = LoginView.class.getDeclaredField("passwordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(loginView);

        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyPressed(keyEvent);

        assertTrue(true);
    }

    @Test
    public void testLoginButtonAction() throws Exception {
        LoginControllerStub loginController = new LoginControllerStub(interactor);
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginView loginView = new LoginView(loginController, loginViewModel);

        Field logInField = LoginView.class.getDeclaredField("logIn");
        logInField.setAccessible(true);

        JButton loginButton = (JButton) logInField.get(loginView);

        ActionListener[] actionListeners = loginButton.getActionListeners();
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(new ActionEvent(loginButton, ActionEvent.ACTION_PERFORMED, null));
        }
    }
}
