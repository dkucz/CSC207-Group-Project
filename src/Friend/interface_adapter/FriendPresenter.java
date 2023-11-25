package Friend.interface_adapter;

import Friend.use_case.FriendOutputBoundary;

public class FriendPresenter implements FriendOutputBoundary {
    private final FriendViewModel friendViewModel;
    private final FriendViewManagerModel friendViewManagerModel;
    public FriendPresenter(FriendViewModel friendViewModel, FriendViewManagerModel friendViewManagerModel){
        this.friendViewModel = friendViewModel;
        this.friendViewManagerModel = friendViewManagerModel;
    }
    @Override
    public void prepareSuccessView() {
        this.friendViewManagerModel.setActiveView("FRIEND");
        this.friendViewManagerModel.firePropertyChanged();
    }
}
