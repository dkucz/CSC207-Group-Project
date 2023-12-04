package friend.app;

import data_access.GoogleCalendarDAO;
import friend.data_access.add_friend.AddFriendDAOInterface;
import friend.interface_adapter.add_friend.AddFriendController;
import friend.interface_adapter.add_friend.AddFriendPresenter;
import friend.use_case.add_friend.AddFriendInputBoundary;
import friend.use_case.add_friend.AddFriendInteractor;
import friend.use_case.add_friend.ShareCalendarDAOInterface;
import friend.view.FriendViewManager;
import data_access.FirestoreDAO;

import java.io.IOException;

public class AddFriendUseCaseFactory {
    public AddFriendUseCaseFactory(){};
    public static AddFriendController create(FriendViewManager friendViewManager) throws IOException {

        AddFriendPresenter addFriendPresenter = new AddFriendPresenter(friendViewManager);

        AddFriendDAOInterface firestoreDAO = new FirestoreDAO();
        ShareCalendarDAOInterface calendarDAO = new GoogleCalendarDAO();

        AddFriendInputBoundary addFriendInteractor = new AddFriendInteractor(addFriendPresenter, firestoreDAO, calendarDAO);
        return new AddFriendController(addFriendInteractor);
    }
}
