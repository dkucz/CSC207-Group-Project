package friend.interface_adapter.add_friend;

import friend.use_case.add_friend.AddFriendInputBoundary;
import friend.use_case.add_friend.AddFriendInputData;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class AddFriendController {
    private final AddFriendInputBoundary addFriendInteractor;
    public AddFriendController(AddFriendInputBoundary addFriendInterractor){
        this.addFriendInteractor = addFriendInterractor;
    }
    public void execute(String currentUsername, String wantToAddFriendUsername) throws ExecutionException, InterruptedException, IOException, GeneralSecurityException {
        AddFriendInputData addFriendInputData = new AddFriendInputData(currentUsername, wantToAddFriendUsername);
        this.addFriendInteractor.execute(addFriendInputData);
    }
}
