package Friend.dataAccess;
public interface Friend_Data_Access_Interface {
    boolean Exist_By_Name(String Gmail);
    void Add_Friend(String Gamil_0, String Gamil_1); //Add Gmail_1 to Gamil_0's friend list.
    void Delete_Friend(String Gmail_0,String Gmail_1); // Delete Gmail_1 from Gmail_0's friend list.


}
