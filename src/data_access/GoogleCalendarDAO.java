package data_access;

import com.google.api.services.calendar.model.*;
import entity.UserFactory;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import entity.User;
import friend.use_case.add_friend.ShareCalendarDAOInterface;
import login.data_access.LoginUserDataAccessInterface;
import signup.data_access.SignupUserDataAccessInterface;

import javax.swing.*;
import java.io.*;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class GoogleCalendarDAO implements ShareCalendarDAOInterface {
    private final String fitnessCalendarID = "Fitness Tracker";

    public GoogleCalendarDAO() {}
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(CalendarScopes.CALENDAR);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = GoogleCalendarDAO.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        //returns an authorized Credential object.
        return credential;
    }

    public DefaultListModel<String> getCalendarList() throws GeneralSecurityException, IOException {
        DefaultListModel<String> eventListModel = new DefaultListModel<>();
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credentials = getCredentials(HTTP_TRANSPORT);
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("applicationName").build();

        // Iterate through entries in calendar list
        String pageToken = null;
        do {
            CalendarList calendarList = service.calendarList().list().setPageToken(pageToken).execute();
            List<CalendarListEntry> items = calendarList.getItems();

            for (CalendarListEntry calendarListEntry : items) {
                eventListModel.addElement(calendarListEntry.getSummary());
            }
            pageToken = calendarList.getNextPageToken();
        } while (pageToken != null);
        return eventListModel;
    }
    public DefaultListModel<String> getEventsForToday(String calendarName) throws GeneralSecurityException, IOException {
        DefaultListModel<String> eventsForToday = new DefaultListModel<>();
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credentials = getCredentials(HTTP_TRANSPORT);
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("applicationName").build();

        // Get the calendar ID for the specified calendar name
        String calendarId = getCalendarIdByName(service, calendarName);
        if (calendarId == null){
            return null;
        }

        // Define the start and end times for today
        DateTime startOfDay = getStartOfDay();
        DateTime endOfDay = getEndOfDay();

        // Query for events for today
        Events events = service.events().list(calendarId)
                .setTimeMin(startOfDay)
                .setTimeMax(endOfDay)
                .execute();

        // Iterate through events and add them to the list
        List<Event> items = events.getItems();
        for (Event event : items) {
            Date startDate = new Date(event.getStart().getDateTime().getValue());
            String formattedTime = getFormattedTime(startDate);
            String eventDescription = formattedTime + ": " + event.getSummary();
            eventsForToday.addElement(eventDescription);
        }

        return eventsForToday;
    }

    private String getFormattedTime(Date date) {
        return timeFormatter.format(date);
    }
    // Helper method to get the calendar ID by name
    private String getCalendarIdByName(Calendar service, String calendarName) throws IOException {
        CalendarList calendarList = service.calendarList().list().execute();
        List<CalendarListEntry> items = calendarList.getItems();

        for (CalendarListEntry calendarListEntry : items) {
            if (calendarListEntry.getSummary().equals(calendarName)) {
                return calendarListEntry.getId();
            }
        }

        // Return null if the calendar with the specified name is not found
        return null;
    }
    private SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

    // Helper method to get the start of the day in DateTime format
    private DateTime getStartOfDay() {
        LocalDate today = LocalDate.now();
        return new DateTime(today.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }

    // Helper method to get the end of the day in DateTime format
    private DateTime getEndOfDay() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return new DateTime(tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
    public void createCalendar() throws GeneralSecurityException, IOException
    {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credentials = getCredentials(HTTP_TRANSPORT);
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("applicationName").build();

        // Create a new calendar
        com.google.api.services.calendar.model.Calendar calendar = new com.google.api.services.calendar.model.Calendar();
        calendar.setSummary("Fitness Tracker");
        calendar.setTimeZone("America/Los_Angeles");

        // Insert the new calendar
        com.google.api.services.calendar.model.Calendar createdCalendar = service.calendars().insert(calendar).execute();

        System.out.println(createdCalendar.getId());
    }

    public String findIdByName(String calendarName) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credentials = getCredentials(HTTP_TRANSPORT);
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("applicationName").build();

        try {
            Calendar.CalendarList list = service.calendarList();
            com.google.api.services.calendar.model.CalendarList calendarList = list.list().execute();

            for (CalendarListEntry entry : calendarList.getItems()) {
                if (entry.getSummary().equals(calendarName)) {
                    return entry.getId();
                }
            }

            System.out.println("Calendar not found.");
        } catch (IOException e) {
            System.err.println("An error occurred while searching for the calendar by name.");
        }
        return null;
    }
    
    public void createStoredCredentials() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        getCredentials(HTTP_TRANSPORT);
    }

    public void createEvent(String googleCalendarId, String eventName, String eventDescription, String startDate,
                            String endDate) throws IOException, GeneralSecurityException {
        //appDAO.createEvent("77a9a99e76145bf103054637889ea83e78dd424d9395229f707a46de5550ccac@group.calendar.google.com", "Fuck", "my life", "2023-11-21T10:00:00", "2023-11-21T11:00:00");
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credentials = getCredentials(HTTP_TRANSPORT);
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("applicationName").build();

        Event event = new Event()
                .setSummary(eventName)
                .setDescription(eventDescription);

        DateTime startDateTime = new DateTime(startDate);
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("America/New_York");
        event.setStart(start);

        DateTime endDateTime = new DateTime(endDate);
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("America/New_York");
        event.setEnd(end);

        System.out.printf("Event created: %s\n", event.getHtmlLink());

        service.events().insert(googleCalendarId, event).execute();

    }

    public void createAccessControlRule(String gmail) throws GeneralSecurityException, IOException {

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credentials = getCredentials(HTTP_TRANSPORT);
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("applicationName").build();

        AclRule rule = new AclRule();
        AclRule.Scope scope = new AclRule.Scope();
        scope.setType("user").setValue(gmail);
        rule.setScope(scope).setRole("writer");

        String calendarID = findIdByName(fitnessCalendarID);

        System.out.println(calendarID);
        System.out.println(gmail);

        AclRule createdRule = service.acl().insert(calendarID, rule).execute();
        System.out.println(createdRule.getId());
    }

    public boolean hasCalendar() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credentials = getCredentials(HTTP_TRANSPORT);
        Calendar calendarService = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
                .setApplicationName("applicationName").build();
        CalendarList calendarList = calendarService.calendarList().list().execute();

        for (CalendarListEntry calendarEntry : calendarList.getItems()) {
            String calendarSummary = calendarEntry.getSummary();

            if ("Fitness Tracker".equals(calendarSummary)) {
                return true;
            }
        }
        return false;
    }
}
