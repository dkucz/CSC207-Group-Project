package signup.use_case;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public interface SignupInputBoundary {
    void execute(SignupInputData inputData) throws ExecutionException, InterruptedException, GeneralSecurityException, IOException;

    void execute();
}
