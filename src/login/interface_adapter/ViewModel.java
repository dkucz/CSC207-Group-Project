package login.interface_adapter;
import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    private String viewname;

    public ViewModel(String viewname){
        this.viewname = viewname;
    }

    public String getViewName(){
        return this.viewname;
    }

    public abstract void firePropertyChanged();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);

}
