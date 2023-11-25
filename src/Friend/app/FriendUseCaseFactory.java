package Friend.app;
import Friend.interface_adapter.FriendController;
import Friend.interface_adapter.FriendPresenter;
import Friend.interface_adapter.FriendViewManagerModel;
import Friend.interface_adapter.FriendViewModel;
import Friend.use_case.FriendInputBoundary;
import Friend.use_case.FriendInteractor;
import Friend.data_access.FriendDataAccessInterface;
import Friend.data_access.FriendDataAccessObject;
public class FriendUseCaseFactory {
    public FriendUseCaseFactory(){}
    public static FriendController create(FriendViewModel friendViewModel, FriendViewManagerModel friendViewManagerModel){
        FriendDataAccessInterface Friend_Data_Access_Object = new FriendDataAccessObject("002.11.2.3.11");
        FriendPresenter FriendPresenter = new FriendPresenter(friendViewModel,friendViewManagerModel);
        FriendInputBoundary friendInputBoundary = new FriendInteractor(FriendPresenter,Friend_Data_Access_Object);
        return new FriendController(friendInputBoundary);
    }
}
