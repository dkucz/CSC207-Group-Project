package Friend.interface_adapter;

import entity.User;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class FriendViewModel extends ViewModel {
    private ArrayList<Object> outputDataList = new ArrayList<>();
    private final int width = 350;
    private final int height = 700;
    private final int fontSize = 27;
    private final int userNameWidthRatio = 32;
    private final int userNameHeightRatio = 23;
    private final int firstLineYcoordinate = height/16;
    private final int secondLineYcoordinate = height - (height/8);
    private final Color friendPageBackgroundColour = Color.GRAY;
    private final Color friendListPageBackgroundColour = Color.BLACK;
    private final Color friendPageFontColour = Color.BLACK;
    private final int secondJlayeredPaneHeight = secondLineYcoordinate - firstLineYcoordinate - 1;
    private final int friendButtonWidth = (int) (width * 0.83) ;
    private final int friendButtonHeight = secondJlayeredPaneHeight/5;
    private final int friendButtonGap = 10;
    private final String addFriendButtonLabel = "Add Friend";
    private final int addFriendButtonXValue = (int)(this.width * 0.105);
    private final int addFriendButtonYValue = secondLineYcoordinate + firstLineYcoordinate/4;
    private final int addFriendButtonWidth = (int)(this.width * 0.75);
    private final int addFriendButtonHeight = (int)(firstLineYcoordinate * 0.72);
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public FriendViewModel(String viewName) {
        super(viewName);
    }
    @Override
    public void firePropertyChanged() {
        this.support.firePropertyChange("friendViewPropertyChange",null,this.outputDataList);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener x) {
        this.support.addPropertyChangeListener(x);
    }
    public void setOutputDataList(ArrayList<Object> outputDataList){
        this.outputDataList = outputDataList;
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
    public int getFirstLineYcoordinate(){
        return this.firstLineYcoordinate;
    }
    public int getSecondLineYcoordinate(){
        return this.secondLineYcoordinate;
    }
    public Color getFriendPageBackgroundColour(){
        return this.friendPageBackgroundColour;
    }
    public Color getFriendListPageBackgroundColour(){
        return this.friendListPageBackgroundColour;
    }
    public Color getFriendPageFontColour(){
        return this.friendPageFontColour;
    }
    public int getSecondJlayeredPaneHeight(){
        return this.secondJlayeredPaneHeight;
    }
    public int getFriendButtonHeight(){
        return this.friendButtonHeight;
    }
    public int getFriendButtonWidth(){
        return this.friendButtonWidth;
    }
    public int getFriendButtonGap(){
        return this.friendButtonGap;
    }
    public String getAddFriendButtonLabel(){
        return this.addFriendButtonLabel;
    }

    public int getAddFriendButtonXValue() {
        return this.addFriendButtonXValue;
    }
    public int getAddFriendButtonYValue(){
        return this.addFriendButtonYValue;
    }
    public int getAddFriendButtonWidth(){
        return this.addFriendButtonWidth;
    }
    public int getAddFriendButtonHeight(){
        return this.addFriendButtonHeight;
    }
}
