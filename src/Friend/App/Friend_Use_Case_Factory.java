package Friend.App;

import Friend.Interface_Adapter.Friend_Controller;
import Friend.Interface_Adapter.Friend_Presenter;
import Friend.Interface_Adapter.Friend_View_Manager_Model;
import Friend.Interface_Adapter.Friend_View_Model;
import Friend.Use_Case.Friend_Input_Boundary;
import Friend.Use_Case.Friend_Interactor;
import Friend.dataAccess.Friend_Data_Access_Interface;
import Friend.dataAccess.Friend_Data_Access_Object;

public class Friend_Use_Case_Factory {
    public Friend_Use_Case_Factory(){}
    public static Friend_Controller Create(Friend_View_Model x, Friend_View_Manager_Model y){
        Friend_Data_Access_Interface Friend_Data_Access_Object = new Friend_Data_Access_Object("002.11.2.3.11");
        Friend_Presenter P0 = new Friend_Presenter(x,y);
        Friend_Input_Boundary I0 = new Friend_Interactor(P0,Friend_Data_Access_Object);
        return new Friend_Controller(I0);
    }
}
