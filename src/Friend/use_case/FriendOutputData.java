package Friend.use_case;

import entity.User;

import java.util.ArrayList;

public class FriendOutputData {
    private String CurrentUserName;
    private ArrayList<User> friendList = new ArrayList<>();
    //private ArrayList<friend> friendList = new ArrayList<>();
    public FriendOutputData(String userName, ArrayList<User> friendList){
        //public FriendOutputData(String userName, ArrayList<friend> friendList){
        this.CurrentUserName = userName;
        this.friendList = friendList;
    }
    public ArrayList<Object> getOutputDataAsAList() {
        ArrayList<Object> outputDataList = new ArrayList<>();
        outputDataList.add(this.CurrentUserName);
        outputDataList.add(this.friendList);
        return outputDataList;
    }
}
