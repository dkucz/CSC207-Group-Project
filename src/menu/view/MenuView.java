package menu.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;

import Friend.app.FriendUseCaseFactory;
import Friend.interface_adapter.*;
import Friend.view.*;
import entity.User;
import menu.interface_adapter.CreateEventController;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.MenuState;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "menu";
    private final MenuViewModel menuViewModel;

    final JButton friends;
    final JButton createEvent;
    final JButton modifyEvent;

    private User currentUser;

    public MenuView(MenuViewModel menuViewModel){
        this.menuViewModel = menuViewModel;
        this.menuViewModel.addPropertyChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(Component.TOP_ALIGNMENT);

        JLabel calendar = new JLabel("Calendar");
        calendar.setAlignmentX(Component.LEFT_ALIGNMENT);
        calendar.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        friends = new JButton(menuViewModel.FRIENDS_BUTTON_LABEL);
        friends.setAlignmentX(Component.RIGHT_ALIGNMENT);
        buttons.add(friends);
        createEvent = new JButton(menuViewModel.CREATE_EVENT_BUTTON_LABEL);
        createEvent.setAlignmentX(Component.RIGHT_ALIGNMENT);
        buttons.add(createEvent);
        modifyEvent = new JButton(menuViewModel.MODIFY_EVENT_BUTTON_LABEL);
        modifyEvent.setAlignmentX(Component.RIGHT_ALIGNMENT);
        buttons.add(modifyEvent);


        createEvent.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            CreateEventController createEventController = new CreateEventController();
                            createEventController.execute();
                        } catch (GeneralSecurityException | IOException ex){
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
        friends.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FriendViewManagerModel friendViewManagerModel = new FriendViewManagerModel();
                        FriendViewManager friendViewManager = new FriendViewManager(friendViewManagerModel);

                        FriendViewModel friendviewModel = new FriendViewModel("FriendView");
                        FriendView friendView = new FriendView(friendviewModel);

                        ShowFriendInfoViewModel showFriendInfoViewModel= new ShowFriendInfoViewModel("ShowFriendInfoView");
                        ShowFriendInfoView showFriendInfoView = new ShowFriendInfoView(showFriendInfoViewModel);

                        AddFriendViewModel addFriendViewModel = new AddFriendViewModel("AddFriendView");
                        AddFriendView addFriendView = new AddFriendView(addFriendViewModel);

                        AddFriendFailedViewModel addFriendFailedViewModel= new AddFriendFailedViewModel("AddFriendFailedView");
                        AddFriendFailedView addFriendFailedView= new AddFriendFailedView(addFriendFailedViewModel);

                        friendViewManager.addView(friendView);
                        friendViewManager.addView(showFriendInfoView);
                        friendViewManager.addView(addFriendView);
                        friendViewManager.addView(addFriendFailedView);

                        FriendController friendController = null;
                        try {
                            friendController = FriendUseCaseFactory.create(friendviewModel,friendViewManager);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        friendController.execute(MenuView.this.currentUser.getUsername());
                    }
                }
        );
        modifyEvent.addActionListener(this);


        this.add(title);
        add(Box.createVerticalStrut(10)); // Adds some vertical space

        this.add(calendar);
        add(Box.createVerticalStrut(10)); // Adds some vertical space

        this.add(buttons);




    }
    public void actionPerformed(ActionEvent evt){
        System.out.println("Click " + evt.getActionCommand());
    }
    @Override
    public void propertyChange(PropertyChangeEvent e){
        MenuState state = (MenuState)e.getNewValue();
    }



    public void setUser(User u){
        this.currentUser = u;
        if (this.currentUser != null) {
            JLabel user = new JLabel("User: " + this.currentUser.getUsername());
            user.setAlignmentY(Component.TOP_ALIGNMENT);
            user.setAlignmentX(Component.RIGHT_ALIGNMENT);
            this.add(user);
        }
    }
}
