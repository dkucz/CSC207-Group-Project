package Friend.view;

import Friend.interface_adapter.FriendViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FriendView extends JFrame implements PropertyChangeListener {
    private FriendViewModel friendViewModel;
    private JLayeredPane JLayeredPane;
    private JLayeredPane JlayeredPane_1; // Second JlayeredPane to contain all the buttons(Friends.).
    private int width;
    private int height;
    private String userName;
    private final Canvas canvas = new Canvas(){
        @Override
        public void paint(Graphics g){
            g.setFont(new Font("Serif",Font.BOLD,friendViewModel.getFontSize()));
            g.drawString(userName, width/friendViewModel.getUserNameWidthRatio(),
                    height/friendViewModel.getUserNameHeightRatio());
            g.drawLine(0,friendViewModel.getFirstLineYcoordinate(),width,friendViewModel.getFirstLineYcoordinate());
            g.drawLine(0, friendViewModel.getSecondLineYcoordinate(),width,friendViewModel.getSecondLineYcoordinate());
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
        this.JLayeredPane.add(this.canvas,0);
        this.JlayeredPane_1 = new JLayeredPane();
        this.JlayeredPane_1.setBounds(0,friendViewModel.getFirstLineYcoordinate()+ 1,width,
                friendViewModel.getSecondLineYcoordinate() - friendViewModel.getFirstLineYcoordinate());
        //this.JlayeredPane_1.setBackground(Color.PINK);
        //this.JlayeredPane_1.setForeground(Color.BLUE);
        this.JlayeredPane_1.setOpaque(true);
        this.JLayeredPane.add(JlayeredPane_1,0);
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
