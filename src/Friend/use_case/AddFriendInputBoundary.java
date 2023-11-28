package Friend.use_case;

import data_access.FirestoreDAO;

import java.util.concurrent.ExecutionException;

public interface AddFriendInputBoundary {
    void execute(AddFriendInputData addFriendInputData) throws ExecutionException, InterruptedException;
}
