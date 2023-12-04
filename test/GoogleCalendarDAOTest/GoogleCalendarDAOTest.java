package GoogleCalendarDAOTest;

import data_access.GoogleCalendarDAO;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleCalendarDAOTest {
    @Test
    public void testGoogleCalendarDAO() throws GeneralSecurityException, IOException, InterruptedException {
        GoogleCalendarDAO dao = new GoogleCalendarDAO();
//
//        dao.getCalendarList();
//        Thread.sleep(10000); // Pause for 1 second
//
//        dao.getEventsForToday("Wakacje");
//        Thread.sleep(10000); // Pause for 1 second
//
//        dao.createCalendar();
//        Thread.sleep(10000); // Pause for 1 second
//
//        dao.findIdByName("Fitness Tracker");
//        Thread.sleep(10000); // Pause for 1 second
//
//        dao.createEvent(dao.findIdByName("Wakacje"), "test", "test", "2023-12-03T10:00:00-05:00", "2023-12-03T10:00:00-05:00");
//        Thread.sleep(10000); // Pause for 1 second
//
//        dao.createAccessControlRule("kolivcao@gmail.com");
//        Thread.sleep(10000); // Pause for 1 second
//
//        dao.hasCalendar();
    }
}
