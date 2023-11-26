package Friend.view;

import Friend.interface_adapter.ShowFriendInfoViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ShowFriendInfoView extends JFrame implements PropertyChangeListener {
    private final ShowFriendInfoViewModel showFriendInfoViewModel;
    private final int width;
    private final int height;
    private String friendUsername;
    private String friendGmail;
    private JLayeredPane jLayeredPane;
    private JButton deleteFriend;
    private Canvas canvas = new Canvas(){
        @Override
        public void paint(Graphics g){
            g.setFont(new Font(showFriendInfoViewModel.getFontName(),
                    Font.BOLD,showFriendInfoViewModel.getFriendUsernameFontSize()));
            g.setColor(Color.black);

            g.drawLine(0,showFriendInfoViewModel.getSecondLineHeightValue(),width,
                    showFriendInfoViewModel.getSecondLineHeightValue());

            g.drawLine(0,showFriendInfoViewModel.getFirstLineHeightValue(),width,
                    showFriendInfoViewModel.getFirstLineHeightValue());

            g.drawString(friendUsername, 0,height/showFriendInfoViewModel.getFriendUsernameYValueRatio());

            g.setFont(new Font(showFriendInfoViewModel.getFontName(),
                    Font.PLAIN,showFriendInfoViewModel.getFriendUsernameFontSize()));

            g.drawString("Gmail: ", 0, showFriendInfoViewModel.getGmailHeightValue());


            g.setFont(new Font(showFriendInfoViewModel.getFontName(), Font.BOLD,
                    (int)(showFriendInfoViewModel.getFriendUsernameFontSize() * 0.6) ));

            g.drawString(friendGmail, 100,showFriendInfoViewModel.getGmailHeightValue() - showFriendInfoViewModel.getFriendUsernameFontSize()/7);
        }
    };
    public ShowFriendInfoView(ShowFriendInfoViewModel showFriendInfoViewModel){
        this.showFriendInfoViewModel = showFriendInfoViewModel;
        this.width = showFriendInfoViewModel.getWidth();
        this.height = showFriendInfoViewModel.getHeight();
        showFriendInfoViewModel.addPropertyChangeListener(this);
        initializeDeleteFriendButton();
        initializeCanvas();
        initializeJlayeredPane();
        this.add(this.jLayeredPane);
        this.setResizable(false);
    }

    public ShowFriendInfoViewModel getShowFriendInfoViewModel() {
        return this.showFriendInfoViewModel;
    }
    private void initializeDeleteFriendButton(){
        this.deleteFriend = new JButton(showFriendInfoViewModel.getDeleteFriendButtonLabel());
        this.deleteFriend.setBounds(showFriendInfoViewModel.getDeleteFriendButtonXValue(),
                showFriendInfoViewModel.getDeleteFriendButtonYValue(),
                showFriendInfoViewModel.getDeleteFriendButtonWidth(),
                showFriendInfoViewModel.getDeleteFriendButtonHeight());
    }
    private void initializeCanvas(){
        this.canvas.setBounds(0,0,width, height);
        this.canvas.setBackground(Color.GRAY);
    }
    private void initializeJlayeredPane(){
        this.jLayeredPane = new JLayeredPane();
        this.jLayeredPane.setBounds(0,0,width,height);
        this.jLayeredPane.add(this.canvas);
        this.jLayeredPane.add(this.deleteFriend, 0);
    }
    private void update(){
        this.canvas.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("ShowFriendInfoViewPropertyChange")){
            ArrayList<String> outputDataList = (ArrayList<String>) evt.getNewValue();
            this.friendUsername = outputDataList.get(0);
            this.friendGmail = outputDataList.get(1);
            update();
        }else if(evt.getPropertyName().equals("ShowFriendInfoViewXYValueChange")){
            this.setBounds(showFriendInfoViewModel.getxValue(),showFriendInfoViewModel.getyValue(),width,height);
        }
    }
}
