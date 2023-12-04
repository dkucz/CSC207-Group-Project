package GoogleCalendarDAOTest;

import data_access.GoogleCalendarDAO;
import org.junit.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class GoogleCalendarDAOTest {
    @Test
    public void testGoogleCalendarDAO() throws GeneralSecurityException, IOException {
        GoogleCalendarDAO dao = new GoogleCalendarDAO();
        dao.getCalendarList();
        dao.getEventsForToday("Wakacje");
        dao.createCalendar();
        dao.createCalendar("test");
        dao.deleteCalendar("test");
        dao.deleteCalendar("Fitness Tracker");
        dao.findIdByName("Fitness Tracker");
        dao.findIdByName("Wakacje");
        dao.createEvent(dao.findIdByName("Wakacje"), "test", "test", "2023-12-03T10:00:00-05:00", "2023-12-03T10:00:00-05:00");
        dao.hasCalendar();
        dao.createAccessControlRule("kolivcao@gmail.com");
        dao.hasCalendar();
    }
}
