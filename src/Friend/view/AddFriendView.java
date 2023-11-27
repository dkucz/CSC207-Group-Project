package Friend.view;

import Friend.interface_adapter.AddFriendViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddFriendView implements PropertyChangeListener {
    private final AddFriendViewModel addFriendViewModel;
    public AddFriendView(AddFriendViewModel addFriendViewModel){
        this.addFriendViewModel = addFriendViewModel;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
