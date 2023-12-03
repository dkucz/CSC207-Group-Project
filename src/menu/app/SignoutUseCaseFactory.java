package menu.app;

import app.ViewManagerModel;
import login.data_access.LoginUserDataAccessInterface;
import login.interface_adapter.LoginViewModel;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.SignoutController;
import menu.interface_adapter.SignoutPresenter;
import menu.use_case.SignoutInteractor;
import menu.view.MenuView;
import signup.interface_adapter.SignupViewModel;


import java.io.IOException;
import java.security.GeneralSecurityException;

public class SignoutUseCaseFactory {

        public static MenuView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel,
                                      SignupViewModel signupViewModel, MenuViewModel menuViewModel,
                                      LoginUserDataAccessInterface appDAO) throws GeneralSecurityException, IOException {

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

