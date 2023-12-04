package WorkoutTest;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.junit.jupiter.api.Test;
import workout.view.WorkoutViewManagerModel;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutViewManagerModelTest {

    @Test
    void testInitialState() {
        WorkoutViewManagerModel model = new WorkoutViewManagerModel();

        assertNull(model.getActiveView());
    }

    @Test
    void testSetAndGetActiveView() {
        WorkoutViewManagerModel model = new WorkoutViewManagerModel();

        // Set the active view
        model.setActiveView("TestView");

        // Check if the active view is set correctly
        assertEquals("TestView", model.getActiveView());
    }

    @Test
    void testPropertyChangeSupport() {
        WorkoutViewManagerModel model = new WorkoutViewManagerModel();

        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("view", evt.getPropertyName());
                assertNull(evt.getOldValue()); // No previous state

            }
        };

        model.addPropertyChangeListener(listener);

        model.firePropertyChanged();
    }

    @Test
    void testPropertyChangeWithActiveView() {
        WorkoutViewManagerModel model = new WorkoutViewManagerModel();

        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("view", evt.getPropertyName());
                assertNull(evt.getOldValue()); // No previous state
                assertNotNull(evt.getNewValue()); // New state should not be null
                assertEquals("TestView", evt.getNewValue()); // New state should match the active view
            }
        };

        model.addPropertyChangeListener(listener);

        // Set the active view and trigger a property change
        model.setActiveView("TestView");
        model.firePropertyChanged();
    }
}