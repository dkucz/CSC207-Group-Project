package friend.interface_adapter.ShowFriendInfo;

import friend.use_case.ShowFriendInfo.ShowFriendInfoInputBoundary;
import friend.use_case.ShowFriendInfo.ShowFriendInfoInputData;

public class ShowFriendInfoController {
    private final ShowFriendInfoInputBoundary showFriendInfoInteractor;
    public ShowFriendInfoController(ShowFriendInfoInputBoundary showFriendInfoInteractor){
        this.showFriendInfoInteractor = showFriendInfoInteractor;
    }
    public void execute(String currentUserName,String friendUsername, String friendGmail) {
        ShowFriendInfoInputData showFriendInfoInputData= new ShowFriendInfoInputData(currentUserName,friendUsername,friendGmail);
        this.showFriendInfoInteractor.execute(showFriendInfoInputData);
    }
}
