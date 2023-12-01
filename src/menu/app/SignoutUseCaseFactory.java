package menu.app;

import app.ViewManagerModel;
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

    public class SignoutUseCaseFactory {

        public static MenuView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                                       SignupViewModel signupViewModel, MenuViewModel menuViewModel, LoginUserDataAccessInterface loginDAO)
        {

            SignoutController signoutController = createSignoutUseCase(viewManagerModel,
                    signupViewModel, loginViewModel, menuViewModel);

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

