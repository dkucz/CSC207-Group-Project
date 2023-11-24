package Friend.View;

import Friend.Interface_Adapter.Friend_View_Manager_Model;
import Friend.Interface_Adapter.Friend_View_Model;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Friend_View extends JFrame implements PropertyChangeListener {
    private Friend_View_Model Friend_View_Model;
    private JLayeredPane LP;
    public Friend_View(Friend_View_Model x){
        this.Friend_View_Model = x;
        x.Add_Property_Change_Listener(this);
        this.setSize(500,1000);
        this.setLocationRelativeTo(null);
        I_LP();
        this.add(LP);
    }
    private void I_LP(){
        this.LP = new JLayeredPane();
        this.LP.setBounds(0,0,500,1000);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
