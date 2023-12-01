package Friend.interface_adapter.AddFriend;

import Friend.use_case.AddFriend.AddFriendInputBoundary;
import Friend.use_case.AddFriend.AddFriendInputData;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AddFriendController {
    private final AddFriendInputBoundary addFriendInteractor;
    public AddFriendController(AddFriendInputBoundary addFriendInterractor){
        this.addFriendInteractor = addFriendInterractor;
    }
    public void execute(String currentUsername, String wantToAddFriendUsername) throws ExecutionException, InterruptedException, IOException {
        AddFriendInputData addFriendInputData = new AddFriendInputData(currentUsername, wantToAddFriendUsername);
        this.addFriendInteractor.execute(addFriendInputData);
    }
}
