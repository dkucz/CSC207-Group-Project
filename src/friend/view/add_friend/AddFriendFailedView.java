package friend.view.add_friend;

import friend.interface_adapter.add_friend.AddFriendFailedViewModel;

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
            g.setFont(new Font("Safari", Font.BOLD,15));
            g.drawString(errorMessage, width/7,(int)(height * 0.41));
        }
    };
    public AddFriendFailedView(AddFriendFailedViewModel addFriendFailedViewModel){
        this.addFriendFailedViewModel = addFriendFailedViewModel;
        addFriendFailedViewModel.addPropertyChangeListener(this);
        this.width = addFriendFailedViewModel.getWidth();
        this.height = addFriendFailedViewModel.getHeight();
        this.setSize(width,height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.canvas.setBounds(0,0,width,height);
        this.add(this.canvas);
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
