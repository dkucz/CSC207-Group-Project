package menu.interface_adapter;
import entity.User;
public class MenuState
{
    private User currentUser;

    public MenuState(MenuState copy){
        currentUser = copy.currentUser;
    }

    public MenuState(){}

    public void setUser(User u){
        this.currentUser = u;
    }

    public String getGmail(){
        return this.currentUser.getGmail();
    }

    public String getUsername(){
        return this.currentUser.getUsername();
    }

}
