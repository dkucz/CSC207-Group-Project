package Friend.interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class DeleteFriendViewModel extends ViewModel{
    private String viewName;
    private ArrayList<Object> outputDataList; // [0] -> Width. [1] -> Height. [2] -> Message. [3] -> deleteFriendCompleted.
    private int width;
    private int height;
    private String message;
    private boolean deleteFriendCompleted;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public DeleteFriendViewModel(String viewName){
        super(viewName);
    }
    @Override
    public void firePropertyChanged () {
        this.support.firePropertyChange("outputData",null, this.outputDataList);
    }

    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setDeleteFriendCompleted(boolean deleteFriendCompleted){
        this.deleteFriendCompleted = deleteFriendCompleted;
    }
    public void setOutputDataList(){
        this.outputDataList = new ArrayList<>();
        this.outputDataList.add(this.width);
        this.outputDataList.add(this.height);
        this.outputDataList.add(this.message);
        this.outputDataList.add(this.deleteFriendCompleted);

    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener x) {
        this.support.addPropertyChangeListener(x);
    }
}
