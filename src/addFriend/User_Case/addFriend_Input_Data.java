package addFriend.User_Case;

import entity.User;

public class addFriend_Input_Data {
    private final User Target_User;
    private final User User_To_Be_Added;
    public addFriend_Input_Data(User x, User y){
        this.Target_User = x;
        this.User_To_Be_Added = y;
    }
    public User get_Target_User() {
        return this.Target_User;
    }
    public User get_User_To_Be_Added(){
        return this.User_To_Be_Added;
    }
}
