package signup.use_case;

public interface SignupOutputBoundary {
    void prepareFailView(String s);

    void prepareSuccessView(SignupOutputData signupOutputData);

    void prepareSuccessView();
}
