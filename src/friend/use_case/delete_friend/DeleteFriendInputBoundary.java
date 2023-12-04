package friend.use_case.delete_friend;

import java.util.concurrent.ExecutionException;

public interface DeleteFriendInputBoundary {
    void execute(DeleteFriendInputData deleteFriendInputData) throws ExecutionException, InterruptedException;
}
