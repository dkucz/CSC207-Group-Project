package FriendPageTest;

import friend.app.FriendUseCaseFactory;
import friend.interface_adapter.FriendViewManagerModel;
import friend.interface_adapter.add_friend.AddFriendFailedViewModel;
import friend.interface_adapter.add_friend.AddFriendViewModel;
import friend.interface_adapter.delete_friend.DeleteFriendViewModel;
import friend.interface_adapter.friend_page.FriendController;
import friend.interface_adapter.friend_page.FriendViewModel;
import friend.interface_adapter.show_friend_info.ShowFriendInfoViewModel;
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

}
