package Friend.use_case.AddFriend;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface AddFriendInputBoundary {
    void execute(AddFriendInputData addFriendInputData) throws ExecutionException, InterruptedException, IOException;
}
