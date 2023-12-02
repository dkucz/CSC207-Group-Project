package login.use_case;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface LoginOutputBoundary {
    void prepareSuccessView(LoginOutputData user) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException;

    void prepareFailView(String error) throws ExecutionException, InterruptedException;

    void prepareSuccessView();
}
