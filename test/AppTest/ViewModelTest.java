package AppTest;

import app.ViewModel;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class ViewModelTest {

    @Test
    public void testGetViewName() {
        // Arrange
        String expectedViewName = "TestView";
        ViewModel viewModel = new TestViewModel(expectedViewName);

        // Act
        String actualViewName = viewModel.getViewName();

        // Assert
        assertEquals(expectedViewName, actualViewName);
    }

    @Test
    public void testAddPropertyChangeListener() {
        // Arrange
        ViewModel viewModel = new TestViewModel("TestView");
        PropertyChangeListener listener = mock(PropertyChangeListener.class);

        // Act
        viewModel.addPropertyChangeListener(listener);

        // Assert
        // Verify that the listener was added
        assertTrue(((TestViewModel) viewModel).containsListener(listener));
    }

    @Test
    public void testFirePropertyChanged() {
        // Arrange
        ViewModel viewModel = new TestViewModel("TestView");
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(listener);

        // Act
        viewModel.firePropertyChanged();

        // Assert
        // Verify that the listener's propertyChanged method was called
        verify(listener).propertyChange(null);
    }

    // Helper class for testing
    private static class TestViewModel extends ViewModel {
        private PropertyChangeListener listener;

        public TestViewModel(String viewName) {
            super(viewName);
        }

        @Override
        public void firePropertyChanged() {
            if (listener != null) {
                listener.propertyChange(null);
            }
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
            this.listener = listener;
        }

        public boolean containsListener(PropertyChangeListener listener) {
            return this.listener == listener;
        }
    }
}
