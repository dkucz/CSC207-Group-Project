package LoginTest;

import app.ViewManagerModel;
import login.view.ViewManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ViewManagerTest {
    private ViewManager viewManager;
    private JPanel views;
    private CardLayout cardLayout;
    private ViewManagerModel viewManagerModel;

    @BeforeEach
    void setUp() {
        views = new JPanel();
        cardLayout = new CardLayout();
        viewManagerModel = new ViewManagerModel();
        viewManager = new ViewManager(views, cardLayout, viewManagerModel);
    }

    @Test
    void propertyChange() {
        String newViewName = "TestView";

        viewManagerModel.setActiveView(newViewName);
        assertNotNull(viewManagerModel.getActiveView());
    }
}
