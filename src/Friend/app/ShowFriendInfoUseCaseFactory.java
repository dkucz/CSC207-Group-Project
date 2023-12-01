package Friend.app;
import Friend.interface_adapter.ShowFriendInfo.ShowFriendInfoController;
import Friend.interface_adapter.ShowFriendInfo.ShowFriendInfoPresenter;
import Friend.interface_adapter.ShowFriendInfo.ShowFriendInfoViewModel;
import Friend.use_case.ShowFriendInfo.ShowFriendInfoInputBoundary;
import Friend.use_case.ShowFriendInfo.ShowFriendInfoInteractor;
import Friend.use_case.ShowFriendInfo.ShowFriendInfoOutputBoundary;
import Friend.view.FriendViewManager;

public class ShowFriendInfoUseCaseFactory {
    public ShowFriendInfoUseCaseFactory(){}
    public static ShowFriendInfoController create(ShowFriendInfoViewModel showFriendInfoViewModel,
                                                  FriendViewManager friendViewManager){
        ShowFriendInfoOutputBoundary showFriendInfoPresenter = new ShowFriendInfoPresenter(showFriendInfoViewModel, friendViewManager);
        ShowFriendInfoInputBoundary showFriendInfoInteractor = new ShowFriendInfoInteractor(showFriendInfoPresenter);
        return new ShowFriendInfoController(showFriendInfoInteractor);
    }
}
