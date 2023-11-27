package Friend.use_case;

import Friend.view.FriendViewManager;

public interface AddFriendOutputBoundary {
    void prepareSuccessView();
    void prepareFailedView();
    FriendViewManager getFriendViewManager();
}
