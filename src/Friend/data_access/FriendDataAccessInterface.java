package Friend.data_access;
public interface FriendDataAccessInterface {
    boolean existByName(String gmail);
    void addFriend(String gamil_0, String gamil_1); //Add Gmail_1 to Gmail_0's friend list.
    void deleteFriend(String gmail_0,String gmail_1); // Delete Gmail_1 from Gmail_0's friend list.

}
