package Friend.view;

import Friend.interface_adapter.FriendViewManagerModel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class FriendViewManager implements PropertyChangeListener {
    private final FriendViewManagerModel friendViewManagerModel;
    private ArrayList<JFrame> views = new ArrayList<>();
        // Views[0] -> Friend List Page.
        // Views[1] -> Friend Info Page.
    public FriendViewManager(FriendViewManagerModel friendViewManagerModel){
        this.friendViewManagerModel = friendViewManagerModel;
        friendViewManagerModel.addPropertyChangeListener(this);
    }
    public void addView(JFrame jFrame){
        this.views.add(jFrame);
    }
    public FriendViewManagerModel getFriendViewManagerModel(){
        return this.friendViewManagerModel;
    }
    public ShowFriendInfoView getShowFriendInfoView(){
        return (ShowFriendInfoView) this.views.get(1);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("view")){
            if(evt.getNewValue().equals("Friend")){
                this.views.get(0).setVisible(true);
            }else if(evt.getNewValue().equals("ShowFriendInfoView")){
                this.views.get(1).setVisible(true);
            }
        }
    }
}
