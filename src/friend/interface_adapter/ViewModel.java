package friend.interface_adapter;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {
    private String viewName;
    public ViewModel(String View_Name){
        this.viewName = View_Name;
    }
    public String getViewName(){
        return this.viewName;
    }
    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener x);
}
