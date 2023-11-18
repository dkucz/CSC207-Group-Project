package app;

import data_access.GoogleCalendarDAO;
import entity.UserFactory;
import login.interface_adapter.LoginViewModel;
import login.view.LoginView;
import login.view.ViewManager;
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
        JFrame application = new JFrame("Login");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();

        UserFactory userFactory = new UserFactory();
        GoogleCalendarDAO appDAO = new GoogleCalendarDAO("./accounts.csv", userFactory);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel,
                loginViewModel, signupViewModel, appDAO);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel,
                loginViewModel, signupViewModel, menuViewModel, appDAO);
        views.add(loginView, loginView.viewName);

        MenuView menuView = new MenuView(menuViewModel);
        views.add(menuView, menuView.viewname);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();


        application.pack();
        application.setVisible(true);
    }
}
