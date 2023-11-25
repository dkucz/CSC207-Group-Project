package Friend.app;
import Friend.interface_adapter.FriendController;
import Friend.interface_adapter.FriendPresenter;
import Friend.interface_adapter.FriendViewManagerModel;
import Friend.interface_adapter.FriendViewModel;
import Friend.use_case.FriendInputBoundary;
import Friend.use_case.FriendInteractor;
import data_access.FirestoreDAO;

import java.io.IOException;

public class FriendUseCaseFactory {
    public FriendUseCaseFactory(){}
    public static FriendController create(FriendViewModel friendViewModel,
                                          FriendViewManagerModel friendViewManagerModel) throws IOException {
        String firestoreDAO = "";                               //FirestoreDAO firestoreDAO = new FirestoreDAO();
        FriendPresenter FriendPresenter = new FriendPresenter(friendViewModel,friendViewManagerModel);
        FriendInputBoundary friendInteractor = new FriendInteractor(FriendPresenter,firestoreDAO);
        return new FriendController(friendInteractor);
    }
}
