package Friend.app;
import Friend.interface_adapter.FriendViewManagerModel;
import Friend.interface_adapter.ShowFriendInfoController;
import Friend.interface_adapter.ShowFriendInfoPresenter;
import Friend.interface_adapter.ShowFriendInfoViewModel;
import Friend.use_case.ShowFriendInfoInputBoundary;
import Friend.use_case.ShowFriendInfoInteractor;
import Friend.view.FriendViewManager;

public class ShowFriendInfoUseCaseFactory {
    public ShowFriendInfoUseCaseFactory(){}
    public static ShowFriendInfoController create(ShowFriendInfoViewModel showFriendInfoViewModel,
                                                  FriendViewManager friendViewManager){
        ShowFriendInfoPresenter showFriendInfoPresenter = new ShowFriendInfoPresenter(showFriendInfoViewModel, friendViewManager);
        ShowFriendInfoInputBoundary showFriendInfoInteractor = new ShowFriendInfoInteractor(showFriendInfoPresenter);
        return new ShowFriendInfoController(showFriendInfoInteractor);
    }
}
