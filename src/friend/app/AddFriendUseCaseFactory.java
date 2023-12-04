package friend.app;

import friend.data_access.AddFriend.AddFriendDAOInterface;
import friend.interface_adapter.AddFriend.AddFriendController;
import friend.interface_adapter.AddFriend.AddFriendPresenter;
import friend.use_case.AddFriend.AddFriendInputBoundary;
import friend.use_case.AddFriend.AddFriendInteractor;
import friend.view.FriendViewManager;
import data_access.FirestoreDAO;

import java.io.IOException;

public class AddFriendUseCaseFactory {
    public AddFriendUseCaseFactory(){};
    public static AddFriendController create(FriendViewManager friendViewManager) throws IOException {

        AddFriendPresenter addFriendPresenter = new AddFriendPresenter(friendViewManager);

        AddFriendDAOInterface firestoreDAO = new FirestoreDAO();

        AddFriendInputBoundary addFriendInteractor = new AddFriendInteractor(addFriendPresenter, firestoreDAO);
        return new AddFriendController(addFriendInteractor);
    }
}
