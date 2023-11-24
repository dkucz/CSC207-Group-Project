package Friend.Use_Case;

import Friend.Interface_Adapter.Friend_Presenter;
import Friend.dataAccess.Friend_Data_Access_Interface;

public class Friend_Interactor implements Friend_Input_Boundary{
    private final Friend_Output_Boundary Friend_Presenter;
    private final Friend_Data_Access_Interface Friend_Data_Access_Object;

    public Friend_Interactor(Friend_Presenter x, Friend_Data_Access_Interface y){
        this.Friend_Presenter = x;
        this.Friend_Data_Access_Object = y;
    }
    @Override
    public void excute(Friend_Input_Data x){
        this.Friend_Presenter.Prepare_Success_View();
    }
}
