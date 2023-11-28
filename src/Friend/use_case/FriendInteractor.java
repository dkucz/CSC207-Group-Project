package Friend.use_case;

import Friend.interface_adapter.FriendPresenter;
import entity.Friend;
import entity.UserFactory;

import java.util.ArrayList;

public class FriendInteractor implements FriendInputBoundary {
    private final FriendOutputBoundary friendPresenter;
    private final String firestoreDAO;//4700: private final FirestoreDAO firestoreDAO;
    public FriendInteractor(FriendPresenter FriendPresenter, String firestoreDAO){  //4700: public FriendInteractor(FriendPresenter FriendPresenter, FirestoreDAO firestoreDAO){
        this.friendPresenter = FriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(FriendInputData friendInputData){
        // The following codes exist only because of the missing method of fireStoreDAO.
        // If the DAO is implemented then the following codes will be replaced by one line code.
        ArrayList<Friend> friendList = new ArrayList<>();
        UserFactory F0 = new UserFactory();
        Friend U0 = new Friend("Pranky0");
        U0.setGmail("Pranky12478@gmail.com");
        Friend U1 = new Friend("Pranky1");
        U1.setGmail("Pranky124789@gmail.com");
        Friend U2 = new Friend("Pranky2");
        U2.setGmail("Pranky1247890@gmail.com");
        Friend U3 = new Friend("Pranky3");
        U3.setGmail("Pranky12478901@gmail.com");
        Friend U4 = new Friend("Pranky4");
        U4.setGmail("Pranky124789012@gmail.com");
        Friend U5 = new Friend("Pranky5");
        U5.setGmail("Pranky1247890123@gmail.com");
        friendList.add(U0);
        friendList.add(U1);
        friendList.add(U2);
        friendList.add(U3);
        friendList.add(U4);
        friendList.add(U5);
        //
        //4700： ArrayList<Friend> friendList = firestoreDAO.getFriendsAsList(friendInputData.getUserName());
        FriendOutputData outputData = new FriendOutputData(friendInputData.getUserName(), friendList,
                this.friendPresenter.getFriendViewManager());
        this.friendPresenter.prepareSuccessView(outputData);
    }
}
