package Friend.interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ShowFriendInfoViewModel extends ViewModel{
    private ArrayList<String> outputDataList = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public ShowFriendInfoViewModel(String View_Name) {
        super(View_Name);
    }
    @Override
    public void firePropertyChanged() {
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
