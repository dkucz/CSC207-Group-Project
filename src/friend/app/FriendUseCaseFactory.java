package friend.app;

import friend.data_access.friend_page.FriendPageDAOInterface;
import friend.interface_adapter.friend_page.FriendController;
import friend.interface_adapter.friend_page.FriendPresenter;
import friend.interface_adapter.friend_page.FriendViewModel;
import friend.use_case.friend_page.FriendInputBoundary;
import friend.use_case.friend_page.FriendInteractor;
import friend.view.FriendViewManager;
import data_access.FirestoreDAO;

import java.io.IOException;

public class FriendUseCaseFactory {
    public FriendUseCaseFactory(){}
    public static FriendController create(FriendViewModel friendViewModel,
                                          FriendViewManager friendViewManager) throws IOException {
        FriendPageDAOInterface firestoreDAO = new FirestoreDAO();
        FriendPresenter FriendPresenter = new FriendPresenter(friendViewModel,friendViewManager);
        FriendInputBoundary friendInteractor = new FriendInteractor(FriendPresenter,firestoreDAO);
        return new FriendController(friendInteractor);
    }
}
