package Friend.app;

import Friend.interface_adapter.AddFriendController;
import Friend.interface_adapter.AddFriendPresenter;
import Friend.interface_adapter.AddFriendViewModel;
import Friend.use_case.AddFriendInputBoundary;
import Friend.use_case.AddFriendInteractor;
import Friend.view.FriendViewManager;
import data_access.FirestoreDAO;

public class AddFriendUseCaseFactory {
    public AddFriendUseCaseFactory(){};
    public static AddFriendController create(AddFriendViewModel addFriendViewModel, FriendViewManager friendViewManager){
        AddFriendPresenter addFriendPresenter = new AddFriendPresenter(addFriendViewModel, friendViewManager);

        String firestoreDao = ""; //4700: FirestoreDAO firestoreDAO = new FirestoreDAO();

        AddFriendInputBoundary addFriendInteractor = new AddFriendInteractor(addFriendPresenter, firestoreDao);
        return new AddFriendController(addFriendInteractor);
    }
}
