package SignupTest;

import org.junit.Before;
import org.junit.Test;
import signup.interface_adapter.SignupState;
import signup.interface_adapter.SignupViewModel;

import java.beans.PropertyChangeListener;

import static org.junit.Assert.*;

public class SignupViewModelTest {

    private SignupViewModel signupViewModel;
    private TestPropertyChangeListener propertyChangeListener;

    @Before
    public void setUp() {
        signupViewModel = new SignupViewModel();
        propertyChangeListener = new TestPropertyChangeListener();
        signupViewModel.addPropertyChangeListener(propertyChangeListener);
    }

    @Test
    public void testInitialState() {
        SignupState initialState = signupViewModel.getState();

        // Ensure that the initial state is not null
        assertNotNull(initialState);

        // Verify initial state values
        assertEquals(SignupViewModel.TITLE_LABEL, "Sign Up View");
        assertEquals(SignupViewModel.USERNAME_LABEL, "Choose username");
        assertEquals(SignupViewModel.PASSWORD_LABEL, "Choose password");
        assertEquals(SignupViewModel.REPEAT_PASSWORD_LABEL, "Enter password again");
        assertEquals(SignupViewModel.GMAIL, "Enter Gmail");
        assertEquals(SignupViewModel.SIGNUP_BUTTON_LABEL, "Sign up");
        assertEquals(SignupViewModel.CANCEL_BUTTON_LABEL, "Cancel");
        assertEquals(SignupViewModel.LOGIN_BUTTON_LABEL, "Login");
    }

    @Test
    public void testSetStateAndNotify() {
        // Create a new state with a different property (e.g., username)
        SignupState newState = new SignupState();
        newState.setUsername("New Username");

        // Set the new state
        signupViewModel.setState(newState);
        signupViewModel.firePropertyChanged();

        // Verify that the PropertyChangeListener was notified
        assertEquals(1, propertyChangeListener.getPropertyChangeCount());

        // Verify that the new state is the expected state
        assertEquals(newState.getUsername(), signupViewModel.getState().getUsername());
    }

    @Test
    public void testFirePropertyChanged() {
        // Call the firePropertyChanged method
        SignupState newState = new SignupState();
        newState.setUsername("New Username");

        // Set the new state
        signupViewModel.setState(newState);

        // Call the firePropertyChanged method
        signupViewModel.firePropertyChanged();

        // Verify that the PropertyChangeListener was notified
        assertEquals(1, propertyChangeListener.getPropertyChangeCount());

        // Verify that the new state is the expected state
        assertEquals(newState, propertyChangeListener.getNewState());
    }

    // Helper class for testing PropertyChangeListener
    private static class TestPropertyChangeListener implements PropertyChangeListener {
        private int propertyChangeCount = 0;
        private SignupState newState;

        @Override
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            propertyChangeCount++;
            newState = (SignupState) evt.getNewValue();
        }

        public int getPropertyChangeCount() {
            return propertyChangeCount;
        }

        public SignupState getNewState() {
            return newState;
        }
    }
}
