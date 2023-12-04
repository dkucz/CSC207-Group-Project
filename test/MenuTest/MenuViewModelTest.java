package MenuTest;

import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static org.junit.jupiter.api.Assertions.*;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.MenuState;
public class MenuViewModelTest {

    @Test
    public void testInitialState() {
        MenuViewModel viewModel = new MenuViewModel();

        assertEquals("Menu View", viewModel.TITLE_LABEL);
        assertEquals("Friends", viewModel.FRIENDS_BUTTON_LABEL);
        assertEquals("Create Event", viewModel.CREATE_EVENT_BUTTON_LABEL);
        assertEquals("Modify Event", viewModel.MODIFY_EVENT_BUTTON_LABEL);
        assertEquals("Refresh", viewModel.REFRESH_BUTTON_LABEL);
        assertEquals("Signout", viewModel.SIGNOUT_BUTTON_LABEL);

        assertNotNull(viewModel.getState());
    }

    @Test
    public void testSetState() {
        MenuViewModel viewModel = new MenuViewModel();
        MenuState newState = new MenuState();

        viewModel.setState(newState);

        assertEquals(newState, viewModel.getState());
    }



    // A simple PropertyChangeListener implementation for testing
    private static class TestPropertyChangeListener implements PropertyChangeListener {
        private boolean propertyChangeInvoked = false;
        private PropertyChangeEvent propertyChangeEvent;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            propertyChangeInvoked = true;
            propertyChangeEvent = evt;
        }
    }
}