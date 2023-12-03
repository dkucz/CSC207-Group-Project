package entity;

public class FriendFactory {
    public Friend create(String username, String gmail)
    {
        Friend friend = new Friend(username);
        friend.setGmail(gmail);
        return friend;
    }
}
