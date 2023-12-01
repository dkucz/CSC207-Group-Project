package login.use_case;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user) throws GeneralSecurityException, IOException;

    void prepareFailView(String error);

    void prepareSuccessView();
}
