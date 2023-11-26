package signup.use_case;

import java.util.concurrent.ExecutionException;

public interface SignupInputBoundary {
    void execute(SignupInputData inputData) throws ExecutionException, InterruptedException;

    void execute();
}
