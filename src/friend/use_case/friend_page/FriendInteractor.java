package friend.use_case.friend_page;

import friend.data_access.friend_page.FriendPageDAOInterface;
import friend.interface_adapter.friend_page.FriendPresenter;
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
