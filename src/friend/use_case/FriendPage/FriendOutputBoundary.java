package friend.use_case.FriendPage;

import friend.view.FriendViewManager;

public interface FriendOutputBoundary {
    void prepareSuccessView(FriendOutputData friendOutputData);
    FriendViewManager getFriendViewManager();
}

