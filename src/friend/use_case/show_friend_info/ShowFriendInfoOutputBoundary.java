package friend.use_case.show_friend_info;

import friend.view.FriendViewManager;

public interface ShowFriendInfoOutputBoundary {
    void prepareSuccessView(ShowFriendInfoOutputData showFriendInfoOutputData);
    FriendViewManager getFriendViewManager();
}
