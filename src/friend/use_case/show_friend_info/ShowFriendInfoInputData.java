package friend.use_case.show_friend_info;

public class ShowFriendInfoInputData {
    private final String currentUserName;
    private final String friendUsername;
    private final String friendGmail;
    public ShowFriendInfoInputData(String currentUserName,String friendUsername, String friendGamil){
        this.currentUserName = currentUserName;
        this.friendUsername = friendUsername;
        this.friendGmail = friendGamil;
    }
    public String getCurrentUserName(){
        return this.currentUserName;
    }
    public String getFriendUsername() {
        return friendUsername;
    }
    public String getFriendGmail(){
        return friendGmail;
    }
}
