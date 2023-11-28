package Friend.app;
import Friend.interface_adapter.DeleteFriend.DeleteFriendController;
import Friend.interface_adapter.DeleteFriend.DeleteFriendPresenter;
import Friend.use_case.DeleteFriend.DeleteFriendInputBoundary;
import Friend.use_case.DeleteFriend.DeleteFriendInteractor;
import Friend.use_case.DeleteFriend.DeleteFriendOutputBoundary;
import Friend.view.FriendViewManager;
import data_access.FirestoreDAO;
import java.io.IOException;
public class DeleteFriendUseCaseFactory {
    public DeleteFriendUseCaseFactory(){}
    public static DeleteFriendController create(FriendViewManager friendViewManager) throws IOException {
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        DeleteFriendOutputBoundary deleteFriendPresenter = new DeleteFriendPresenter(friendViewManager);
        DeleteFriendInputBoundary deleteFriendInteractor = new DeleteFriendInteractor(deleteFriendPresenter, firestoreDAO);
        return new DeleteFriendController(deleteFriendInteractor);

    }
}
