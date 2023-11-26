package Friend.interface_adapter;

import Friend.use_case.ShowFriendInfoOutputBoundary;
import Friend.use_case.ShowFriendInfoOutputData;

public class ShowFriendInfoPresenter implements ShowFriendInfoOutputBoundary {
    private final ShowFriendInfoViewModel showFriendInfoViewModel;
    private final FriendViewManagerModel friendViewManagerModel;
    public ShowFriendInfoPresenter(ShowFriendInfoViewModel showFriendInfoViewModel, FriendViewManagerModel friendViewManagerModel){
        this.showFriendInfoViewModel = showFriendInfoViewModel;
        this.friendViewManagerModel = friendViewManagerModel;
    }
    @Override
    public void prepareSuccessView(ShowFriendInfoOutputData showFriendInfoOutputData) {
        this.friendViewManagerModel.setActiveView("ShowFriendInfoView");
        this.friendViewManagerModel.firePropertyChanged();
        this.showFriendInfoViewModel.setOutputDataList(showFriendInfoOutputData.getOutputDataAsAList());
        this.showFriendInfoViewModel.firePropertyChanged();
    }
}
