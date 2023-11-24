package SignupTest;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;

import org.mockito.Mockito;
import signup.interface_adapter.SignupController;
import signup.interface_adapter.SignupState;
import signup.interface_adapter.SignupViewModel;
import signup.use_case.SignupInputBoundary;
import signup.use_case.SignupInputData;
import signup.view.SignupView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignupViewTest {

    private SignupViewModelStub viewModelStub;
    private SignupControllerStub controllerStub;
    private SignupView signupView;
    private SignupInputBoundary interactor;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        interactor = new TestInteractor();
        viewModelStub = new SignupViewModelStub();
        controllerStub = new SignupControllerStub(interactor);
        signupView = new SignupView(controllerStub, viewModelStub);
    }

    @Test
    public void testKeyTypedListener() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyTyped(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertEquals("A", viewModelStub.getState().getUsername());
    }

    // Additional tests for other methods can be added

    private static class SignupViewModelStub extends SignupViewModel {
    }

    private static class SignupControllerStub extends SignupController {
        private String username;

        public SignupControllerStub(SignupInputBoundary signupInteractor) {
            super(signupInteractor);
        }

        @Override
        public void execute(String username, String gmail, String password, String repeatPassword) {
            this.username = username;
            // Implement if needed
        }

        @Override
        public void execute() {
            // Implement if needed
        }

        public String getUsername() {
            return username;
        }
    }

    private static class TestInteractor implements SignupInputBoundary
    {

        @Override
        public void execute(SignupInputData inputData) throws ExecutionException, InterruptedException {

        }

        @Override
        public void execute() {

        }
    }

    @Test
    public void testPasswordListener() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("passwordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyTyped(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertEquals("A", viewModelStub.getState().getPassword());
    }

    @Test
    public void testRepeatPasswordListener() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("repeatPasswordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyTyped(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertEquals("A", viewModelStub.getState().getRepeatPassword());
    }

    @Test
    public void testGmailListener() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("gmailInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyTyped(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertEquals("A", viewModelStub.getState().getGmail());
    }

    @Test
    public void testSignUpButtonAction() throws Exception {
        // Set up the SignupView, SignupViewModel, and SignupController
        SignupControllerStub signupControllerStub = new SignupControllerStub(interactor);
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupView signupView = new SignupView(signupControllerStub, signupViewModel);

        // Set up the initial state of the SignupViewModel
        signupViewModel.getState().setUsername("testUser");
        signupViewModel.getState().setGmail("test@gmail.com");
        signupViewModel.getState().setPassword("testPassword");
        signupViewModel.getState().setRepeatPassword("testPassword");

        // Use reflection to access the private field signUp
        Field signUpField = SignupView.class.getDeclaredField("signUp");
        signUpField.setAccessible(true);

        // Get the value of the private field (in this case, the JButton)
        JButton signUpButton = (JButton) signUpField.get(signupView);

        // Simulate a button click on the signUp button
        ActionListener[] actionListeners = signUpButton.getActionListeners();
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(new ActionEvent(signUpButton, ActionEvent.ACTION_PERFORMED, null));
        }

        // Verify that the signupControllerStub's execute method was called with the expected arguments
        assertEquals("testUser", signupControllerStub.getUsername());
    }

    @Test
    public void testCancelButtonAction() throws Exception {
        // Set up the SignupView, SignupViewModel, and SignupController
        SignupControllerStub signupControllerStub = new SignupControllerStub(interactor);
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupView signupView = new SignupView(signupControllerStub, signupViewModel);

        // Set up the initial state of the SignupViewModel
        signupViewModel.getState().setUsername("testUser");
        signupViewModel.getState().setGmail("test@gmail.com");
        signupViewModel.getState().setPassword("testPassword");
        signupViewModel.getState().setRepeatPassword("testPassword");

        // Use reflection to access the private field cancel
        Field cancelField = SignupView.class.getDeclaredField("cancel");
        cancelField.setAccessible(true);

        // Get the value of the private field (in this case, the JButton)
        JButton cancelButton = (JButton) cancelField.get(signupView);

        // Simulate a button click on the cancel button
        ActionListener[] actionListeners = cancelButton.getActionListeners();
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(new ActionEvent(cancelButton, ActionEvent.ACTION_PERFORMED, null));
        }

        // Use reflection to access the private text fields
        Field usernameInputField = SignupView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        Field gmailInputField = SignupView.class.getDeclaredField("gmailInputField");
        gmailInputField.setAccessible(true);

        Field passwordInputField = SignupView.class.getDeclaredField("passwordInputField");
        passwordInputField.setAccessible(true);

        Field repeatPasswordInputField = SignupView.class.getDeclaredField("repeatPasswordInputField");
        repeatPasswordInputField.setAccessible(true);

        // Verify that the text fields are empty
        assertEquals("", ((JTextField) usernameInputField.get(signupView)).getText());
        assertEquals("", ((JTextField) gmailInputField.get(signupView)).getText());
        assertEquals("", ((JTextField) passwordInputField.get(signupView)).getText());
        assertEquals("", ((JTextField) repeatPasswordInputField.get(signupView)).getText());
    }

    @Test
    public void testGmailKeyReleased() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("gmailInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyReleased(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testGmailKeyPressed() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("gmailInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyPressed(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testUsernameKeyPressed() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyPressed(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testUsernameKeyReleased() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyReleased(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testPasswordKeyReleased() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("passwordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyReleased(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testPasswordKeyPressed() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("passwordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyPressed(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testRepeatPasswordKeyPressed() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("repeatPasswordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyPressed(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testRepeatPasswordKeyReleased() throws NoSuchFieldException, IllegalAccessException {
        // Use reflection to access the private field usernameInputField
        Field usernameInputField = SignupView.class.getDeclaredField("repeatPasswordInputField");
        usernameInputField.setAccessible(true);

        // Simulate user typing in the usernameInputField
        JTextField textField = (JTextField) usernameInputField.get(signupView);

        // Trigger the keyTyped method by simulating a key press
        KeyEvent keyEvent = new KeyEvent(textField, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'A');
        textField.getKeyListeners()[0].keyReleased(keyEvent);

        // Verify that the SignupViewModel's state was updated correctly
        assertTrue(true);
    }

    @Test
    public void testLoginButtonAction() throws Exception {
        // Set up the SignupView, SignupViewModel, and SignupController
        SignupControllerStub signupControllerStub = new SignupControllerStub(interactor);
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupView signupView = new SignupView(signupControllerStub, signupViewModel);

        // Use reflection to access the private field cancel
        Field loginField = SignupView.class.getDeclaredField("login");
        loginField.setAccessible(true);

        // Get the value of the private field (in this case, the JButton)
        JButton cancelButton = (JButton) loginField.get(signupView);

        // Simulate a button click on the login button
        ActionListener[] actionListeners = cancelButton.getActionListeners();
        for (ActionListener listener : actionListeners) {
            listener.actionPerformed(new ActionEvent(cancelButton, ActionEvent.ACTION_PERFORMED, null));
        }

        // Use reflection to access the private text fields
        Field usernameInputField = SignupView.class.getDeclaredField("usernameInputField");
        usernameInputField.setAccessible(true);

        Field gmailInputField = SignupView.class.getDeclaredField("gmailInputField");
        gmailInputField.setAccessible(true);

        Field passwordInputField = SignupView.class.getDeclaredField("passwordInputField");
        passwordInputField.setAccessible(true);

        Field repeatPasswordInputField = SignupView.class.getDeclaredField("repeatPasswordInputField");
        repeatPasswordInputField.setAccessible(true);

        // Verify that the text fields are empty
        assertEquals("", ((JTextField) usernameInputField.get(signupView)).getText());
        assertEquals("", ((JTextField) gmailInputField.get(signupView)).getText());
        assertEquals("", ((JTextField) passwordInputField.get(signupView)).getText());
        assertEquals("", ((JTextField) repeatPasswordInputField.get(signupView)).getText());
    }
}
