package Friend.use_case;

import Friend.interface_adapter.AddFriendPresenter;
import data_access.FirestoreDAO;

public class AddFriendInteractor implements AddFriendInputBoundary {
    AddFriendOutputBoundary addFriendPresenter;
    String firestoreDAO; //4700: FirestoreDAO firestoreDAO;
    public AddFriendInteractor(AddFriendOutputBoundary addFriendPresenter, String firestoreDAO){ //4700: public AddFriendInteractor(AddFriendOutputBoundary addFriendPresenter, FirestoreDAO firestoreDAO){
        this.addFriendPresenter = addFriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(AddFriendInputData addFriendInputData) {
        String currentUsername = addFriendInputData.getCurrentUsername();
        String wantToAddFriendUsername = addFriendInputData.wantToAddFriendUsername;

    }
}
