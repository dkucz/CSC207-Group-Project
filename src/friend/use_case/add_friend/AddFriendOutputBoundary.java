package friend.use_case.add_friend;

import friend.view.FriendViewManager;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface AddFriendOutputBoundary {
    void prepareSuccessView(AddFriendOutputData addFriendOutputData) throws IOException, ExecutionException, InterruptedException;
    void prepareFailedView(AddFriendOutputData addFriendOutputData);
    FriendViewManager getFriendViewManager();
}
