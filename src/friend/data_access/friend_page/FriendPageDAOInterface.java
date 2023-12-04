package friend.data_access.friend_page;

import java.util.concurrent.ExecutionException;

public interface FriendPageDAOInterface {
    Object getFriendsAsList(String userName) throws ExecutionException, InterruptedException;
}
