package friend.app;
import friend.interface_adapter.ShowFriendInfo.ShowFriendInfoController;
import friend.interface_adapter.ShowFriendInfo.ShowFriendInfoPresenter;
import friend.interface_adapter.ShowFriendInfo.ShowFriendInfoViewModel;
import friend.use_case.ShowFriendInfo.ShowFriendInfoInputBoundary;
import friend.use_case.ShowFriendInfo.ShowFriendInfoInteractor;
import friend.use_case.ShowFriendInfo.ShowFriendInfoOutputBoundary;
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
