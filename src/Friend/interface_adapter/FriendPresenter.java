package Friend.interface_adapter;

import Friend.use_case.FriendInputData;
import Friend.use_case.FriendOutputBoundary;
import Friend.use_case.FriendOutputData;

public class FriendPresenter implements FriendOutputBoundary {
    private final FriendViewModel friendViewModel;
    private final FriendViewManagerModel friendViewManagerModel;
    public FriendPresenter(FriendViewModel friendViewModel, FriendViewManagerModel friendViewManagerModel){
        this.friendViewModel = friendViewModel;
        this.friendViewManagerModel = friendViewManagerModel;
    }
    @Override
    public void prepareSuccessView(FriendOutputData outputData) {
        this.friendViewManagerModel.setActiveView("FRIEND");
        this.friendViewManagerModel.firePropertyChanged();
        friendViewModel.setCurrentUserName(outputData.getUserName());
        friendViewModel.firePropertyChanged();
    }
}
