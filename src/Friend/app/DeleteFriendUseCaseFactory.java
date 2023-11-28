package Friend.app;
import Friend.interface_adapter.DeleteFriendController;
import Friend.interface_adapter.DeleteFriendPresenter;
import Friend.interface_adapter.DeleteFriendViewModel;
import Friend.use_case.DeleteFriendInputBoundary;
import Friend.use_case.DeleteFriendInteractor;
import Friend.use_case.DeleteFriendOutputBoundary;
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
