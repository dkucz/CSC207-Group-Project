package friend.app;

import friend.data_access.add_friend.AddFriendDAOInterface;
import friend.interface_adapter.add_friend.AddFriendController;
import friend.interface_adapter.add_friend.AddFriendPresenter;
import friend.use_case.add_friend.AddFriendInputBoundary;
import friend.use_case.add_friend.AddFriendInteractor;
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
