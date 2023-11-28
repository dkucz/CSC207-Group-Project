package Friend.use_case.FriendPage;

import Friend.interface_adapter.FriendViewManagerModel;
import Friend.view.FriendViewManager;
import entity.User;
import entity.Friend;
import java.util.ArrayList;

public class FriendOutputData {
    private ArrayList<Friend> friendList = new ArrayList<>();
    private final String CurrentUserName;
    private final FriendViewManager friendViewManager;
    public FriendOutputData(String userName, ArrayList<Friend> friendList, FriendViewManager friendViewManager){
        this.CurrentUserName = userName;
        this.friendList = friendList;
        this.friendViewManager = friendViewManager;
    }
    public ArrayList<Object> getOutputDataAsAList() {
        ArrayList<Object> outputDataList = new ArrayList<>();
        outputDataList.add(this.CurrentUserName);
        outputDataList.add(this.friendList);
        outputDataList.add(this.friendViewManager);
        return outputDataList;
    }
}
