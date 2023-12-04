package friend.app;
import friend.data_access.FriendPage.FriendPageDAOInterface;
import friend.interface_adapter.FriendPage.FriendController;
import friend.interface_adapter.FriendPage.FriendPresenter;
import friend.interface_adapter.FriendPage.FriendViewModel;
import friend.use_case.FriendPage.FriendInputBoundary;
import friend.use_case.FriendPage.FriendInteractor;
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
