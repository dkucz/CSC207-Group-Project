package friend.use_case.delete_friend;

import friend.view.FriendViewManager;

public interface DeleteFriendOutputBoundary {
    void prepareSuccessView(DeleteFriendOutputData deleteFriendOutputData);
    FriendViewManager getFriendViewManager();
}
