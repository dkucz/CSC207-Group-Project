package Friend.use_case;

import java.util.concurrent.ExecutionException;

public interface DeleteFriendInputBoundary {
    void execute(DeleteFriendInputData deleteFriendInputData) throws ExecutionException, InterruptedException;
}
