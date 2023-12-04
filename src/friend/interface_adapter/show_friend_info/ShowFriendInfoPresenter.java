package friend.interface_adapter.show_friend_info;

import friend.interface_adapter.FriendViewManagerModel;
import friend.use_case.show_friend_info.ShowFriendInfoOutputBoundary;
import friend.use_case.show_friend_info.ShowFriendInfoOutputData;
import friend.view.FriendViewManager;

public class ShowFriendInfoPresenter implements ShowFriendInfoOutputBoundary {
    private final ShowFriendInfoViewModel showFriendInfoViewModel;
    private final FriendViewManagerModel friendViewManagerModel;
    private final FriendViewManager friendViewManager;
    public ShowFriendInfoPresenter(ShowFriendInfoViewModel showFriendInfoViewModel, FriendViewManager friendViewManager){
        this.showFriendInfoViewModel = showFriendInfoViewModel;
        this.friendViewManagerModel = friendViewManager.getFriendViewManagerModel();
        this.friendViewManager = friendViewManager;
    }

    public FriendViewManager getFriendViewManager() {
        return this.friendViewManager;
    }

    @Override
    public void prepareSuccessView(ShowFriendInfoOutputData showFriendInfoOutputData) {
        this.friendViewManagerModel.setActiveView("showFriendInfoView");
        this.friendViewManagerModel.firePropertyChanged();
        this.showFriendInfoViewModel.setOutputDataList(showFriendInfoOutputData.getOutputDataAsAList());
        this.showFriendInfoViewModel.firePropertyChanged();
    }
}
