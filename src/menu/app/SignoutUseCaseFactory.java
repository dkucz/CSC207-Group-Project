package menu.app;

import Workout.interface_adapter.WorkoutController;
import Workout.interface_adapter.WorkoutViewModel;
import Workout.view.WorkoutView;
import app.ViewManagerModel;
import app.WorkoutUseCaseFactory;
import data_access.FacadeDAO;
import login.data_access.LoginUserDataAccessInterface;
import login.interface_adapter.LoginController;
import login.interface_adapter.LoginPresenter;
import login.interface_adapter.LoginViewModel;
import login.use_case.LoginInputBoundary;
import login.use_case.LoginInteractor;
import login.use_case.LoginOutputBoundary;
import login.view.LoginView;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.SignoutController;
import menu.interface_adapter.SignoutPresenter;
import menu.use_case.SignoutInteractor;
import menu.view.MenuView;
import signup.interface_adapter.SignupViewModel;


import login.data_access.LoginUserDataAccessInterface;
import login.interface_adapter.LoginController;
import login.interface_adapter.LoginPresenter;
import login.interface_adapter.LoginViewModel;
import login.use_case.LoginInputBoundary;
import login.use_case.LoginInteractor;
import login.use_case.LoginOutputBoundary;
import login.view.LoginView;
import menu.interface_adapter.MenuViewModel;
import signup.interface_adapter.SignupViewModel;

import java.io.IOException;
import java.security.GeneralSecurityException;

import static app.WorkoutUseCaseFactory.createWorkoutUseCase;

public class SignoutUseCaseFactory {

        public static MenuView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                                      SignupViewModel signupViewModel, MenuViewModel menuViewModel,
                                      WorkoutViewModel workoutViewModel, FacadeDAO appDAO) throws GeneralSecurityException, IOException {

            SignoutController signoutController = createSignoutUseCase(viewManagerModel,
                    signupViewModel, loginViewModel, menuViewModel);

            WorkoutView workoutView = WorkoutUseCaseFactory.create(viewManagerModel,
                    workoutViewModel, menuViewModel, appDAO);

            return new MenuView(signoutController, menuViewModel);
        }
        private static SignoutController createSignoutUseCase(ViewManagerModel viewManagerModel,
                                                            SignupViewModel signupViewModel,
                                                            LoginViewModel loginViewModel,
                                                            MenuViewModel menuViewModel) {

            SignoutPresenter signoutPresenter = new SignoutPresenter(loginViewModel, menuViewModel, viewManagerModel);

            SignoutInteractor signoutInteractor = new SignoutInteractor(signoutPresenter);

            return new SignoutController(signoutInteractor);
        }





    }

