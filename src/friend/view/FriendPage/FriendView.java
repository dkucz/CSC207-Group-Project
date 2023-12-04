package friend.view.FriendPage;
import friend.app.ShowFriendInfoUseCaseFactory;
import friend.interface_adapter.FriendPage.FriendViewModel;
import friend.interface_adapter.ShowFriendInfo.ShowFriendInfoViewModel;
import friend.view.FriendViewManager;
import entity.Friend;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class FriendView extends JFrame implements PropertyChangeListener {
    private String userName;
    private ArrayList<Friend> friendList;
    private FriendViewManager friendViewManager;
    private FriendViewModel friendViewModel;
    private JLayeredPane JLayeredPane;
    private JLayeredPane JlayeredPane_1; // Second JlayeredPane to contain all the buttons(Friends.).
    private int width;
    private int height;
    private JButton addFriend;
    private final int xValue; // Those two values exist to make the ShowFriendInfoView looks better.
    private final int yValue;

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
        initializeAddFriendButtons();
        initializeCanvas();
        initializeJLayeredPane();
        this.add(JLayeredPane);
        this.setLocationRelativeTo(null);
        this.xValue = this.getLocation().x;
        this.yValue = this.getLocation().y;
        this.setResizable(false);

    }
    private void initializeAddFriendButtons(){
        this.addFriend = new JButton(friendViewModel.getAddFriendButtonLabel());
        this.addFriend.setBounds(friendViewModel.getAddFriendButtonXValue(),
                friendViewModel.getAddFriendButtonYValue(),
                friendViewModel.getAddFriendButtonWidth(),
                friendViewModel.getAddFriendButtonHeight() );
        this.addFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                friendViewManager.getAddFriendView().getAddFriendViewModel().setCurrentUsername(userName);
                friendViewManager.getAddFriendView().getAddFriendViewModel().setFriendViewManager(friendViewManager);
                friendViewManager.getAddFriendView().getAddFriendViewModel().setOutputDataList();
                friendViewManager.getAddFriendView().getAddFriendViewModel().firePropertyChanged();
                friendViewManager.getFriendViewManagerModel().setActiveView("addFriendView");
                friendViewManager.getFriendViewManagerModel().firePropertyChanged();
            }
        });
    }
    public ArrayList<Friend> getFriendList(){
        return this.friendList;
    }
    public FriendViewModel getFriendViewModel(){
        return this.friendViewModel;
    }
    private void initializeJLayeredPane(){
        this.JLayeredPane = new JLayeredPane();
        this.JLayeredPane.setBounds(0,0,width,height);
        this.JLayeredPane.setBackground(friendViewModel.getFriendPageBackgroundColour());
        this.JLayeredPane.setOpaque(true);
        this.JLayeredPane.add(this.canvas,0);
        this.JLayeredPane.add(this.addFriend,0);
        this.JlayeredPane_1 = new JLayeredPane();//////////////////////////////////////////////////////////

        //Have to plus one in order to show the last button.
        this.JlayeredPane_1.setBackground(friendViewModel.getFriendListPageBackgroundColour());
        this.JlayeredPane_1.setOpaque(true);///////////////////////////////////////////////////////////////
    }
    private void initializeCanvas(){
        this.canvas.setBounds(0,0,width,height);
    }
    private void updateFriendList(){
        int numOfButtons = this.friendList.size();
        this.JlayeredPane_1.setPreferredSize(new Dimension(0,
                ((numOfButtons + 1) * friendViewModel.getFriendButtonHeight()) -
                        friendViewModel.getFriendButtonHeight()/2)); // Just to make it looks better.
        this.JLayeredPane.add(addFriendsAsButtons(JlayeredPane_1),0);
    }
    private JScrollPane addFriendsAsButtons(JLayeredPane JLayeredPane){
        this.JlayeredPane_1.removeAll();
        if(this.friendList == null){
            return new JScrollPane(this.JlayeredPane_1);
        }
        ShowFriendInfoViewModel showFriendInfoViewModel = friendViewManager.
                getShowFriendInfoView().getShowFriendInfoViewModel();
        showFriendInfoViewModel.setxValue(xValue + width);
        showFriendInfoViewModel.setyValue(yValue);

        for(int i = 0; i < friendList.size();i ++){
            String currentUserName = this.userName;
            String friendUsername = friendList.get(i).getUsername();
            String friendGmail = friendList.get(i).getGmail();
            JButton button = new JButton(friendUsername);
            int buttonYCoordinate = (friendViewModel.getFirstLineYcoordinate() - 35)// Just to make it looks better.
                    + i * (friendViewModel.getFriendButtonHeight() + friendViewModel.getFriendButtonGap());
            button.setBounds(10,buttonYCoordinate,
                    friendViewModel.getFriendButtonWidth(),
                    friendViewModel.getFriendButtonHeight());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ShowFriendInfoUseCaseFactory.create(showFriendInfoViewModel,
                            friendViewManager).
                            execute(currentUserName,friendUsername,friendGmail);
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
            this.friendList = (ArrayList<Friend>) outputDataList.get(1);
            this.friendViewManager = (FriendViewManager) outputDataList.get(2);
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
