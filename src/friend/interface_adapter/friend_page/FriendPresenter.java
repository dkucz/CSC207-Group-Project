package friend.interface_adapter.friend_page;
import friend.interface_adapter.FriendViewManagerModel;
import friend.use_case.friend_page.FriendOutputBoundary;
import friend.use_case.friend_page.FriendOutputData;
import friend.view.FriendViewManager;

public class FriendPresenter implements FriendOutputBoundary {
    private final FriendViewManager friendViewManager;
    private final FriendViewModel friendViewModel;
    private final FriendViewManagerModel friendViewManagerModel;
    public FriendPresenter(FriendViewModel friendViewModel, FriendViewManager friendViewManager){
        this.friendViewManager = friendViewManager;
        this.friendViewModel = friendViewModel;
        this.friendViewManagerModel = friendViewManager.getFriendViewManagerModel();
    }
    @Override
    public FriendViewManager getFriendViewManager() {
        return this.friendViewManager;
    }


    @Override
    public void prepareSuccessView(FriendOutputData outputData) {
        this.friendViewManagerModel.setActiveView("friendView");
        this.friendViewManagerModel.firePropertyChanged();
        friendViewModel.setOutputDataList(outputData.getOutputDataAsAList());
        friendViewModel.firePropertyChanged();
    }

//    @Override
//    public FriendViewManagerModel getFriendManagerViewModel() {
//        return null;
//    }
}
