package MenuTest;

import data_access.ExercisesDAO;
import data_access.FacadeDAO;
import data_access.FirestoreDAO;
import data_access.GoogleCalendarDAO;
import entity.User;
import app.ViewManagerModel;
import login.interface_adapter.LoginViewModel;
import login.view.ViewManager;
import menu.app.SignoutUseCaseFactory;
import menu.interface_adapter.MenuViewModel;
import menu.view.MenuView;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import signup.interface_adapter.SignupController;
import signup.interface_adapter.SignupViewModel;
import signup.use_case.SignupInputBoundary;
import signup.use_case.SignupInputData;
import static org.junit.jupiter.api.Assertions.*;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;
public class MenuViewTest {


    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException, IOException, GeneralSecurityException {

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();

        GoogleCalendarDAO googleDAO = new GoogleCalendarDAO();
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        ExercisesDAO exercisesDAO = new ExercisesDAO();

        FacadeDAO appDAO = new FacadeDAO(firestoreDAO, googleDAO, exercisesDAO);

        MenuView menuView = SignoutUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, menuViewModel, appDAO);
        views.add(menuView, menuView.viewname);

    }


    @Test
    void TestCurrentUser() throws GeneralSecurityException, IOException {

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();

        GoogleCalendarDAO googleDAO = new GoogleCalendarDAO();
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        ExercisesDAO exercisesDAO = new ExercisesDAO();

        FacadeDAO appDAO = new FacadeDAO(firestoreDAO, googleDAO, exercisesDAO);

        MenuView menuView = SignoutUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, menuViewModel, appDAO);
        views.add(menuView, menuView.viewname);

        User u = new User();
        menuView.setUser(u);

        assert menuView.getCurrentUser() == u;


    }

    void testFriendsButton() throws IOException, GeneralSecurityException {
        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();

        GoogleCalendarDAO googleDAO = new GoogleCalendarDAO();
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        ExercisesDAO exercisesDAO = new ExercisesDAO();

        FacadeDAO appDAO = new FacadeDAO(firestoreDAO, googleDAO, exercisesDAO);

        MenuView menuView = SignoutUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, menuViewModel, appDAO);
        views.add(menuView, menuView.viewname);

        try {
            // Set a user (replace with your user creation logic if needed)
            User testUser = new User(/* provide user details */);
            menuView.setUser(testUser);

            // Simulate clicking the "Friend" button
            Field friendsField = MenuView.class.getDeclaredField("friends");
            friendsField.setAccessible(true);  // Set the field to be accessible
            JButton friendsButton = (JButton) friendsField.get(menuView);  // Get the value of the field

            // Simulate clicking the "Friend" button
            friendsButton.doClick();

            // If the test reaches here without throwing an exception, it's successful
            assertTrue(true, "Friend button worked without exceptions");
        } catch (Exception e) {
            // If an exception occurs, fail the test and print the stack trace
            fail("Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void testCreateEventButton() throws IOException, GeneralSecurityException {
        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();

        GoogleCalendarDAO googleDAO = new GoogleCalendarDAO();
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        ExercisesDAO exercisesDAO = new ExercisesDAO();

        FacadeDAO appDAO = new FacadeDAO(firestoreDAO, googleDAO, exercisesDAO);

        MenuView menuView = SignoutUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, menuViewModel, appDAO);
        views.add(menuView, menuView.viewname);

        try {
            User testUser = new User(/* provide user details */);
            menuView.setUser(testUser);

            // Use reflection to access the private field
            Field createEventField = MenuView.class.getDeclaredField("createEvent");
            createEventField.setAccessible(true);  // Set the field to be accessible
            JButton createEventButton = (JButton) createEventField.get(menuView);  // Get the value of the field

            // Simulate clicking the "CreateEvent" button
            createEventButton.doClick();

            // If the test reaches here without throwing an exception, it's successful
            assertTrue(true, "CreateEvent button worked without exceptions");
        } catch (Exception e) {
            // If an exception occurs, fail the test and print the stack trace
            fail("Exception thrown: " + e.getMessage());
            e.printStackTrace();
        }
        }
    }



