package Friend.dataAccess;

public class Friend_Data_Access_Object implements Friend_Data_Access_Interface{
    private String IP;
    public Friend_Data_Access_Object(String IP){
        this.IP = IP;
    }
    @Override
    public boolean Exist_By_Name(String Gmail) {
        return false;
    }

    @Override
    public void Add_Friend(String Gamil_0, String Gamil_1) {

    }
    @Override
    public void Delete_Friend(String Gmail_0, String Gmail_1) {

    }
}
