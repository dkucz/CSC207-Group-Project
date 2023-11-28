package Friend.use_case;

import java.util.concurrent.ExecutionException;

public interface FriendInputBoundary {
    void execute(FriendInputData x) throws ExecutionException, InterruptedException;
}
