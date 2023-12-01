package Friend.app;

import Friend.interface_adapter.AddFriend.AddFriendController;
import Friend.interface_adapter.AddFriend.AddFriendPresenter;
import Friend.use_case.AddFriend.AddFriendInputBoundary;
import Friend.use_case.AddFriend.AddFriendInteractor;
import Friend.view.FriendViewManager;
import data_access.FirestoreDAO;

import java.io.IOException;

public class AddFriendUseCaseFactory {
    public AddFriendUseCaseFactory(){};
    public static AddFriendController create(FriendViewManager friendViewManager) throws IOException {

        AddFriendPresenter addFriendPresenter = new AddFriendPresenter(friendViewManager);

        FirestoreDAO firestoreDAO = new FirestoreDAO();

        AddFriendInputBoundary addFriendInteractor = new AddFriendInteractor(addFriendPresenter, firestoreDAO);
        return new AddFriendController(addFriendInteractor);
    }
}
