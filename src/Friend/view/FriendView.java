package Friend.view;

import Friend.interface_adapter.FriendViewModel;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class FriendView extends JFrame implements PropertyChangeListener {
    private String userName;
    private ArrayList<User> friendList;
    private FriendViewModel friendViewModel;
    private JLayeredPane JLayeredPane;
    private JLayeredPane JlayeredPane_1; // Second JlayeredPane to contain all the buttons(Friends.).
    private int width;
    private int height;
    private JButton addFriend;

    private final Canvas canvas = new Canvas(){
        @Override
        public void paint(Graphics g){
            g.setFont(new Font("Serif",Font.BOLD,friendViewModel.getFontSize()));
            g.setColor(friendViewModel.getFriendPageFontColour());
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
        initializeButtons();
        initializeCanvas();
        initializeJLayeredPane();
        this.add(JLayeredPane);
    }
    private void initializeButtons(){
        this.addFriend = new JButton(friendViewModel.getAddFriendButtonLabel());
        this.addFriend.setBounds(this.width, friendViewModel.getSecondLineYcoordinate()+ 20,
                (int)(width * 0.75), 20);
        this.addFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    private void initializeJLayeredPane(){
        this.JLayeredPane = new JLayeredPane();
        this.JLayeredPane.setBounds(0,0,width,height);
        this.JLayeredPane.setBackground(friendViewModel.getFriendPageBackgroundColour());
        this.JLayeredPane.setOpaque(true);
        this.JLayeredPane.add(this.canvas,0);
        this.JLayeredPane.add(this.addFriend,0);
    }
    private void initializeCanvas(){
        this.canvas.setBounds(0,0,width,height);
    }
    private void updateFriendList(){
        this.JlayeredPane_1 = new JLayeredPane();
        int numOfButtons = this.friendList.size();
        this.JlayeredPane_1.setPreferredSize(new Dimension(0,
                (numOfButtons + 1) * friendViewModel.getFriendButtonHeight()));


        //Have to plus one in order to show the last button.
        this.JlayeredPane_1.setBackground(friendViewModel.getFriendListPageBackgroundColour());
        this.JlayeredPane_1.setOpaque(true);
        this.JLayeredPane.add(addFriendsAsButtons(JlayeredPane_1),0);
    }
    private JScrollPane addFriendsAsButtons(JLayeredPane JLayeredPane){
        if(this.friendList == null){
            return new JScrollPane();
        }
        for(int i = 0; i < friendList.size();i ++){
            JButton button = new JButton(friendList.get(i).getUsername());
            int buttonYCoordinate = (friendViewModel.getFirstLineYcoordinate() - 35)// Just to make it looks better.
                    + i * (friendViewModel.getFriendButtonHeight() + friendViewModel.getFriendButtonGap());
            button.setBounds(10,buttonYCoordinate,
                    friendViewModel.getFriendButtonWidth(),
                    friendViewModel.getFriendButtonHeight());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            JLayeredPane.add(button,0);
        }
        JScrollPane scrollPane = new JScrollPane(JLayeredPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0,friendViewModel.getFirstLineYcoordinate() + 1,width - 20, // Have to minus 20 in
                friendViewModel.getSecondJlayeredPaneHeight());                          // order to show the bar.
        return scrollPane;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("friendViewPropertyChange")){
            ArrayList<Object> outputDataList = (ArrayList<Object>) evt.getNewValue();
            this.userName = (String) outputDataList.get(0);
            this.friendList = (ArrayList<User>) outputDataList.get(1);
            updateFriendList();
        }
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
}
