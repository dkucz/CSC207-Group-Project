package MenuTest;

import app.ViewManagerModel;
import login.interface_adapter.LoginViewModel;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.SignoutController;
import menu.interface_adapter.SignoutPresenter;
import menu.use_case.SignoutInputBoundary;
import menu.use_case.SignoutInteractor;
import org.junit.Test;

public class SignoutControllerTest {

    @Test
    public void TestCreation(){
        LoginViewModel loginViewModel = new LoginViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignoutPresenter signoutPresenter = new SignoutPresenter(loginViewModel, menuViewModel, viewManagerModel);
        SignoutInputBoundary signoutInteractor = new SignoutInteractor(signoutPresenter);
        SignoutController signoutController = new SignoutController(signoutInteractor);

    }

    @Test
    public void TestExecute(){
        LoginViewModel loginViewModel = new LoginViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignoutPresenter signoutPresenter = new SignoutPresenter(loginViewModel, menuViewModel, viewManagerModel);
        SignoutInputBoundary signoutInteractor = new SignoutInteractor(signoutPresenter);
        SignoutController signoutController = new SignoutController(signoutInteractor);
        signoutController.execute();

    }
}
