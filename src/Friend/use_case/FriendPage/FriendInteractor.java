package Friend.use_case.FriendPage;

import Friend.data_access.FriendPage.FriendPageDAOInterface;
import Friend.interface_adapter.FriendPage.FriendPresenter;
import data_access.FirestoreDAO;
import entity.Friend;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class FriendInteractor implements FriendInputBoundary {
    private final FriendOutputBoundary friendPresenter;
    private final FriendPageDAOInterface firestoreDAO;
    public FriendInteractor(FriendPresenter FriendPresenter, FriendPageDAOInterface firestoreDAO){
        this.friendPresenter = FriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(FriendInputData friendInputData) throws ExecutionException, InterruptedException {
        ArrayList<Friend> friendList = (ArrayList<Friend>) firestoreDAO.getFriendsAsList(friendInputData.getUserName());
        FriendOutputData outputData = new FriendOutputData(friendInputData.getUserName(), friendList,
                this.friendPresenter.getFriendViewManager());
        this.friendPresenter.prepareSuccessView(outputData);
    }
}
