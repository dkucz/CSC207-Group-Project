package Friend.User_Case;

public class addFriend_Output_Data{
    private final String Targer_User_Username;
    private final String User_To_Be_Added_Username;
    public addFriend_Output_Data(String Targer_User_Username, String User_To_Be_Added_Username){
        this.Targer_User_Username = Targer_User_Username;
        this.User_To_Be_Added_Username = User_To_Be_Added_Username;
    }

    public String get_Targer_User_Username() {
        return Targer_User_Username;
    }

    public String get_User_To_Be_Added_Username() {
        return User_To_Be_Added_Username;
    }
}
