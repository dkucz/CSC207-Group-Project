package menu.interface_adapter;
import app.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MenuViewModel extends ViewModel{
    public final String TITLE_LABEL = "Menu View";
    public final String FRIENDS_BUTTON_LABEL = "Friends";
    public final String CREATE_EVENT_BUTTON_LABEL = "Create Event";
    public final String MODIFY_EVENT_BUTTON_LABEL = "Modify Event";
    public final String SIGNOUT_BUTTON_LABEL = "Signout";
    private MenuState state = new MenuState();

    public MenuViewModel(){super("menu");}
    public void setState(MenuState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged(){ support.firePropertyChange("state", null, this.state);}
    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);

    }

    public MenuState getState(){
        return state;
    }
}
