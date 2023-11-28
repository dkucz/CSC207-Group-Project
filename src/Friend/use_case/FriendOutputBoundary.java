package Friend.use_case;

import Friend.interface_adapter.FriendViewManagerModel;
import Friend.view.FriendViewManager;

public interface FriendOutputBoundary {
    void prepareSuccessView(FriendOutputData friendOutputData);
    FriendViewManager getFriendViewManager();
}

