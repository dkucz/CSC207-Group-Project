package Friend.Interface_Adapter;

import Friend.Use_Case.Friend_Output_Boundary;
import Friend.View.Friend_View;

public class Friend_Presenter implements Friend_Output_Boundary {
    private final Friend_View_Model Friend_View_Model;
    private final Friend_View_Manager_Model Friend_View_Manager_Model;
    public Friend_Presenter(Friend_View_Model x, Friend_View_Manager_Model y){
        this.Friend_View_Model = x;
        this.Friend_View_Manager_Model = y;
    }
    @Override
    public void Prepare_Success_View() {
        this.Friend_View_Manager_Model.Set_Active_View("FRIEND");
        this.Friend_View_Manager_Model.Fire_Property_Changed();
    }
}
