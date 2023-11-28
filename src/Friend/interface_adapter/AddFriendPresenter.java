package Friend.interface_adapter;

import Friend.use_case.AddFriendOutputBoundary;
import Friend.use_case.AddFriendOutputData;
import Friend.view.FriendViewManager;
import entity.Friend;

import java.util.ArrayList;

public class AddFriendPresenter implements AddFriendOutputBoundary {
    private final FriendViewManagerModel friendViewManagerModel;
    private final FriendViewManager friendViewManager;
    public AddFriendPresenter(FriendViewManager friendViewManager){
        this.friendViewManager = friendViewManager;
        this.friendViewManagerModel = friendViewManager.getFriendViewManagerModel();
    }
    @Override
    public void prepareSuccessView(AddFriendOutputData addFriendOutputData) {
        ArrayList<Object> outputDataList = new ArrayList<>();
        ArrayList<Friend> friendList = this.friendViewManager.getFriendView().getFriendList();
        String currentUsername = addFriendOutputData.getCurrentUserName();
        String wantToAddFriendUsername = addFriendOutputData.getWantToAddFriendUsername();
        String wantToAddFriendGmail = addFriendOutputData.getWantToADdFriendGmail();
        Friend wantToAddFriend = new Friend(wantToAddFriendUsername);
        wantToAddFriend.setGmail(wantToAddFriendGmail);
        friendList.add(wantToAddFriend);
        outputDataList.add(currentUsername);
        outputDataList.add(friendList);
        outputDataList.add(this.friendViewManager);
        this.friendViewManager.getFriendView().getFriendViewModel().setOutputDataList(outputDataList);
        this.friendViewManager.getFriendView().getFriendViewModel().firePropertyChanged();
    }

    @Override
    public void prepareFailedView(AddFriendOutputData outputData) {
        boolean friendDoesNotExist = outputData.isFriendDoesNotExist();
        boolean friendAlreadyInList = outputData.isFriendAlreadyInList();
        if(friendDoesNotExist){
            // TBI.
        }else if(friendAlreadyInList){
            this.friendViewManager.getAddFriendFailedView().getAddFriendFailedViewModel().
                    setErrorMessage("Already in your friend list.");
            this.friendViewManager.getAddFriendFailedView().getAddFriendFailedViewModel().firePropertyChanged();
            this.friendViewManager.getFriendViewManagerModel().setActiveView("addFriendFailedView");
            this.friendViewManager.getFriendViewManagerModel().firePropertyChanged();
        }
    }

    @Override
    public FriendViewManager getFriendViewManager() {
        return this.friendViewManager;
    }
}
