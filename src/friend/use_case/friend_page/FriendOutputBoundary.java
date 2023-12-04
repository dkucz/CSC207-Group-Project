package friend.use_case.friend_page;

import friend.view.FriendViewManager;

public interface FriendOutputBoundary {
    void prepareSuccessView(FriendOutputData friendOutputData);
    FriendViewManager getFriendViewManager();
}

