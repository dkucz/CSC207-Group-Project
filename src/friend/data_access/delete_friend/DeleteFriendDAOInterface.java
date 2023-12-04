package friend.data_access.delete_friend;

import java.util.concurrent.ExecutionException;

public interface DeleteFriendDAOInterface {
    void removeFriend(String userName, String friendName) throws ExecutionException, InterruptedException;
}
