package AppTest;

import app.ViewManagerModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ViewManagerModelTest {

    @Test
    public void testSetActiveView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewManagerModel.addPropertyChangeListener(listener);

        String newActiveView = "NewView";
        viewManagerModel.setActiveView(newActiveView);

        assertEquals(newActiveView, viewManagerModel.getActiveView());
    }

    @Test
    public void testAddPropertyChangeListener() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        PropertyChangeListener listener = mock(PropertyChangeListener.class);

        viewManagerModel.addPropertyChangeListener(listener);
    }

    @Test
    public void testFirePropertyChanged() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        viewManagerModel.addPropertyChangeListener(listener);

        viewManagerModel.firePropertyChanged();
        verify(listener).propertyChange(Mockito.any());
    }
}
