package Friend.use_case.FriendPage;

import java.util.concurrent.ExecutionException;

public interface FriendInputBoundary {
    void execute(FriendInputData x) throws ExecutionException, InterruptedException;
}
