package friend.app;
import friend.interface_adapter.show_friend_info.ShowFriendInfoController;
import friend.interface_adapter.show_friend_info.ShowFriendInfoPresenter;
import friend.interface_adapter.show_friend_info.ShowFriendInfoViewModel;
import friend.use_case.show_friend_info.ShowFriendInfoInputBoundary;
import friend.use_case.show_friend_info.ShowFriendInfoInteractor;
import friend.use_case.show_friend_info.ShowFriendInfoOutputBoundary;
import friend.view.FriendViewManager;

public class ShowFriendInfoUseCaseFactory {
    public ShowFriendInfoUseCaseFactory(){}
    public static ShowFriendInfoController create(ShowFriendInfoViewModel showFriendInfoViewModel,
                                                  FriendViewManager friendViewManager){
        ShowFriendInfoOutputBoundary showFriendInfoPresenter = new ShowFriendInfoPresenter(showFriendInfoViewModel, friendViewManager);
        ShowFriendInfoInputBoundary showFriendInfoInteractor = new ShowFriendInfoInteractor(showFriendInfoPresenter);
        return new ShowFriendInfoController(showFriendInfoInteractor);
    }
}
