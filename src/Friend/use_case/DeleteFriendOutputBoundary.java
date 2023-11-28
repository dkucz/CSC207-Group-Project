package Friend.use_case;

import Friend.view.FriendViewManager;

public interface DeleteFriendOutputBoundary {
    void prepareSuccessView(DeleteFriendOutputData deleteFriendOutputData);
    FriendViewManager getFriendViewManager();
}
