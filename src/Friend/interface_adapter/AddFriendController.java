package Friend.interface_adapter;

import Friend.use_case.AddFriendInputBoundary;
import Friend.use_case.AddFriendInputData;

public class AddFriendController {
    private final AddFriendInputBoundary addFriendInteractor;
    public AddFriendController(AddFriendInputBoundary addFriendInterractor){
        this.addFriendInteractor = addFriendInterractor;
    }
    public void execute(String currentUsername, String wantToAddFriendUsername){
        AddFriendInputData addFriendInputData = new AddFriendInputData(currentUsername, wantToAddFriendUsername);
        this.addFriendInteractor.execute(addFriendInputData);
    }
}
