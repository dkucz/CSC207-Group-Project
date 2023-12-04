package friend.use_case.add_friend;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface AddFriendInputBoundary {
    void execute(AddFriendInputData addFriendInputData) throws ExecutionException, InterruptedException, IOException;
}
