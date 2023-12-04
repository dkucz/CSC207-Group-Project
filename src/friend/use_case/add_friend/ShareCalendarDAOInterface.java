package friend.use_case.add_friend;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ShareCalendarDAOInterface {
    void createAccessControlRule(String gmail) throws GeneralSecurityException, IOException;
}
