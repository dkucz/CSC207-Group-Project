package Friend.use_case;

public class AddFriendOutputData {
    String currentUserName;
    String wantToAddFriendUsername;
    String wantToADdFriendGmail;
    public AddFriendOutputData(String currentUserName, String wantToAddFriendUsername, String wantToADdFriendGmail){
        this.currentUserName = currentUserName;
        this.wantToAddFriendUsername = wantToAddFriendUsername;
        this.wantToADdFriendGmail = wantToADdFriendGmail;
    }
    public String getCurrentUserName() {
        return currentUserName;
    }
    public String getWantToAddFriendUsername(){
        return this.wantToAddFriendUsername;
    }
    public String getWantToADdFriendGmail(){
        return this.wantToADdFriendGmail;
    }
}
