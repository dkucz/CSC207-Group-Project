package login.use_case;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData) throws GeneralSecurityException, IOException;
}
