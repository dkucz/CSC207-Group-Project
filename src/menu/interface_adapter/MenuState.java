package menu.interface_adapter;
import entity.User;
public class MenuState
{
    private User currentUser;

    private String username;

    public MenuState(MenuState copy){
        currentUser = copy.currentUser;
    }

    public MenuState(){}

    public void setUser(User u){
        this.currentUser = u;
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public String getGmail(){
        return this.currentUser.getGmail();
    }

    public String getUsername(){
        return this.currentUser.getUsername();
    }

    public void setUsername(String username){this.username = username;}

}
