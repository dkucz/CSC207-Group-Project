package friend.app;
import friend.data_access.DeleteFriend.DeleteFriendDAOInterface;
import friend.interface_adapter.DeleteFriend.DeleteFriendController;
import friend.interface_adapter.DeleteFriend.DeleteFriendPresenter;
import friend.use_case.DeleteFriend.DeleteFriendInputBoundary;
import friend.use_case.DeleteFriend.DeleteFriendInteractor;
import friend.use_case.DeleteFriend.DeleteFriendOutputBoundary;
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
