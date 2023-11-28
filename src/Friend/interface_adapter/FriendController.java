package Friend.interface_adapter;

import Friend.app.FriendUseCaseFactory;
import Friend.use_case.FriendInputBoundary;
import Friend.use_case.FriendInputData;
import Friend.view.*;
import data_access.FirestoreDAO;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FriendController {
    private final FriendInputBoundary friendInteractor;
    public FriendController(FriendInputBoundary friendInteractor){
        this.friendInteractor = friendInteractor;
    }
    public void execute(String userName){
        FriendInputData friendInputData = new FriendInputData(userName);
        friendInteractor.execute(friendInputData);
    }
