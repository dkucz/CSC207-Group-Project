package Friend.interface_adapter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FriendViewModel extends ViewModel {
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public FriendViewModel(String viewName) {
        super(viewName);
    }
    @Override
    public void firePropertyChanged() {
        this.support.firePropertyChange("PC_00",null,"");
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener x) {
        this.support.addPropertyChangeListener(x);
    }
}
