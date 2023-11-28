package Friend.use_case;

import Friend.interface_adapter.DeleteFriendPresenter;
import data_access.FirestoreDAO;
import entity.Friend;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DeleteFriendInteractor implements DeleteFriendInputBoundary{
    private DeleteFriendOutputBoundary deleteFriendPresenter;
    private FirestoreDAO firestoreDAO;
    public DeleteFriendInteractor(DeleteFriendOutputBoundary deleteFriendPresenter, FirestoreDAO firestoreDAO){
        this.deleteFriendPresenter = deleteFriendPresenter;
        this.firestoreDAO = firestoreDAO;
    }
    @Override
    public void execute(DeleteFriendInputData deleteFriendInputData) throws ExecutionException, InterruptedException {
        String userName = deleteFriendInputData.getCurrentUsername();
        String friendName = deleteFriendInputData.getFriendUsername();
        ArrayList<Object> outputDataList = new ArrayList<>();
        this.firestoreDAO.removeFriend(userName, friendName);
        this.firestoreDAO.removeFriend(friendName,userName);
        ArrayList<Friend> friendList = this.deleteFriendPresenter.getFriendViewManager().
                getFriendView().getFriendList();
        for(Friend i : friendList){
            if(i.getUsername().equals(friendName)){
                friendList.remove(i);
                break;
            }
        }
        outputDataList.add(userName);
        outputDataList.add(friendList);
        outputDataList.add(this.deleteFriendPresenter.getFriendViewManager());

        this.deleteFriendPresenter.getFriendViewManager().getFriendView().
                getFriendViewModel().setOutputDataList(outputDataList);
        this.deleteFriendPresenter.getFriendViewManager().getFriendView().getFriendViewModel().firePropertyChanged();
        DeleteFriendOutputData outputData = new DeleteFriendOutputData(true, friendName);
        this.deleteFriendPresenter.prepareSuccessView(outputData);
    }
}
