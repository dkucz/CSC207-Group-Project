package Friend.data_access.FriendPage;

import java.util.concurrent.ExecutionException;

public interface FriendPageDAOInterface {
    Object getFriendsAsList(String userName) throws ExecutionException, InterruptedException;
}
