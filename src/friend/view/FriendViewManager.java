package friend.view;

import friend.interface_adapter.FriendViewManagerModel;

import friend.view.add_friend.AddFriendFailedView;
import friend.view.add_friend.AddFriendView;
import friend.view.delete_friend.DeleteFriendView;
import friend.view.friend_page.FriendView;
import friend.view.show_friend_info.ShowFriendInfoView;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class FriendViewManager implements PropertyChangeListener {
    private final FriendViewManagerModel friendViewManagerModel;
    private ArrayList<JFrame> views = new ArrayList<>();
        // Views[0] -> Friend List Page.
        // Views[1] -> Friend Info Page.
        // Views[2] -> AddFriend Page.
        // Views[3] -> AddFriendFailed Page.
        // Views[4] -> DeleteFriend Page.
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
    public FriendView getFriendView(){
        return (FriendView) this.views.get(0);
    }
    public ShowFriendInfoView getShowFriendInfoView(){
        return (ShowFriendInfoView) this.views.get(1);
    }
    public AddFriendView getAddFriendView(){
        return (AddFriendView) this.views.get(2);
    }
    public AddFriendFailedView getAddFriendFailedView(){
        return (AddFriendFailedView) this.views.get(3);
    }
    public DeleteFriendView getDeleteFriendView(){
        return (DeleteFriendView) this.views.get(4);
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("view")){
            if(evt.getNewValue().equals("friendView")){
                this.views.get(0).setVisible(true);
            }else if(evt.getNewValue().equals("showFriendInfoView")){
                this.views.get(2).setVisible(false);
                this.views.get(3).setVisible(false);
                this.views.get(1).setVisible(true);
            }else  if(evt.getNewValue().equals("addFriendView")){
                this.views.get(2).setVisible(true);
            }else  if(evt.getNewValue().equals("addFriendFailedView")){
                this.views.get(3).setVisible(true);
            }else if(evt.getNewValue().equals("deleteFriendView")){
                // this.views.get(1).setVisible(false);
                this.views.get(4).setVisible(true);
            }
        }
    }
}
