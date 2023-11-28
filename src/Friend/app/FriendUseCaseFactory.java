package Friend.app;
import Friend.interface_adapter.FriendController;
import Friend.interface_adapter.FriendPresenter;
import Friend.interface_adapter.FriendViewManagerModel;
import Friend.interface_adapter.FriendViewModel;
import Friend.use_case.FriendInputBoundary;
import Friend.use_case.FriendInteractor;
import Friend.view.FriendViewManager;
import data_access.FirestoreDAO;

import java.io.IOException;

public class FriendUseCaseFactory {
    public FriendUseCaseFactory(){}
    public static FriendController create(FriendViewModel friendViewModel,
                                          FriendViewManager friendViewManager) throws IOException {
        String firestoreDAO = "";                               // 4700： FirestoreDAO firestoreDAO = new FirestoreDAO();
        FriendPresenter FriendPresenter = new FriendPresenter(friendViewModel,friendViewManager);
        FriendInputBoundary friendInteractor = new FriendInteractor(FriendPresenter,firestoreDAO);
        return new FriendController(friendInteractor);
    }
}
