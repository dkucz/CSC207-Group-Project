package Friend.use_case;

public class FriendOutputData {
    private String CurrentUserName;
    public FriendOutputData(String userName){
        this.CurrentUserName = userName;
    }
    public String getCurrentUserName() {
        return CurrentUserName;
    }
}
