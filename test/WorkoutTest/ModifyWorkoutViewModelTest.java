package WorkoutTest;

import entity.User;
import org.junit.jupiter.api.Test;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutState;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.interface_adapter.SearchWorkout.WorkoutState;
import workout.interface_adapter.SearchWorkout.WorkoutViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

public class ModifyWorkoutViewModelTest {

    @Test
    void testInitialState() {
        ModifyWorkoutViewModel viewModel = new ModifyWorkoutViewModel();

        assertNotNull(viewModel.getState());
        assertNull(viewModel.currentUser);
    }

    @Test
    void testSetState() {
        ModifyWorkoutViewModel viewModel = new ModifyWorkoutViewModel();

        ModifyWorkoutState newState = new ModifyWorkoutState();

        viewModel.setState(newState);

        assertEquals(newState, viewModel.getState());
    }

    @Test
    void testPropertyChangeSupport() {
        ModifyWorkoutViewModel viewModel = new ModifyWorkoutViewModel();

        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                assertEquals("state", evt.getPropertyName());
                assertNull(evt.getOldValue());
                assertNotNull(evt.getNewValue());
            }
        };

        viewModel.addPropertyChangeListener(listener);
        viewModel.firePropertyChanged();
    }
}

