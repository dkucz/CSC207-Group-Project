package Friend.use_case;

import Friend.interface_adapter.FriendPresenter;
import data_access.FirestoreDAO;

public class FriendInteractor implements FriendInputBoundary {
    private final FriendOutputBoundary friendPresenter;
    private final String firestoreDAO;//private final FirestoreDAO firestoreDAO;
    public FriendInteractor(FriendPresenter FriendPresenter, String firestoreDAO){  //public FriendInteractor(FriendPresenter FriendPresenter, FirestoreDAO firestoreDAO){
        this.friendPresenter = FriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(FriendInputData FriendInputData){
        this.friendPresenter.prepareSuccessView();
    }
}
