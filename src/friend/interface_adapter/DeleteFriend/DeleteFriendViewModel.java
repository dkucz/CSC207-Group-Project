package friend.interface_adapter.DeleteFriend;

import friend.interface_adapter.ViewModel;
import friend.view.FriendViewManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class DeleteFriendViewModel extends ViewModel {
    private String viewName;
    private ArrayList<Object> outputDataList; // [0] -> Width. [1] -> Height. [2] -> Message. [3] -> deleteFriendCompleted. [4] -> FriendViewManager. [5] -> DeletedFriendUsername. [6] -> CurrentUsername.
    private int width;
    private int height;
    private String message;
    private boolean deleteFriendCompleted;
    private FriendViewManager friendViewManager;
    private String deletedFriendUsername;
    private String currentUsername;
    private int fontSize = 32;
    private int askingMessageXValue;
    private int askingMessageYValue;
    private int deletedFriendUsernameXValue;
    private int deletedFriendUsernameYValue;
    private int resultMessageXValue;
    private int resultMessageYValue;
    private int canvasWidth;
    private int canvasHeight;
    private int yesButtonXValue;
    private int yesButtonYValue;
    private int yesButtonWidth;
    private int yesButtonHeight;
    private int noButtonXValue;
    private int noButtonYValue;
    private int noButtonWidth;
    private int noButtonHeight;
    private int okButtonXValue;
    private int okButtonYValue;
    private int okButtonWidth;
    private int okButtonHeight;
    private String fontName = "Safari";

    public String getFontName() {
        return fontName;
    }

    public int getOkButtonXValue() {
        return okButtonXValue;
    }

    public int getOkButtonYValue() {
        return okButtonYValue;
    }

    public int getOkButtonWidth() {
        return okButtonWidth;
    }

    public int getOkButtonHeight() {
        return okButtonHeight;
    }

    public int getNoButtonXValue() {
        return noButtonXValue;
    }

    public int getNoButtonYValue() {
        return noButtonYValue;
    }

    public int getNoButtonWidth() {
        return noButtonWidth;
    }

    public int getNoButtonHeight() {
        return noButtonHeight;
    }

    public int getYesButtonXValue() {
        return yesButtonXValue;
    }

    public int getYesButtonYValue() {
        return yesButtonYValue;
    }

    public int getYesButtonWidth() {
        return yesButtonWidth;
    }

    public int getYesButtonHeight() {
        return yesButtonHeight;
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public int getResultMessageXValue() {
        return resultMessageXValue;
    }

    public int getResultMessageYValue() {
        return resultMessageYValue;
    }

    public int getDeletedFriendUsernameXValue() {
        return deletedFriendUsernameXValue;
    }

    public int getDeletedFriendUsernameYValue() {
        return deletedFriendUsernameYValue;
    }

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public DeleteFriendViewModel(String viewName){
        super(viewName);
    }
    @Override
    public void firePropertyChanged () {
        this.support.firePropertyChange("outputData",null, this.outputDataList);
    }
    public int getFontSize(){
        return this.fontSize;
    }
    public int getAskingMessageXValue(){
        return this.askingMessageXValue;
    }
    public int getAskingMessageYValue(){
        return this.askingMessageYValue;
    }

    public void setWidth(int width){
        this.width = width;
        this.askingMessageXValue = (int)(width * 0.23);
        this.deletedFriendUsernameXValue = (int)(width * 0.23);
        this.resultMessageXValue = (int)(width * 0.23);
        this.canvasWidth = width;
        this.yesButtonXValue = (int)(width * 0.18);
        this.yesButtonWidth = width/4;
        this.noButtonXValue = (int)(width * 0.51);
        this.noButtonWidth = this.yesButtonWidth;
        this.okButtonXValue = width/3;
        this.okButtonWidth = width/4;
    }
    public void setHeight(int height){
        this.height = height;
        this.askingMessageYValue = (int)(height * 0.36);
        this.deletedFriendUsernameYValue = (int)(height * 0.25);
        this.resultMessageYValue = (int)(height * 0.46);
        this.canvasHeight = height/2;
        this.yesButtonYValue = (int)(height * 0.55);
        this.yesButtonHeight = height/5;
        this.noButtonYValue = (int)(height * 0.55);
        this.noButtonHeight = this.yesButtonHeight;
        this.okButtonYValue = (int)(height * 0.65);
        this.okButtonHeight = height/9;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setDeleteFriendCompleted(boolean deleteFriendCompleted){
        this.deleteFriendCompleted = deleteFriendCompleted;
    }
    public void setFriendViewManager(FriendViewManager friendViewManager){
        this.friendViewManager = friendViewManager;
    }
    public void setDeletedFriendUsername(String deletedFriendUsername){
        this.deletedFriendUsername = deletedFriendUsername;
    }
    public void setCurrentUsername(String currentUsername){
        this.currentUsername = currentUsername;
    }

    public void setOutputDataList(){
        this.outputDataList = new ArrayList<>();
        this.outputDataList.add(this.width);
        this.outputDataList.add(this.height);
        this.outputDataList.add(this.message);
        this.outputDataList.add(this.deleteFriendCompleted);
        this.outputDataList.add(this.friendViewManager);
        this.outputDataList.add(this.deletedFriendUsername);
        this.outputDataList.add(this.currentUsername);

    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener x) {
        this.support.addPropertyChangeListener(x);
    }
}
