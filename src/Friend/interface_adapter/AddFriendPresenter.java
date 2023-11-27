package Friend.interface_adapter;

import Friend.use_case.AddFriendOutputBoundary;
import Friend.view.FriendViewManager;

public class AddFriendPresenter implements AddFriendOutputBoundary {
    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailedView() {

    }

    @Override
    public FriendViewManager getFriendViewManager() {
        return null;
    }
}
