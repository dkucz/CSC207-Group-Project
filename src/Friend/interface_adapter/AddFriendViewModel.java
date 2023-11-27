package Friend.interface_adapter;

import Friend.view.FriendViewManager;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AddFriendViewModel extends ViewModel{
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private String currentUsername;
    private FriendViewManager friendViewManager;
    private ArrayList<Object> outputDataList;
    private int width = 410;
    private int height = 250;
    private int fontSize = 35;
    private final Color fontColour = Color.BLACK;
    private final String fontName = "Safari";
    private final String friendUsername = "Friend Username";
    private int StringXValue = width/8;
    private int StringYValue = height/5;
    public AddFriendViewModel(String viewName){
        super(viewName);
    }
    @Override
    public void firePropertyChanged() {
        this.support.firePropertyChange("setUsernameAndManager", null, this.outputDataList);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.support.addPropertyChangeListener(propertyChangeListener);
    }
    public void setCurrentUsername(String currentUsername){
        this.currentUsername = currentUsername;
    }
    public void setFriendViewManager(FriendViewManager friendViewManager){
        this.friendViewManager = friendViewManager;
    }
    public void setOutputDataList(){
        this.outputDataList = new ArrayList<>();
        this.outputDataList.add(this.currentUsername);
        this.outputDataList.add(this.friendViewManager);
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
    public Color getFontColour(){
        return this.fontColour;
    }
    public int getStringXValue(){
        return this.StringXValue;
    }
    public int getStringYValue(){
        return this.StringYValue;
    }
    public String getFontName(){
        return this.fontName;
    }
    public String getFriendUsername(){
        return this.friendUsername;
    }
}
