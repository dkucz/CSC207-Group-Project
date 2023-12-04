package friend.interface_adapter.DeleteFriend;

import friend.use_case.DeleteFriend.DeleteFriendInputBoundary;
import friend.use_case.DeleteFriend.DeleteFriendInputData;

import java.util.concurrent.ExecutionException;

public class DeleteFriendController {
    private final DeleteFriendInputBoundary deleteFriendInteractor;
    public DeleteFriendController(DeleteFriendInputBoundary deleteFriendInteractor){
        this.deleteFriendInteractor = deleteFriendInteractor;
    }
    public void execute(String currentUsername, String friendUsername) throws ExecutionException, InterruptedException {
        DeleteFriendInputData inputData = new DeleteFriendInputData(currentUsername, friendUsername);
        this.deleteFriendInteractor.execute(inputData);
    }
}
