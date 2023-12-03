package app;

import Workout.interface_adapter.WorkoutController;
import Workout.interface_adapter.WorkoutViewModel;
import Workout.view.WorkoutView;
import data_access.ExercisesDAO;
import data_access.FacadeDAO;
import data_access.FirestoreDAO;
import data_access.GoogleCalendarDAO;
import login.interface_adapter.LoginViewModel;
import login.view.LoginView;
import login.view.ViewManager;
import menu.app.SignoutUseCaseFactory;
import menu.interface_adapter.MenuViewModel;
import menu.view.MenuView;
import signup.interface_adapter.SignupViewModel;
import signup.view.SignupView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class Main {
    public static void main(String[] args) throws IOException, GeneralSecurityException {
        // Load the login screen
        JFrame application = new JFrame("Fitness Tracker");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();
        WorkoutViewModel workoutViewModel = new WorkoutViewModel();

        GoogleCalendarDAO googleDAO = new GoogleCalendarDAO();
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        ExercisesDAO exercisesDAO = new ExercisesDAO();

        FacadeDAO appDAO = new FacadeDAO(firestoreDAO, googleDAO, exercisesDAO);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel,
                loginViewModel, signupViewModel, appDAO);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel,
                loginViewModel, signupViewModel, menuViewModel, appDAO);
        views.add(loginView, loginView.viewName);

        MenuView menuView = SignoutUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, menuViewModel, appDAO);
        views.add(menuView, menuView.viewname);
        loginView.getLoginViewModel().setMenuView(menuView);

        WorkoutView workoutView = WorkoutUseCaseFactory.create(viewManagerModel, workoutViewModel, menuViewModel, appDAO);
        views.add(workoutView, workoutView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();


        application.pack();
        application.setVisible(true);
    }
}
