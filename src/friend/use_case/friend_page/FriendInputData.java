package friend.use_case.friend_page;

public class FriendInputData {
    private String userName;
    public FriendInputData(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
}
