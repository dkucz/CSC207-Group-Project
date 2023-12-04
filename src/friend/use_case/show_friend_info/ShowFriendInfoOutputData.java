package friend.use_case.show_friend_info;

import friend.view.FriendViewManager;

import java.util.ArrayList;

public class ShowFriendInfoOutputData{
    private final FriendViewManager friendViewManager;
    private final String currentUserName;
    private final String friendUserName;
    private final String friendGmail;
    public ShowFriendInfoOutputData(String currentUserName,String friendUserName, String friendGmail,FriendViewManager friendViewManager){
        this.currentUserName = currentUserName;
        this.friendUserName = friendUserName;
        this.friendGmail = friendGmail;
        this.friendViewManager = friendViewManager;
    }
    public ArrayList<Object> getOutputDataAsAList() {
        ArrayList<Object> outputDataList = new ArrayList<>();
        outputDataList.add(this.currentUserName);
        outputDataList.add(this.friendUserName);
        outputDataList.add(this.friendGmail);
        outputDataList.add(this.friendViewManager);
        return outputDataList;
    }
}
