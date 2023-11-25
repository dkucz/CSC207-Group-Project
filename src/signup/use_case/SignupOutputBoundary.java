package signup.use_case;

import java.util.concurrent.ExecutionException;

public interface SignupOutputBoundary {
    void prepareFailView(String s) throws ExecutionException, InterruptedException;

    void prepareSuccessView(SignupOutputData signupOutputData) throws ExecutionException, InterruptedException;

    void prepareSuccessView();
}
