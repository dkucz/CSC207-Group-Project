package login.use_case;

import java.io.IOException;
import java.security.GeneralSecurityException;

interface LoginInputBoundary {
    void execute(LoginInputData loginInputData) throws GeneralSecurityException, IOException;
}
