package Friend.app;
import Friend.data_access.FriendPage.FriendPageDAOInterface;
import Friend.interface_adapter.FriendPage.FriendController;
import Friend.interface_adapter.FriendPage.FriendPresenter;
import Friend.interface_adapter.FriendPage.FriendViewModel;
import Friend.use_case.FriendPage.FriendInputBoundary;
import Friend.use_case.FriendPage.FriendInteractor;
import Friend.view.FriendViewManager;
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
