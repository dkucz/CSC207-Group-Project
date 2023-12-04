package friend.use_case.DeleteFriend;

import java.util.concurrent.ExecutionException;

public interface DeleteFriendInputBoundary {
    void execute(DeleteFriendInputData deleteFriendInputData) throws ExecutionException, InterruptedException;
}
