package menu.interface_adapter;

import menu.use_case.SignoutInputBoundary;
import menu.use_case.SignoutInteractor;

public class SignoutController {


    final SignoutInputBoundary signoutInteractor;



    public SignoutController(SignoutInputBoundary s){

        this.signoutInteractor = s;

    }
    public void execute(){

        signoutInteractor.execute();

    }
}
