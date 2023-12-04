package friend.use_case.friend_page;

import java.util.concurrent.ExecutionException;

public interface FriendInputBoundary {
    void execute(FriendInputData x) throws ExecutionException, InterruptedException;
}
