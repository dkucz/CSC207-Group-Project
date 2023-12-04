package friend.use_case.ShowFriendInfo;

import friend.view.FriendViewManager;

public interface ShowFriendInfoOutputBoundary {
    void prepareSuccessView(ShowFriendInfoOutputData showFriendInfoOutputData);
    FriendViewManager getFriendViewManager();
}
