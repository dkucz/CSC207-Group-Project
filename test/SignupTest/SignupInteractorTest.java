package SignupTest;

import data_access.InMemoryUserDAO;
import entity.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import signup.data_access.SignupUserDataAccessInterface;
import signup.use_case.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class SignupInteractorTest {

    @Test
    void SuccessTest() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        SignupUserDataAccessInterface userRepository = new InMemoryUserDAO();
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareFailView(String s) {
                Assertions.fail("Use case failure is unexpected");
            }

            @Override
            public void prepareSuccessView(SignupOutputData user) throws ExecutionException, InterruptedException {
                Assertions.assertEquals("testUser", user.getUsername());
                Assertions.assertTrue(userRepository.existsByName(user.getUsername()));
            }

            @Override
            public void prepareSuccessView() {}

        };

        SignupInputData inputData = new SignupInputData("testUser", "test@gmail.com", "password123", "password123");
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new UserFactory());
        interactor.execute(inputData);
    }

    @Test
    void UserExistsTest() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        SignupUserDataAccessInterface userRepository = new InMemoryUserDAO();
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareFailView(String s) throws ExecutionException, InterruptedException {
                assertTrue(userRepository.existsByName("testUser"));
            }

            @Override
            public void prepareSuccessView(SignupOutputData user) {

            }

            @Override
            public void prepareSuccessView() {}

        };

        SignupInputData inputData = new SignupInputData("testUser", "test@gmail.com", "password123", "password123");
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new UserFactory());
        interactor.execute(inputData);
    }

    @Test
    void TestConstructor()
    {
        SignupUserDataAccessInterface expectedDataAccess = new InMemoryUserDAO();
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareFailView(String s) throws ExecutionException, InterruptedException {

            }

            @Override
            public void prepareSuccessView(SignupOutputData signupOutputData) throws ExecutionException, InterruptedException {

            }

            @Override
            public void prepareSuccessView() {

            }
        };
        UserFactory expectedUserFactory = new UserFactory();

        // Act
        SignupInteractor interactor = new SignupInteractor(expectedDataAccess, successPresenter, expectedUserFactory);

        // Assert
        assertNotNull(interactor);
    }

    @Test
    void TestLoginButton()
    {
        SignupUserDataAccessInterface userRepository = new InMemoryUserDAO();
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareFailView(String s) throws ExecutionException, InterruptedException {
                assertTrue(userRepository.existsByName("testUser"));
            }

            @Override
            public void prepareSuccessView(SignupOutputData user) {

            }

            @Override
            public void prepareSuccessView()
            {
                assertTrue(true);
            }

        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new UserFactory());
        interactor.execute();
    }

    @Test
    void TestEmptyInput() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        SignupUserDataAccessInterface userRepository = new InMemoryUserDAO();
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareFailView(String s) throws ExecutionException, InterruptedException {
            }

            @Override
            public void prepareSuccessView(SignupOutputData user) {

            }

            @Override
            public void prepareSuccessView() {}

        };

        SignupInputData inputData = new SignupInputData("", "test@gmail.com", "password123", "password123");
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new UserFactory());
        interactor.execute(inputData);
        assertTrue(!userRepository.existsByName(""));
    }

    @Test
    void TestNotMatchingPassword() throws ExecutionException, InterruptedException, GeneralSecurityException, IOException {
        SignupUserDataAccessInterface userRepository = new InMemoryUserDAO();
        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {

            @Override
            public void prepareFailView(String s) throws ExecutionException, InterruptedException {
            }

            @Override
            public void prepareSuccessView(SignupOutputData user) {

            }

            @Override
            public void prepareSuccessView() {}

        };

        SignupInputData inputData = new SignupInputData("g", "test@gmail.com", "passward123", "password123");
        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new UserFactory());
        interactor.execute(inputData);
        assertTrue(!userRepository.existsByName("g"));
    }
}
