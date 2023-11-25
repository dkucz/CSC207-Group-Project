package Friend.interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FriendViewModel extends ViewModel {
    private String currentUserName;
    private final int width = 350;
    private final int height = 700;
    private final int fontSize = 27;
    private final int userNameWidthRatio = 32;
    private final int userNameHeightRatio = 32;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public FriendViewModel(String viewName) {
        super(viewName);
    }
    @Override
    public void firePropertyChanged() {
        this.support.firePropertyChange("friendViewUsername",null,this.currentUserName);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener x) {
        this.support.addPropertyChangeListener(x);
    }
    public String getCurrentUserName(){
        return this.currentUserName;
    }
    public void setCurrentUserName(String userName){
        this.currentUserName = userName;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public int getFontSize(){
        return this.fontSize;
    }
    public int getUserNameWidthRatio(){
        return this.userNameWidthRatio;
    }
    public int getUserNameHeightRatio(){
        return this.userNameHeightRatio;
    }
}
