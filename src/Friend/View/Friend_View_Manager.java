package Friend.View;

import Friend.Interface_Adapter.Friend_View_Manager_Model;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class Friend_View_Manager implements PropertyChangeListener {
    private final Friend_View_Manager_Model Friend_View_Manager_Model;
    private ArrayList<JFrame> Views = new ArrayList<>();
        // Views[0] -> Friend List Page.
        // Views[1] -> Add Friend Page.
    public Friend_View_Manager(Friend_View_Manager_Model x){
        this.Friend_View_Manager_Model = x;
        x.Add_Property_Change_Listener(this);
    }
    public void Add_View(JFrame x){
        this.Views.add(x);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("PC_00")){
            if(evt.getNewValue().equals("FRIEND")){
                this.Views.get(0).setVisible(true);
            }
        }
    }
}
