package friend.interface_adapter.delete_friend;

import friend.use_case.delete_friend.DeleteFriendInputBoundary;
import friend.use_case.delete_friend.DeleteFriendInputData;

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
