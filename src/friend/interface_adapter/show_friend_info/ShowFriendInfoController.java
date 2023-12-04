package friend.interface_adapter.show_friend_info;

import friend.use_case.show_friend_info.ShowFriendInfoInputBoundary;
import friend.use_case.show_friend_info.ShowFriendInfoInputData;

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
