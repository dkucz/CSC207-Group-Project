package addFriend.User_Case;

public interface addFriend_Output_Boundary {
    void prepareSuccessView(addFriend_Output_Data addFriend_Output_Data);

    void prepareFailView(String error);
}
