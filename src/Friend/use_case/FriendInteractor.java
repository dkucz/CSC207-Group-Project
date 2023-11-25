package Friend.use_case;

import Friend.interface_adapter.FriendPresenter;
import Friend.data_access.FriendDataAccessInterface;
import data_access.FirestoreDAO;

public class FriendInteractor implements FriendInputBoundary {
    private final FriendOutputBoundary friendPresenter;
    private final FirestoreDAO firestoreDAO;
    public FriendInteractor(FriendPresenter FriendPresenter, FirestoreDAO firestoreDAO){
        this.friendPresenter = FriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(FriendInputData FriendInputData){
        this.friendPresenter.prepareSuccessView();
    }
}
