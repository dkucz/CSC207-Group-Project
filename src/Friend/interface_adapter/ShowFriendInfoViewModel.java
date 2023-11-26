package Friend.interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ShowFriendInfoViewModel extends ViewModel{
    private ArrayList<String> outputDataList = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private int xValue = 0;
    private int yValue = 0;
    private final int width = 410;
    private final int height = 250;
    private final int firstLineHeightValue = height/6;
    private final int secondLineHeightValue = height - height/3;
    private final int friendUsernameFontSize = 34;
    private final int friendUsernameYValueRatio = 8;
    private final String fontName = "Apple LiGothic";
    private final int gmailHeightValue = height/2 - 5;
    public ShowFriendInfoViewModel(String View_Name) {
        super(View_Name);
    }
    public void setxValue(int x){
        this.xValue = x;
    }
    public void setyValue(int y){
        this.yValue = y;
    }
    public int getxValue(){
        return this.xValue;
    }
    public int getyValue(){
        return this.yValue;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public int getSecondLineHeightValue(){
        return this.secondLineHeightValue;
    }
    public int getFriendUsernameFontSize(){
        return this.friendUsernameFontSize;
    }
    public int getFriendUsernameYValueRatio(){
        return this.friendUsernameYValueRatio;
    }
    public int getFirstLineHeightValue(){
        return this.firstLineHeightValue;
    }
    public String getFontName(){
        return this.fontName;
    }
    public int getGmailHeightValue(){
        return this.gmailHeightValue;
    }
    @Override
    public void firePropertyChanged() {
        if(this.xValue != 0 && this.yValue != 0){
            this.support.firePropertyChange("ShowFriendInfoViewXYValueChange",null,null);
        }
        this.support.firePropertyChange("ShowFriendInfoViewPropertyChange",null,this.outputDataList);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener x) {
        this.support.addPropertyChangeListener(x);
    }
    public void setOutputDataList(ArrayList<String> outputDataList){
        this.outputDataList = outputDataList;
    }
}
