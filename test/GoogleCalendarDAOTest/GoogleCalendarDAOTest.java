package GoogleCalendarDAOTest;

import data_access.GoogleCalendarDAO;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleCalendarDAOTest {
    @Test
    public void testGoogleCalendarDAO() throws GeneralSecurityException, IOException, InterruptedException {
        GoogleCalendarDAO dao = new GoogleCalendarDAO();
        // Pause for a moment before making the next API call
        Thread.sleep(10000);  // Sleep for 1 second (adjust as needed)

        // Make the API call to get the calendar list
        dao.getCalendarList();

        // Pause again before the next API call
        Thread.sleep(10000);

        // Make the API call to get events for today
        dao.getEventsForToday("Wakacje");

        // Pause again before the next API call
        Thread.sleep(10000);

        // Make the API call to create a calendar
        dao.createCalendar();

        // Pause again before the next API call
        Thread.sleep(10000);

        // Make the API call to create an event
        dao.createEvent(
                dao.findIdByName("Wakacje"),
                "test",
                "test",
                "2023-12-03T10:00:00-05:00",
                "2023-12-03T10:00:00-05:00"
        );

        // Pause again before the next API call
        Thread.sleep(10000);

        // Make the API call to create an access control rule
        dao.createAccessControlRule("kolivcao@gmail.com");

        // Pause again before the next API call
        Thread.sleep(10000);

        // Make the API call to check if the user has a calendar
        dao.hasCalendar();
    }
}
