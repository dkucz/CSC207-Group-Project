package Friend.use_case;

import Friend.interface_adapter.FriendPresenter;
import data_access.FirestoreDAO;
import entity.User;
import entity.UserFactory;

import java.util.ArrayList;

public class FriendInteractor implements FriendInputBoundary {
    private final FriendOutputBoundary friendPresenter;
    private final String firestoreDAO;//private final FirestoreDAO firestoreDAO;
    public FriendInteractor(FriendPresenter FriendPresenter, String firestoreDAO){  //public FriendInteractor(FriendPresenter FriendPresenter, FirestoreDAO firestoreDAO){
        this.friendPresenter = FriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(FriendInputData friendInputData){
        ArrayList<User> friendList = new ArrayList<>(); //ArrayList<Friend> friendList = new ArrayList<>();

        // The following codes exist only because of the missing method of fireStoreDAO.
        // If the DAO is implemented then the following codes will be replaced by one line code.
        UserFactory F0 = new UserFactory();
        User U0 = F0.create("Pranky55","Pranky1247","Pranky1247@gmail.com");
        User U1 = F0.create("Pranky00","Pranky1247","Pranky1247@gmail.com");
        User U2 = F0.create("Pranky11","Pranky1247","Pranky1247@gmail.com");
        User U3 = F0.create("Pranky22","Pranky1247","Pranky1247@gmail.com");
        User U4 = F0.create("Pranky33","Pranky1247","Pranky1247@gmail.com");
        User U5 = F0.create("Pranky44","Pranky1247","Pranky1247@gmail.com");
        friendList.add(U0);
        friendList.add(U1);
        friendList.add(U2);
        friendList.add(U3);
        friendList.add(U4);
        friendList.add(U5);
        //

        FriendOutputData outputData = new FriendOutputData(friendInputData.getUserName(), friendList);
        this.friendPresenter.prepareSuccessView(outputData);
    }
}
