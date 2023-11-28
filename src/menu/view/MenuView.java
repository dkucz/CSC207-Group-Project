package menu.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

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

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Main Menu");
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel calendar = new JLabel("Calendar");
        calendar.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.add(Box.createVerticalStrut(20));
        friends = new JButton(menuViewModel.FRIENDS_BUTTON_LABEL);
        buttons.add(friends);
        createEvent = new JButton(menuViewModel.CREATE_EVENT_BUTTON_LABEL);
        buttons.add(createEvent);
        modifyEvent = new JButton(menuViewModel.MODIFY_EVENT_BUTTON_LABEL);
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
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
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

                            FriendController friendController = FriendUseCaseFactory.create(friendviewModel,friendViewManager);
                            friendController.execute(MenuView.this.currentUser.getUsername());

                        } catch (IOException ex){
                            throw new RuntimeException(ex);
                        } catch (ExecutionException ex) {
                            throw new RuntimeException(ex);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
        modifyEvent.addActionListener(this);
        this.add(title, BorderLayout.NORTH);

        this.add(calendar, BorderLayout.WEST);

        this.add(buttons, BorderLayout.EAST);
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
            user.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(user, BorderLayout.SOUTH);
        }
    }
}
