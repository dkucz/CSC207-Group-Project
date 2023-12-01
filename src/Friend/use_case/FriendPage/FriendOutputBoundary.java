package Friend.use_case.FriendPage;

import Friend.view.FriendViewManager;

public interface FriendOutputBoundary {
    void prepareSuccessView(FriendOutputData friendOutputData);
    FriendViewManager getFriendViewManager();
}

