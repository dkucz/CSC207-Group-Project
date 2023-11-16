package app;

import login.interface_adapter.LoginViewModel;
import login.view.LoginView;
import login.view.ViewManager;
import signup.interface_adapter.SignupViewModel;
import signup.view.SignupView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
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

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel);
        views.add(signupView, signupView.viewName);

        LoginView loginView = new LoginView(loginViewModel);
        views.add(loginView, loginView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


    }
}
