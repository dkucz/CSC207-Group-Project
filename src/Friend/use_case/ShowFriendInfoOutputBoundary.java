package Friend.use_case;

import Friend.view.FriendViewManager;

public interface ShowFriendInfoOutputBoundary {
    void prepareSuccessView(ShowFriendInfoOutputData showFriendInfoOutputData);
    FriendViewManager getFriendViewManager();
}
