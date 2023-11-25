package Friend.interface_adapter;

import Friend.app.FriendUseCaseFactory;
import Friend.use_case.FriendInputBoundary;
import Friend.use_case.FriendInputData;
import Friend.view.FriendView;
import Friend.view.FriendViewManager;

public class FriendController {
    private final FriendInputBoundary friendInteractor;
    public FriendController(FriendInputBoundary FriendInputBoundary){
        this.friendInteractor = FriendInputBoundary;
    }
    public void execute(String gmail){
        FriendInputData friendInputData = new FriendInputData(gmail);
        friendInteractor.execute(friendInputData);
    }
    public static void main(String[] args) {
        FriendViewManagerModel viewManagerModel = new FriendViewManagerModel();
        FriendViewModel viewModel = new FriendViewModel("FRIEND");
        FriendViewManager friendViewManager = new FriendViewManager(viewManagerModel);
        FriendView friendView = new FriendView(viewModel);
        friendViewManager.addView(friendView);
        FriendController friendController = FriendUseCaseFactory.create(viewModel,viewManagerModel);
        friendController.execute("Pranky1247@gmail.com");

    }
}
