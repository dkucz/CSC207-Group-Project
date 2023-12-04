package FriendTest;

import data_access.FirestoreDAO;
import data_access.GoogleCalendarDAO;
import entity.User;
import friend.app.FriendUseCaseFactory;
import friend.data_access.delete_friend.DeleteFriendDAOInterface;
import friend.interface_adapter.FriendViewManagerModel;
import friend.interface_adapter.add_friend.AddFriendFailedViewModel;
import friend.interface_adapter.add_friend.AddFriendPresenter;
import friend.interface_adapter.add_friend.AddFriendViewModel;
import friend.interface_adapter.delete_friend.DeleteFriendPresenter;
import friend.interface_adapter.delete_friend.DeleteFriendViewModel;
import friend.interface_adapter.friend_page.FriendController;
import friend.interface_adapter.friend_page.FriendViewModel;
import friend.interface_adapter.show_friend_info.ShowFriendInfoViewModel;
import friend.use_case.add_friend.AddFriendInputData;
import friend.use_case.add_friend.AddFriendInteractor;
import friend.use_case.add_friend.AddFriendOutputBoundary;
import friend.use_case.delete_friend.DeleteFriendInputData;
import friend.use_case.delete_friend.DeleteFriendInteractor;
import friend.use_case.delete_friend.DeleteFriendOutputBoundary;
import friend.view.FriendViewManager;
import friend.view.add_friend.AddFriendFailedView;
import friend.view.add_friend.AddFriendView;
import friend.view.delete_friend.DeleteFriendView;
import friend.view.friend_page.FriendView;
import friend.view.show_friend_info.ShowFriendInfoView;
import menu.view.MenuView;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import javax.swing.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

public class FriendPageTest {
    @BeforeAll
    public static void setUp(){

    }
    @Test
    public void testFriendPageView() throws IOException, ExecutionException, InterruptedException {
        JFrame friendPageView = null;
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
        friendController.execute("Username");
        friendPageView = friendViewManager.getFriendView();
        assert friendPageView != null;
    }
    @Test
    public void testAddFriendView() throws ExecutionException, InterruptedException, IOException {
        JFrame addFriendView_0 = null;
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
        friendController.execute("Username");
        addFriendView_0 = friendViewManager.getAddFriendView();
        assert addFriendView_0 != null;
    }
    @Test
    public void testDeleteFriendView() throws ExecutionException, InterruptedException, IOException {
        JFrame deleteFriendView_0 = null;
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
        friendController.execute("Username");
        deleteFriendView_0 = friendViewManager.getDeleteFriendView();
        assert deleteFriendView_0 != null;
    }
    @Test
    public void testAddFriendInteractor() throws IOException, ExecutionException, InterruptedException, GeneralSecurityException {
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        GoogleCalendarDAO googleCalendarDAO = new GoogleCalendarDAO();
        User user_0 = new User("Pranky_0", "Pranky7421.", "Pranky1247@gmail.com");
        User user_1 = new User("Pranky_1", "Pranky7421.", "Pranky12471@gmail.com");
        firestoreDAO.save(user_0);
        firestoreDAO.save(user_1);

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

        AddFriendOutputBoundary addFriendPresenter = new AddFriendPresenter(friendViewManager);
        AddFriendInteractor addFriendInteractor = new AddFriendInteractor(addFriendPresenter,firestoreDAO,googleCalendarDAO);
        AddFriendInputData addFriendInputData = new AddFriendInputData("Pranky_0","Pranky_1");
        addFriendInteractor.execute(addFriendInputData);
        addFriendInteractor.execute(addFriendInputData);

        assert  firestoreDAO.getFriendsAsList("Pranky_0").get(0).getUsername().equals("Pranky_1");

    }
    @Test
    public void testDeleteFriendInteractor() throws GeneralSecurityException, IOException, ExecutionException, InterruptedException {
        FirestoreDAO firestoreDAO = new FirestoreDAO();
        GoogleCalendarDAO googleCalendarDAO = new GoogleCalendarDAO();
        User user_0 = new User("Pranky_0", "Pranky7421.", "Pranky1247@gmail.com");
        User user_1 = new User("Pranky_1", "Pranky7421.", "Pranky12471@gmail.com");
        firestoreDAO.save(user_0);
        firestoreDAO.save(user_1);

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

        AddFriendOutputBoundary addFriendPresenter = new AddFriendPresenter(friendViewManager);
        AddFriendInteractor addFriendInteractor = new AddFriendInteractor(addFriendPresenter,firestoreDAO,googleCalendarDAO);
        AddFriendInputData addFriendInputData = new AddFriendInputData("Pranky_0","Pranky_1");
        addFriendInteractor.execute(addFriendInputData);

        DeleteFriendDAOInterface fireStore = new FirestoreDAO();
        DeleteFriendOutputBoundary deleteFriendPresenter = new DeleteFriendPresenter(friendViewManager);
        DeleteFriendInteractor deleteFriendInteractor = new DeleteFriendInteractor(deleteFriendPresenter, fireStore);
        deleteFriendInteractor.execute(new DeleteFriendInputData("Pranky_1", "Pranky_0"));


        assert  firestoreDAO.getFriendsAsList("Pranky_0").size() == 0;

    }

}
