package Friend.Interface_Adapter;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Friend_View_Manager_Model {
    private String Active_View;
    private final PropertyChangeSupport Support = new PropertyChangeSupport(this);
    public void Fire_Property_Changed(){
        this.Support.firePropertyChange("PC_00",null,this.Active_View);
    }
    public void Add_Property_Change_Listener(PropertyChangeListener x){
        this.Support.addPropertyChangeListener(x);
    }
    public void Set_Active_View(String view){
        this.Active_View = view;
    }
    public String Get_Active_View(){
        return this.Active_View;
    }

}
