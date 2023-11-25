package Friend.use_case;

import Friend.interface_adapter.FriendPresenter;
import Friend.data_access.FriendDataAccessInterface;

public class FriendInteractor implements FriendInputBoundary {
    private final FriendOutputBoundary friendPresenter;
    private final FriendDataAccessInterface friendDataAccessObject;

    public FriendInteractor(FriendPresenter FriendPresenter, FriendDataAccessInterface FriendDataAccessInterface){
        this.friendPresenter = FriendPresenter;
        this.friendDataAccessObject = FriendDataAccessInterface;
    }
    @Override
    public void execute(FriendInputData FriendInputData){
        this.friendPresenter.prepareSuccessView();
    }
}
