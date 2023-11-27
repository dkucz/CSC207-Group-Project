package Friend.use_case;

import Friend.view.FriendViewManager;

public interface AddFriendOutputBoundary {
    void prepareSuccessView(AddFriendOutputData addFriendOutputData);
    void prepareFailedView(AddFriendOutputData addFriendOutputData);
    FriendViewManager getFriendViewManager();
}
