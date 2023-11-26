package Friend.interface_adapter;

import Friend.use_case.ShowFriendInfoInputBoundary;
import Friend.use_case.ShowFriendInfoInputData;

public class ShowFriendInfoController {
    private final ShowFriendInfoInputBoundary showFriendInfoInteractor;
    public ShowFriendInfoController(ShowFriendInfoInputBoundary showFriendInfoInteractor){
        this.showFriendInfoInteractor = showFriendInfoInteractor;
    }
    public void execute(String friendUsername, String friendGmail) {
        ShowFriendInfoInputData showFriendInfoInputData= new ShowFriendInfoInputData(friendUsername,friendGmail);
        this.showFriendInfoInteractor.execute(showFriendInfoInputData);
    }
}
