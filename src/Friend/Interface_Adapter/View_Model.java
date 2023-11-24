package Friend.Interface_Adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class View_Model {
    private String View_Name;
    public View_Model(String View_Name){
        this.View_Name = View_Name;
    }
    public String Get_View_Name(){
        return this.View_Name;
    }
    public abstract void Fire_Property_Changed();
    public abstract void Add_Property_Change_Listener(PropertyChangeListener x);
}
