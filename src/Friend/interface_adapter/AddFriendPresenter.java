package Friend.interface_adapter;

import Friend.use_case.AddFriendOutputBoundary;
import Friend.use_case.AddFriendOutputData;
import Friend.view.FriendViewManager;

public class AddFriendPresenter implements AddFriendOutputBoundary {
    private final AddFriendViewModel addFriendViewModel;
    private final FriendViewManagerModel friendViewManagerModel;
    private final FriendViewManager friendViewManager;
    public AddFriendPresenter(AddFriendViewModel addFriendViewModel, FriendViewManager friendViewManager){
        this.addFriendViewModel = addFriendViewModel;
        this.friendViewManager = friendViewManager;
        this.friendViewManagerModel = friendViewManager.getFriendViewManagerModel();
    }
    @Override
    public void prepareSuccessView(AddFriendOutputData addFriendOutputData) {

    }

    @Override
    public void prepareFailedView() {

    }

    @Override
    public FriendViewManager getFriendViewManager() {
        return this.friendViewManager;
    }
}
