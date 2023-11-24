package Friend.Interface_Adapter;

import Friend.App.Friend_Use_Case_Factory;
import Friend.Use_Case.Friend_Input_Boundary;
import Friend.Use_Case.Friend_Input_Data;
import Friend.View.Friend_View;
import Friend.View.Friend_View_Manager;

public class Friend_Controller {
    private final Friend_Input_Boundary Friend_Interactor;
    public Friend_Controller(Friend_Input_Boundary x){
        this.Friend_Interactor = x;
    }
    public void excute(String Gmail){
        Friend_Input_Data x = new Friend_Input_Data(Gmail);
        Friend_Interactor.excute(x);
    }
    public static void main(String[] args) {
        Friend_View_Manager_Model View_Manager_Model = new Friend_View_Manager_Model();
        Friend_View_Model View_Model = new Friend_View_Model("FRIEND");
        Friend_View_Manager y = new Friend_View_Manager(View_Manager_Model);
        Friend_View h = new Friend_View(View_Model);
        Friend_Controller C0 = Friend_Use_Case_Factory.Create(View_Model,View_Manager_Model);
        C0.excute("Pranky1247@gmail.com");

    }
}
