package Friend.use_case;

public class ShowFriendInfoInputData {
    private final String friendUsername;
    private final String friendGmail;
    public ShowFriendInfoInputData(String friendUsername, String friendGamil){
        this.friendUsername = friendUsername;
        this.friendGmail = friendGamil;
    }
    public String getFriendUsername() {
        return friendUsername;
    }
    public String getFriendGmail(){
        return friendGmail;
    }
}
