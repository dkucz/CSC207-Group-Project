package MenuTest;

import app.ViewManagerModel;
import login.interface_adapter.LoginViewModel;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.SignoutPresenter;
import org.junit.Test;

public class SignoutPresenterTest {
    @Test
    public void TestCreation() {
        LoginViewModel loginViewModel = new LoginViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignoutPresenter signoutPresenter = new SignoutPresenter(loginViewModel, menuViewModel, viewManagerModel);

    }

    @Test
    public void TestPrepareSuccessView(){
        LoginViewModel loginViewModel = new LoginViewModel();
        MenuViewModel menuViewModel = new MenuViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SignoutPresenter signoutPresenter = new SignoutPresenter(loginViewModel, menuViewModel, viewManagerModel);
        signoutPresenter.prepareSuccessView();
        assert (viewManagerModel.getActiveView().equals(loginViewModel.getViewName()));
    }
}
