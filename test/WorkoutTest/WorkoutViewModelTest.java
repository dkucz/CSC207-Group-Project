package WorkoutTest;

import entity.User;
import org.junit.jupiter.api.Test;
import workout.interface_adapter.SearchWorkout.WorkoutState;
import workout.interface_adapter.SearchWorkout.WorkoutViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

public class WorkoutViewModelTest {

    @Test
    void testInitialState() {
        WorkoutViewModel viewModel = new WorkoutViewModel();

        assertNotNull(viewModel.getState());
        assertTrue(viewModel.getState().getExercises().isEmpty());
        assertNull(viewModel.currentUser);
    }

    @Test
    void testSetState() {
        WorkoutViewModel viewModel = new WorkoutViewModel();

        WorkoutState newState = new WorkoutState();
        newState.setExercises("New Exercises");

        viewModel.setState(newState);

        assertEquals(newState, viewModel.getState());
        assertEquals("New Exercises", viewModel.getState().getExercises());
    }

    @Test
    void testSetCurrentUser() {
        WorkoutViewModel viewModel = new WorkoutViewModel();

        User newUser = new User();
        viewModel.setCurrentUser(newUser);

        assertEquals(newUser, viewModel.currentUser);
    }

    @Test
    void testPropertyChangeSupport() {
        WorkoutViewModel viewModel = new WorkoutViewModel();

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

