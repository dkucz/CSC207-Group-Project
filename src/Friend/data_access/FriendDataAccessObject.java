package Friend.data_access;

public class FriendDataAccessObject implements FriendDataAccessInterface {
    private final String iP;
    public FriendDataAccessObject(String iP){
        this.iP = iP;
    }
    @Override
    public boolean existByName(String Gmail) {
        return false;
    }

    @Override
    public void addFriend(String gamil_0, String gamil_1) {

    }
    @Override
    public void deleteFriend(String gmail_0, String gmail_1) {

    }
}
