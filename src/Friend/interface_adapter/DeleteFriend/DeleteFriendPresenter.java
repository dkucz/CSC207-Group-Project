package Friend.interface_adapter.DeleteFriend;

import Friend.use_case.DeleteFriend.DeleteFriendOutputBoundary;
import Friend.use_case.DeleteFriend.DeleteFriendOutputData;
import Friend.view.FriendViewManager;

public class DeleteFriendPresenter implements DeleteFriendOutputBoundary {
    private FriendViewManager friendViewManager;
    public DeleteFriendPresenter(FriendViewManager friendViewManager){
        this.friendViewManager = friendViewManager;
    }
    @Override
    public void prepareSuccessView(DeleteFriendOutputData deleteFriendOutputData) {
        assert deleteFriendOutputData.isDeleteSuccess();
        this.friendViewManager.getDeleteFriendView().getDeleteFriendViewModel().setDeleteFriendCompleted(true);
        this.friendViewManager.getDeleteFriendView().
                getDeleteFriendViewModel().setDeletedFriendUsername(deleteFriendOutputData.getDeletedFriendUsername());
        this.friendViewManager.getDeleteFriendView().getDeleteFriendViewModel().setMessage("is deleted.");
        this.friendViewManager.getDeleteFriendView().getDeleteFriendViewModel().setOutputDataList();
        this.friendViewManager.getDeleteFriendView().getDeleteFriendViewModel().firePropertyChanged();
    }
    public FriendViewManager getFriendViewManager() {
        return friendViewManager;
    }
}
