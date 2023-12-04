package friend.use_case.DeleteFriend;

import friend.view.FriendViewManager;

public interface DeleteFriendOutputBoundary {
    void prepareSuccessView(DeleteFriendOutputData deleteFriendOutputData);
    FriendViewManager getFriendViewManager();
}
