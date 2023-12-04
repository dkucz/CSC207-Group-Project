package friend.use_case.DeleteFriend;

public class DeleteFriendInputData {
    String currentUsername;
    String friendUsername;
    public DeleteFriendInputData(String currentUsername, String friendUsername){
        this.currentUsername = currentUsername;
        this.friendUsername = friendUsername;
    }

    public String getCurrentUsername() {
        return currentUsername;
    }
    public String getFriendUsername(){
        return this.friendUsername;
    }
}
