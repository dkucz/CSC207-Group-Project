package Friend.view;

import Friend.interface_adapter.FriendViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FriendView extends JFrame implements PropertyChangeListener {
    private FriendViewModel friendViewModel;
    private JLayeredPane JLayeredPane;
    public FriendView(FriendViewModel friendViewModel){
        this.friendViewModel = friendViewModel;
        friendViewModel.addPropertyChangeListener(this);
        this.setSize(500,1000);
        this.setLocationRelativeTo(null);
        initializeJLayeredPane();
        this.add(JLayeredPane);
    }
    private void initializeJLayeredPane(){
        this.JLayeredPane = new JLayeredPane();
        this.JLayeredPane.setBounds(0,0,500,1000);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
