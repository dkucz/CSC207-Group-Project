package friend.data_access.add_friend;

import entity.Friend;
import entity.User;

import java.util.concurrent.ExecutionException;

public interface AddFriendDAOInterface {
    boolean existsByName(String wantToAddFriendUsername) throws ExecutionException, InterruptedException;

    User getUserFromName(String wantToAddFriendUsername) throws ExecutionException, InterruptedException;

    void addFriend(User currentUser, Friend friend) throws ExecutionException, InterruptedException;
}
