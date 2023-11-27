package Friend.view;

import Friend.interface_adapter.AddFriendFailedViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddFriendFailedView extends JFrame implements PropertyChangeListener {
    private AddFriendFailedViewModel addFriendFailedViewModel;
    private String errorMessage = "401";
    private int width;
    private int height;

    private Canvas canvas = new Canvas(){
        @Override
        public void paint(Graphics g){
            g.drawString(errorMessage, 200,200);
        }
    };
    public AddFriendFailedView(AddFriendFailedViewModel addFriendFailedViewModel){
        this.addFriendFailedViewModel = addFriendFailedViewModel;
        addFriendFailedViewModel.addPropertyChangeListener(this);
        this.setSize(addFriendFailedViewModel.getWidth(),addFriendFailedViewModel.getHeight());
    }
    public void update(){
        this.canvas.repaint();
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("errorMessage")){
            this.errorMessage = (String) evt.getNewValue();
            update();
        }
    }
    public AddFriendFailedViewModel getAddFriendFailedViewModel(){
        return this.addFriendFailedViewModel;
    }
}
