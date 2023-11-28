package Friend.interface_adapter;

import Friend.use_case.AddFriendInputBoundary;
import Friend.use_case.AddFriendInputData;

import java.util.concurrent.ExecutionException;

public class AddFriendController {
    private final AddFriendInputBoundary addFriendInteractor;
    public AddFriendController(AddFriendInputBoundary addFriendInterractor){
        this.addFriendInteractor = addFriendInterractor;
    }
    public void execute(String currentUsername, String wantToAddFriendUsername) throws ExecutionException, InterruptedException {
        AddFriendInputData addFriendInputData = new AddFriendInputData(currentUsername, wantToAddFriendUsername);
        this.addFriendInteractor.execute(addFriendInputData);
    }
}
