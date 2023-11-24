package Friend.Interface_Adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Friend_View_Model extends View_Model{
    private final PropertyChangeSupport Support = new PropertyChangeSupport(this);
    public Friend_View_Model(String View_Name) {
        super(View_Name);
    }
    @Override
    public void Fire_Property_Changed() {
        this.Support.firePropertyChange("PC_00",null,"");
    }

    @Override
    public void Add_Property_Change_Listener(PropertyChangeListener x) {
        this.Support.addPropertyChangeListener(x);
    }
}
