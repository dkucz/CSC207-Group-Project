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

        DeleteFriendViewModel deleteFriendViewModel = new DeleteFriendViewModel("DeleteFriendView");
        DeleteFriendView deleteFriendView = new DeleteFriendView(deleteFriendViewModel);

        friendViewManager.addView(friendView);
        friendViewManager.addView(showFriendInfoView);
        friendViewManager.addView(addFriendView);
        friendViewManager.addView(addFriendFailedView);
        friendViewManager.addView(deleteFriendView);

        FriendController friendController = FriendUseCaseFactory.create(friendviewModel,friendViewManager);
        //


        // For Testing.
//        FirestoreDAO firestoreDAO = new FirestoreDAO();
//        User U0 = new User("Pranky0", "Password0", "Pranky12470");
//        User U1 = new User("Pranky1", "Password1", "Pranky12471");
//        User U2 = new User("Pranky2", "Password2", "Pranky12472");
//        User U3 = new User("Pranky3", "Password3", "Pranky12473");
//        User U4 = new User("Pranky4", "Password4", "Pranky12474");
//        User U5 = new User("Pranky5", "Password5", "Pranky12475");
//        firestoreDAO.save(U0);
//        firestoreDAO.save(U1);
//        firestoreDAO.save(U2);
//        firestoreDAO.save(U3);
//        firestoreDAO.save(U4);
//        firestoreDAO.save(U5);

        friendController.execute("Pranky1");
    }
}
