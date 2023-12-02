package FacadeDAOTest;

import data_access.FacadeDAO;
import data_access.FirestoreDAO;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data_access.ExercisesDAO;
import data_access.GoogleCalendarDAO;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class FacadeDAOTest {
    private FacadeDAO facadeDAO;
    private FirestoreDAO mockFirestoreDAO;
    private GoogleCalendarDAO mockGoogleCalendarDAO;
    private ExercisesDAO mockExercisesDAO;

    @BeforeEach
    void setUp() {
        // Create a mock for FirestoreDAO
        mockFirestoreDAO = mock(FirestoreDAO.class);

        // Initialize the FacadeDAO with the mock
        mockGoogleCalendarDAO = mock(GoogleCalendarDAO.class);
        mockExercisesDAO = mock(ExercisesDAO.class);

        facadeDAO = new FacadeDAO(mockFirestoreDAO, mockGoogleCalendarDAO, mockExercisesDAO);
    }

    @Test
    void testGet() throws ExecutionException, InterruptedException {
        // Assuming you have a valid username for testing
        String testUsername = "testUser";

        // Set up the mock behavior
        when(mockFirestoreDAO.getUserFromName(testUsername)).
                thenReturn(new User(testUsername, "testPass", "test@gmail.com"));

        // Execute the method under test
        User user = facadeDAO.get(testUsername);

        // Verify that the method was called
        verify(mockFirestoreDAO).getUserFromName(testUsername);
    }

    @Test
    void testCreateStoredCredentials() throws GeneralSecurityException, IOException {
        // Execute the method under test
        assertDoesNotThrow(() -> facadeDAO.createStoredCredentials());

        // Verify that the method was called on GoogleCalendarDAO
        verify(mockGoogleCalendarDAO).createStoredCredentials();
    }

    @Test
    void testExistsByName() throws ExecutionException, InterruptedException {
        // Assuming you have a valid identifier for testing
        String testIdentifier = "testIdentifier";

        // Set up the mock behavior
        when(mockFirestoreDAO.existsByName(testIdentifier)).thenReturn(true);

        // Execute the method under test
        boolean exists = facadeDAO.existsByName(testIdentifier);

        // Verify that the method was called
        verify(mockFirestoreDAO).existsByName(testIdentifier);
    }

    @Test
    void testSave() throws ExecutionException, InterruptedException {
        // Assuming you have a valid User object for testing
        User testUser = new User("testUsername", "testPassword", "test@gmail.com");

        // Execute the method under test
        assertDoesNotThrow(() -> facadeDAO.save(testUser));

        // Verify that the method was called
        verify(mockFirestoreDAO).save(testUser);
    }
}
