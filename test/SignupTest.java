import entity.UserFactory;
import org.junit.Test;
import signup.data_access.SignupUserDataAccessInterface;
import signup.use_case.SignupInteractor;
import signup.use_case.SignupOutputBoundary;

import java.io.IOException;

public class SignupTest {

    private SignupInteractor signupInteractor;
    private SignupUserDataAccessInterface signupDataAccess;
    private SignupOutputBoundary signupPresenter;
    private UserFactory userFactory;

    @Test
    public void testSignupWithSampleData() throws IOException {

    }
}
