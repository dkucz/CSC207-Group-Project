package friend.app;

import friend.data_access.delete_friend.DeleteFriendDAOInterface;
import friend.interface_adapter.delete_friend.DeleteFriendController;
import friend.interface_adapter.delete_friend.DeleteFriendPresenter;
import friend.use_case.delete_friend.DeleteFriendInputBoundary;
import friend.use_case.delete_friend.DeleteFriendInteractor;
import friend.use_case.delete_friend.DeleteFriendOutputBoundary;
import friend.view.FriendViewManager;
import data_access.FirestoreDAO;
import java.io.IOException;

public class DeleteFriendUseCaseFactory {
    public DeleteFriendUseCaseFactory(){}
    public static DeleteFriendController create(FriendViewManager friendViewManager) throws IOException {
        DeleteFriendDAOInterface firestoreDAO = new FirestoreDAO();
        DeleteFriendOutputBoundary deleteFriendPresenter = new DeleteFriendPresenter(friendViewManager);
        DeleteFriendInputBoundary deleteFriendInteractor = new DeleteFriendInteractor(deleteFriendPresenter, firestoreDAO);
        return new DeleteFriendController(deleteFriendInteractor);
    }
}
