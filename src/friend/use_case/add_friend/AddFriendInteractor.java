package friend.use_case.add_friend;

import friend.data_access.add_friend.AddFriendDAOInterface;
import friend.view.FriendViewManager;
import entity.Friend;
import entity.User;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AddFriendInteractor implements AddFriendInputBoundary {
    AddFriendOutputBoundary addFriendPresenter;
    AddFriendDAOInterface firestoreDAO;
    ShareCalendarDAOInterface calendarDAO;
    public AddFriendInteractor(AddFriendOutputBoundary addFriendPresenter, AddFriendDAOInterface firestoreDAO, ShareCalendarDAOInterface calendarDAO){
        this.addFriendPresenter = addFriendPresenter;
        this.firestoreDAO = firestoreDAO;
        this.calendarDAO = calendarDAO;
    }
    @Override
    public void execute(AddFriendInputData addFriendInputData) throws ExecutionException, InterruptedException, IOException, GeneralSecurityException {
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
            String friendUsername = this.firestoreDAO.getUserFromName(wantToAddFriendUsername).getUsername();

            User currentUser = firestoreDAO.getUserFromName(currentUsername);
            Friend friend = new Friend(friendUsername);

            User Friend = firestoreDAO.getUserFromName(friendUsername);
            Friend User = new Friend(currentUsername);
            User.setGmail(currentUser.getGmail());
            friend.setGmail(friendGmail);

            firestoreDAO.addFriend(currentUser,friend);
            firestoreDAO.addFriend(Friend,User);
            calendarDAO.createAccessControlRule(friend.getGmail());
            this.addFriendPresenter.prepareSuccessView(outputData);
        }
    }
}
