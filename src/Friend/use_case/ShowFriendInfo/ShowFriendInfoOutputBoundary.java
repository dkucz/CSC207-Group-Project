package Friend.use_case.ShowFriendInfo;

import Friend.view.FriendViewManager;

public interface ShowFriendInfoOutputBoundary {
    void prepareSuccessView(ShowFriendInfoOutputData showFriendInfoOutputData);
    FriendViewManager getFriendViewManager();
}
