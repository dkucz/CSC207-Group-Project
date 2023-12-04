package friend.interface_adapter.delete_friend;

import friend.use_case.delete_friend.DeleteFriendOutputBoundary;
import friend.use_case.delete_friend.DeleteFriendOutputData;
import friend.view.FriendViewManager;

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
