package friend.interface_adapter.friend_page;

import friend.use_case.friend_page.FriendInputBoundary;
import friend.use_case.friend_page.FriendInputData;

import java.util.concurrent.ExecutionException;

public class FriendController {
    private final FriendInputBoundary friendInteractor;

    public FriendController(FriendInputBoundary friendInteractor) {
        this.friendInteractor = friendInteractor;
    }

    public void execute(String userName) throws ExecutionException, InterruptedException {
        FriendInputData friendInputData = new FriendInputData(userName);
        friendInteractor.execute(friendInputData);
    }


}
