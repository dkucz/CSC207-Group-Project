package menu.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import java.awt.*;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.MenuState;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "menu";
    private final MenuViewModel menuViewModel;

    final JButton friends;
    final JButton createEvent;
    final JButton modifyEvent;

    public MenuView(MenuViewModel menuViewModel){
        this.menuViewModel = menuViewModel;
        this.menuViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel calendar = new JLabel("Calendar");
        calendar.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel buttons = new JPanel();
        friends = new JButton(menuViewModel.FRIENDS_BUTTON_LABEL);
        buttons.add(friends);
        createEvent = new JButton(menuViewModel.CREATE_EVENT_BUTTON_LABEL);
        buttons.add(createEvent);
        modifyEvent = new JButton(menuViewModel.MODIFY_EVENT_BUTTON_LABEL);
        buttons.add(modifyEvent);

        friends.addActionListener(this);
        modifyEvent.addActionListener(this);
        modifyEvent.addActionListener(this);

        this.add(title);
        this.add(calendar);
        this.add(buttons);




    }
    public void actionPerformed(ActionEvent evt){
        System.out.println("Click " + evt.getActionCommand());
    }
    @Override
    public void propertyChange(PropertyChangeEvent e){
        MenuState state = (MenuState)e.getNewValue();
    }

}
