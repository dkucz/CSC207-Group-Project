package Friend.use_case;

import Friend.interface_adapter.AddFriendPresenter;
import Friend.view.FriendViewManager;
import data_access.FirestoreDAO;
import entity.Friend;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AddFriendInteractor implements AddFriendInputBoundary {
    AddFriendOutputBoundary addFriendPresenter;
    FirestoreDAO firestoreDAO;
    public AddFriendInteractor(AddFriendOutputBoundary addFriendPresenter, FirestoreDAO firestoreDAO){
        this.addFriendPresenter = addFriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(AddFriendInputData addFriendInputData) throws ExecutionException, InterruptedException, IOException {
        String currentUsername = addFriendInputData.getCurrentUsername();
        String wantToAddFriendUsername = addFriendInputData.wantToAddFriendUsername;
        boolean friendDoesNotExist = !(this.firestoreDAO.existsByName(wantToAddFriendUsername));
        boolean friendAlreadyInList = false;
        String friendGmail = "";
        if(friendDoesNotExist){
            friendGmail = "NO SUCH USER.";
        }else{
            friendGmail = firestoreDAO.getUserFromName(wantToAddFriendUsername).getGmail();
        }
        FriendViewManager friendViewManager = this.addFriendPresenter.getFriendViewManager();
        ArrayList<Friend> friendList = friendViewManager.getFriendView().getFriendList();
        for(Friend i: friendList){
            if(i.getUsername().equals(wantToAddFriendUsername)){
                friendAlreadyInList = true;
            }
        }
        AddFriendOutputData outputData = new AddFriendOutputData(currentUsername,
                wantToAddFriendUsername,
                friendGmail,
                friendDoesNotExist,
                friendAlreadyInList );

        if(friendDoesNotExist){
            this.addFriendPresenter.prepareFailedView(outputData);
        }else if(friendAlreadyInList){
            this.addFriendPresenter.prepareFailedView(outputData);
        }else {

            User currentUser = firestoreDAO.getUserFromName(currentUsername);
            String friendUsername = this.firestoreDAO.getUserFromName(wantToAddFriendUsername).getUsername();
            Friend friend = new Friend(friendUsername);
            friend.setGmail(friendGmail);
            firestoreDAO.addFriend(currentUser,friend);
            this.addFriendPresenter.prepareSuccessView(outputData);
        }
    }
}
