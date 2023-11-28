package Friend.use_case;

import data_access.FirestoreDAO;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface AddFriendInputBoundary {
    void execute(AddFriendInputData addFriendInputData) throws ExecutionException, InterruptedException, IOException;
}
