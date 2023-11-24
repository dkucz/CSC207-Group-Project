package Friend.Interface_Adapter;

import Friend.Use_Case.Friend_Input_Boundary;
import Friend.Use_Case.Friend_Input_Data;

public class Friend_Controller {
    private final Friend_Input_Boundary Friend_Interactor;
    public Friend_Controller(Friend_Input_Boundary x){
        this.Friend_Interactor = x;
    }
    public void excute(String Gmail){
        Friend_Input_Data x = new Friend_Input_Data(Gmail);
        Friend_Interactor.excute(x);
    }
}
