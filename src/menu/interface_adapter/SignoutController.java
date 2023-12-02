package menu.interface_adapter;

import menu.use_case.SignoutInteractor;

public class SignoutController {


    final SignoutInteractor signoutInteractor;



    public SignoutController(SignoutInteractor s){

        this.signoutInteractor = s;

    }
    public void execute(){

        signoutInteractor.execute();

    }
}
