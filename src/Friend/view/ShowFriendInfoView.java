package Friend.view;

import Friend.interface_adapter.ShowFriendInfoViewModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ShowFriendInfoView extends JFrame implements PropertyChangeListener {
    private final ShowFriendInfoViewModel showFriendInfoViewModel;
    private String friendUsername;
    private String friendGmail;
    public ShowFriendInfoView(ShowFriendInfoViewModel showFriendInfoViewModel){
        this.showFriendInfoViewModel = showFriendInfoViewModel;
        showFriendInfoViewModel.addPropertyChangeListener(this);
        this.setBounds(0,0,500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public ShowFriendInfoViewModel getShowFriendInfoViewModel() {
        return this.showFriendInfoViewModel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("ShowFriendInfoViewPropertyChange")){
            ArrayList<String> outputDataList = (ArrayList<String>) evt.getNewValue();
            this.friendUsername = outputDataList.get(0);
            this.friendGmail = outputDataList.get(1);
            System.out.println(friendUsername + "   " + friendGmail);
        }
    }
}
