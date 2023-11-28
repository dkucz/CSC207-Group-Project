package Friend.interface_adapter;

import Friend.app.FriendUseCaseFactory;
import Friend.use_case.FriendInputBoundary;
import Friend.use_case.FriendInputData;
import Friend.use_case.ShowFriendInfoOutputData;
import Friend.view.*;
import data_access.FirestoreDAO;
import entity.User;
import menu.view.MenuView;

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

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        // Copy and paste the following codes.
        FriendViewManagerModel friendViewManagerModel = new FriendViewManagerModel();
        FriendViewManager friendViewManager = new FriendViewManager(friendViewManagerModel);

        FriendViewModel friendviewModel = new FriendViewModel("FriendView");
        FriendView friendView = new FriendView(friendviewModel);

        ShowFriendInfoViewModel showFriendInfoViewModel= new ShowFriendInfoViewModel("ShowFriendInfoView");
        ShowFriendInfoView showFriendInfoView = new ShowFriendInfoView(showFriendInfoViewModel);

        AddFriendViewModel addFriendViewModel = new AddFriendViewModel("AddFriendView");
        AddFriendView addFriendView = new AddFriendView(addFriendViewModel);

        AddFriendFailedViewModel addFriendFailedViewModel= new AddFriendFailedViewModel("AddFriendFailedView");
        AddFriendFailedView addFriendFailedView= new AddFriendFailedView(addFriendFailedViewModel);

        friendViewManager.addView(friendView);
        friendViewManager.addView(showFriendInfoView);
        friendViewManager.addView(addFriendView);
        friendViewManager.addView(addFriendFailedView);

        FriendController friendController = FriendUseCaseFactory.create(friendviewModel,friendViewManager);
        friendController.execute("Pranky");
        //
    }
}
