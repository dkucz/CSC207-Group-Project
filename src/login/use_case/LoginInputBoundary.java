package login.use_case;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData) throws GeneralSecurityException, IOException, ExecutionException, InterruptedException;

    void execute();
}
