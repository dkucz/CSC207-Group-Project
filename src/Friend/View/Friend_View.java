package Friend.View;

import Friend.Interface_Adapter.Friend_View_Manager_Model;
import Friend.Interface_Adapter.Friend_View_Model;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Friend_View extends JFrame implements PropertyChangeListener {
    private Friend_View_Model Friend_View_Model;
    public Friend_View(Friend_View_Model x){
        this.Friend_View_Model = x;
        x.Add_Property_Change_Listener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
