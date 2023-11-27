package Friend.use_case;

import Friend.interface_adapter.AddFriendPresenter;
import Friend.view.FriendViewManager;
import data_access.FirestoreDAO;
import entity.Friend;
import java.util.ArrayList;

public class AddFriendInteractor implements AddFriendInputBoundary {
    AddFriendOutputBoundary addFriendPresenter;
    String firestoreDAO; //4700: FirestoreDAO firestoreDAO;
    public AddFriendInteractor(AddFriendOutputBoundary addFriendPresenter, String firestoreDAO){ //4700: public AddFriendInteractor(AddFriendOutputBoundary addFriendPresenter, FirestoreDAO firestoreDAO){
        this.addFriendPresenter = addFriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(AddFriendInputData addFriendInputData) {
        // 4701: I need a functional database to check weather this friend is already in this user's friend list or doesn't even exist to prepare a failedView.
        // Now I only prepare success view here.
        String currentUsername = addFriendInputData.getCurrentUsername();
        String wantToAddFriendUsername = addFriendInputData.wantToAddFriendUsername;
        String friendGmail = "123123@gmail.cccom"; // This gmail should be from the database.
        FriendViewManager friendViewManager = this.addFriendPresenter.getFriendViewManager();
        ArrayList<Friend> friendList = friendViewManager.getFriendView().getFriendList();
        boolean friendDoesNotExist = false; // Need to access the database to check this.
        boolean friendAlreadyInList = false;
        for(Friend i: friendList){
            if(i.getUsername().equals(wantToAddFriendUsername)){
                friendAlreadyInList = true;
                System.out.println("Exists.");
            }
        }
        AddFriendOutputData outputData = new AddFriendOutputData(currentUsername,
                wantToAddFriendUsername,
                friendGmail,
                false,
                friendAlreadyInList );
        if(friendAlreadyInList){
            this.addFriendPresenter.prepareFailedView(outputData);
        }else {
            this.addFriendPresenter.prepareSuccessView(outputData);
        }


    }
}
