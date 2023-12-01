package Friend.use_case.AddFriend;

public class AddFriendInputData {
    String currentUsername;
    String wantToAddFriendUsername;
    public AddFriendInputData(String currentUsername, String wantToAddFriendUsername){
        this.currentUsername = currentUsername;
        this.wantToAddFriendUsername = wantToAddFriendUsername;
    }
    public String getCurrentUsername(){
        return this.currentUsername;
    }
    public String getWantToAddFriendUsername(){
        return this.wantToAddFriendUsername;
    }
}
