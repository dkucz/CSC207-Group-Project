package app;

import Workout.view.WorkoutView;
import data_access.GoogleCalendarDAO;
import login.interface_adapter.LoginViewModel;
import signup.interface_adapter.SignupViewModel;

public class WorkoutUseCaseFactory {
    public static WorkoutView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, GoogleCalendarDAO appDAO) {
        return null;
    }
}
