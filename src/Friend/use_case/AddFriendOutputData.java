package Friend.use_case;

public class AddFriendOutputData {
    String currentUserName;
    String wantToAddFriendUsername;
    String wantToAddFriendGmail;
    boolean friendDoesNotExist;
    boolean friendAlreadyInList;
    public AddFriendOutputData(String currentUserName, String wantToAddFriendUsername, String wantToADdFriendGmail, boolean friendDoesNotExist, boolean friendAlreadyInList){
        this.currentUserName = currentUserName;
        this.wantToAddFriendUsername = wantToAddFriendUsername;
        this.wantToAddFriendGmail = wantToADdFriendGmail;
        this.friendDoesNotExist = friendDoesNotExist;
        this.friendAlreadyInList = friendAlreadyInList;
    }
    public String getCurrentUserName() {
        return currentUserName;
    }
    public String getWantToAddFriendUsername(){
        return this.wantToAddFriendUsername;
    }
    public String getWantToADdFriendGmail(){
        return this.wantToAddFriendGmail;
    }
    public boolean isFriendDoesNotExist() {
        return friendDoesNotExist;
    }
    public boolean isFriendAlreadyInList() {
        return friendAlreadyInList;
    }

}
