package addFriend.Interface_Adapter;

import addFriend.User_Case.addFriend_Output_Boundary;
import addFriend.User_Case.addFriend_Output_Data;

public class addFriend_Presenter implements addFriend_Output_Boundary {
    @Override
    public void prepareSuccessView(addFriend_Output_Data addFriend_Output_Data) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
