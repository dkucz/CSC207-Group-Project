package LoginTest;

import data_access.InMemoryUserDAO;
import entity.User;
import login.data_access.LoginUserDataAccessInterface;
import login.interface_adapter.LoginPresenter;
import login.use_case.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class LoginInteractorTest {

    @Test
    public void SuccessTest() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        LoginUserDataAccessInterface userRepository = new InMemoryUserDAO();
        User user = new User("test", "pass", "gmail");
        userRepository.save(user);
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) throws ExecutionException, InterruptedException {
                Assertions.assertEquals("test", userRepository.get("test").getUsername());
                Assertions.assertTrue(userRepository.existsByName("test"));
            }

            @Override
            public void prepareFailView(String error) {
                Assertions.fail("Unexpected failure");
            }

            @Override
            public void prepareSuccessView() {}
        };

        LoginInputData login = new LoginInputData("test", "pass");
        LoginInputBoundary loginInteractor = new LoginInteractor(userRepository, presenter);
        loginInteractor.execute(login);
    }

    @Test
    public void PasswordFailTest() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        LoginUserDataAccessInterface userRepository = new InMemoryUserDAO();
        User user = new User("test", "pass", "gmail");
        userRepository.save(user);
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
            }

            @Override
            public void prepareFailView(String error) throws ExecutionException, InterruptedException {
                Assertions.assertNotEquals("pass2", userRepository.get("test").getPassword());
            }

            @Override
            public void prepareSuccessView() {}
        };

        LoginInputData login = new LoginInputData("test", "pass2");
        LoginInputBoundary loginInteractor = new LoginInteractor(userRepository, presenter);
        loginInteractor.execute(login);
    }

    @Test
    public void UsernameFailTest() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        LoginUserDataAccessInterface userRepository = new InMemoryUserDAO();
        User user = new User("test", "pass", "gmail");
        userRepository.save(user);
        LoginOutputBoundary presenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
            }

            @Override
            public void prepareFailView(String error) throws ExecutionException, InterruptedException {
                Assertions.assertNotEquals("user2", userRepository.get("test").getPassword());
            }

            @Override
            public void prepareSuccessView() {}
        };

        LoginInputData login = new LoginInputData("user2", "pass");
        LoginInputBoundary loginInteractor = new LoginInteractor(userRepository, presenter);
        loginInteractor.execute(login);
    }

    @Test
    public void EmptyExecuteTest() {
        LoginPresenter loginPresenter = mock(LoginPresenter.class);
        LoginUserDataAccessInterface userRepository = new InMemoryUserDAO();

        LoginInputBoundary loginInteractor = new LoginInteractor(userRepository, loginPresenter);


        loginInteractor.execute();

        verify(loginPresenter, times(1)).prepareSuccessView();
    }
}
