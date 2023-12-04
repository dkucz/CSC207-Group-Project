package friend.data_access.DeleteFriend;

import java.util.concurrent.ExecutionException;

public interface DeleteFriendDAOInterface {
    void removeFriend(String userName, String friendName) throws ExecutionException, InterruptedException;
}
