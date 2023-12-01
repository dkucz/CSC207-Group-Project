package Friend.use_case.DeleteFriend;

import Friend.view.FriendViewManager;

public interface DeleteFriendOutputBoundary {
    void prepareSuccessView(DeleteFriendOutputData deleteFriendOutputData);
    FriendViewManager getFriendViewManager();
}
