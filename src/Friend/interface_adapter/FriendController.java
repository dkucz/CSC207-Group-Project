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
    public static void main(String[] args) throws IOException {
        //The following codes should be moved to the actionPerformed method body of menu button "Friend".
        FriendViewManagerModel friendViewManagerModel = new FriendViewManagerModel();
        FriendViewManager friendViewManager = new FriendViewManager(friendViewManagerModel);

        FriendViewModel friendviewModel = new FriendViewModel("FriendView");
        FriendView friendView = new FriendView(friendviewModel);

        ShowFriendInfoViewModel  showFriendInfoViewModel= new ShowFriendInfoViewModel("ShowFriendInfoView");
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
        friendController.execute("Pranky124777");
        //
    }
}
