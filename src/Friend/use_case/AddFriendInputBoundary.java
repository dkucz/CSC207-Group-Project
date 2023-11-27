package Friend.use_case;

import data_access.FirestoreDAO;

public interface AddFriendInputBoundary {
    void execute(AddFriendInputData addFriendInputData);
}
