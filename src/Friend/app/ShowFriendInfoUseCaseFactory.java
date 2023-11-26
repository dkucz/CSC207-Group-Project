package Friend.app;
import Friend.interface_adapter.FriendViewManagerModel;
import Friend.interface_adapter.ShowFriendInfoController;
import Friend.interface_adapter.ShowFriendInfoPresenter;
import Friend.interface_adapter.ShowFriendInfoViewModel;
import Friend.use_case.ShowFriendInfoInputBoundary;
import Friend.use_case.ShowFriendInfoInteractor;

public class ShowFriendInfoUseCaseFactory {
    public ShowFriendInfoUseCaseFactory(){}
    public static ShowFriendInfoController create(ShowFriendInfoViewModel showFriendInfoViewModel,
                                                  FriendViewManagerModel friendViewManagerModel){
        ShowFriendInfoPresenter showFriendInfoPresenter = new ShowFriendInfoPresenter(showFriendInfoViewModel, friendViewManagerModel);
        ShowFriendInfoInputBoundary showFriendInfoInteractor = new ShowFriendInfoInteractor(showFriendInfoPresenter);
        return new ShowFriendInfoController(showFriendInfoInteractor);
    }
}
