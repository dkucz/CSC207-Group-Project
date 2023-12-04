package WorkoutTest;

import data_access.GoogleCalendarDAO;
import org.junit.Before;
import org.junit.Test;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutPresenter;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputData;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutState;

import java.time.DateTimeException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ModifyWorkoutPresenterTest {

    private ModifyWorkoutPresenter presenter;
    private ModifyWorkoutViewModel mockViewModel;

    @Before
    public void setUp() {
        mockViewModel = mock(ModifyWorkoutViewModel.class);
        presenter = new ModifyWorkoutPresenter(mockViewModel);
    }

    @Test
    public void testPrepareSuccessView() throws Exception {
        // Mock data for outputData
        ModifyWorkoutOutputData outputData = new ModifyWorkoutOutputData(new ArrayList<>(), 1, 10);

        // Mock behavior for GoogleCalendarDAO methods
        GoogleCalendarDAO mockGoogleCalendarDAO = mock(GoogleCalendarDAO.class);
        when(mockGoogleCalendarDAO.findIdByName(anyString())).thenReturn("mockGoogleID");
        doNothing().when(mockGoogleCalendarDAO).createEvent(anyString(), anyString(), anyString(), anyString(), anyString());


        // Execute the method
        presenter.prepareSuccessView(outputData);

        // Verify that the expected methods were called on GoogleCalendarDAO and mockViewModel
        verify(mockGoogleCalendarDAO).findIdByName("Fitness Tracker");
        verify(mockGoogleCalendarDAO).createEvent("mockGoogleID", "Exercise1", "Exercise1\n", "2022-01-10T15:00:00", "2022-01-10T16:00:00");
        verify(mockViewModel).setState(any(ModifyWorkoutState.class));
        verify(mockViewModel).firePropertyChanged();
    }

    @Test(expected = DateTimeException.class)
    public void testPrepareFailView() {
        // Execute the method with a failure message
        presenter.prepareFailView("Invalid operation");

        // Verify that a DateTimeException is thrown
    }

    // Add more test cases to cover other scenarios and edge cases

}
