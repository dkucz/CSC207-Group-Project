package Friend.interface_adapter.ShowFriendInfo;

import Friend.interface_adapter.FriendViewManagerModel;
import Friend.use_case.ShowFriendInfo.ShowFriendInfoOutputBoundary;
import Friend.use_case.ShowFriendInfo.ShowFriendInfoOutputData;
import Friend.view.FriendViewManager;

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
