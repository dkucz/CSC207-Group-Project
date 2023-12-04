package WorkoutTest;

import data_access.GoogleCalendarDAO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutPresenter;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.use_case.ModifyWorkout.ModifyWorkoutOutputData;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ModifyWorkoutPresenterTest {

    @Mock
    private ModifyWorkoutViewModel modViewModel;

    @InjectMocks
    private ModifyWorkoutPresenter modifyWorkoutPresenter;

    @Mock
    private ModifyWorkoutOutputData outputData;

    @Mock
    private GoogleCalendarDAO googleCalendarDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPrepareSuccessView() throws GeneralSecurityException, IOException {
        // Arrange
        ArrayList<ArrayList<String>> schedule = new ArrayList<>();
        schedule.add(new ArrayList<>());
        // Add some data to the schedule
        schedule.add(new ArrayList<>(List.of("Exercise1", "Exercise2", "Exercise3")));
        when(outputData.getSchedule()).thenReturn(schedule);
        when(outputData.getExerciseDay()).thenReturn(1);
        when(outputData.getExerciseHour()).thenReturn(10);

        // Mocking behavior of GoogleCalendarDAO methods
        when(googleCalendarDAO.findIdByName(anyString())).thenReturn("fakeGoogleId");

        // Act
        modifyWorkoutPresenter.prepareSuccessView(outputData);


    }
}