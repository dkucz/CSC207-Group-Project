package Friend.interface_adapter.FriendPage;

import Friend.app.FriendUseCaseFactory;
import Friend.interface_adapter.AddFriend.AddFriendFailedViewModel;
import Friend.interface_adapter.AddFriend.AddFriendViewModel;
import Friend.interface_adapter.DeleteFriend.DeleteFriendViewModel;
import Friend.interface_adapter.FriendViewManagerModel;
import Friend.interface_adapter.ShowFriendInfo.ShowFriendInfoViewModel;
import Friend.use_case.FriendPage.FriendInputBoundary;
import Friend.use_case.FriendPage.FriendInputData;
import Friend.view.*;
import Friend.view.AddFriend.AddFriendFailedView;
import Friend.view.AddFriend.AddFriendView;
import Friend.view.DeleteFriend.DeleteFriendView;
import Friend.view.FriendPage.FriendView;
import Friend.view.ShowFriendInfo.ShowFriendInfoView;

import java.io.IOException;
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
