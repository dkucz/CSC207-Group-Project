package Friend.view;

import Friend.interface_adapter.FriendViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FriendView extends JFrame implements PropertyChangeListener {
    private FriendViewModel friendViewModel;
    private JLayeredPane JLayeredPane;
    private int width;
    private int height;
    private String userName;
    private final Canvas canvas = new Canvas(){
        @Override
        public void paint(Graphics g){
            g.setFont(new Font("Serif",Font.BOLD,friendViewModel.getFontSize()));
            g.drawString(userName, width/friendViewModel.getUserNameWidthRatio(),
                    height/friendViewModel.getUserNameHeightRatio());
        }
    };
    public FriendView(FriendViewModel friendViewModel){
        this.friendViewModel = friendViewModel;
        this.width = this.friendViewModel.getWidth();
        this.height = this.friendViewModel.getHeight();
        friendViewModel.addPropertyChangeListener(this);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        initializeCanvas();
        initializeJLayeredPane();
        this.add(JLayeredPane);
    }
    private void initializeJLayeredPane(){
        this.JLayeredPane = new JLayeredPane();
        this.JLayeredPane.setBounds(0,0,width,height);
        this.JLayeredPane.add(this.canvas);
    }
    private void initializeCanvas(){
        this.canvas.setBounds(0,0,width,height);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("friendViewUsername")){
            this.userName = (String) evt.getNewValue();
        }
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
}
