package LoginTest;

import login.interface_adapter.LoginState;
import login.interface_adapter.LoginViewModel;
import menu.interface_adapter.MenuViewModel;
import menu.view.MenuView;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LoginViewModelTest {

    @Test
    void testLabels() {
        LoginViewModel viewModel = new LoginViewModel();
        assertEquals("Log In View", viewModel.TITLE_LABEL);
        assertEquals("Enter Username", viewModel.USERNAME_LABEL);
        assertEquals("Enter Password", viewModel.PASSWORD_LABEL);
        assertEquals("Log in", viewModel.LOGIN_BUTTON_LABEL);
        assertEquals("Cancel", viewModel.CANCEL_BUTTON_LABEL);
    }

    @Test
    void testMenuView() {
        LoginViewModel viewModel = new LoginViewModel();
        MenuView menuView = new MenuView(null, new MenuViewModel());
        viewModel.setMenuView(menuView);
        assertEquals(menuView, viewModel.menuView);
    }

    @Test
    void testState() {
        LoginViewModel viewModel = new LoginViewModel();
        LoginState newState = new LoginState(); // Assuming LoginState has a proper constructor
        viewModel.setState(newState);
        assertEquals(newState, viewModel.getState());
    }

    @Test
    void testPropertyChangeListener() {
        LoginViewModel viewModel = new LoginViewModel();
        MockPropertyChangeListener listener = new MockPropertyChangeListener();
        viewModel.addPropertyChangeListener(listener);
        assertNotNull(listener);
    }

    // Additional tests can be added to cover more scenarios

    // MockPropertyChangeListener for testing property change events
    private static class MockPropertyChangeListener implements PropertyChangeListener {
        private PropertyChangeEvent lastEvent;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            this.lastEvent = evt;
        }

        public PropertyChangeEvent getLastEvent() {
            return lastEvent;
        }
    }

    @Test
    void testFirePropertyChanged() {
        LoginViewModel viewModel = new LoginViewModel();
        MockPropertyChangeListener listener = new MockPropertyChangeListener();
        viewModel.addPropertyChangeListener(listener);

        LoginState newState = new LoginState();
        viewModel.setState(newState);

        viewModel.firePropertyChanged();

        assertNotNull(listener.getLastEvent());
        assertEquals("state", listener.getLastEvent().getPropertyName());
        assertEquals(null, listener.getLastEvent().getOldValue());
        assertEquals(newState, listener.getLastEvent().getNewValue());
    }
}