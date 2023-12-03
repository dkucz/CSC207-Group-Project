package menu.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.concurrent.ExecutionException;

import Friend.app.FriendUseCaseFactory;
import Friend.interface_adapter.*;
import Friend.interface_adapter.AddFriend.AddFriendFailedViewModel;
import Friend.interface_adapter.AddFriend.AddFriendViewModel;
import Friend.interface_adapter.DeleteFriend.DeleteFriendViewModel;
import Friend.interface_adapter.FriendPage.FriendController;
import Friend.interface_adapter.FriendPage.FriendViewModel;
import Friend.interface_adapter.ShowFriendInfo.ShowFriendInfoViewModel;
import Friend.view.*;
import Friend.view.DeleteFriend.DeleteFriendView;
import Workout.interface_adapter.WorkoutViewModel;
import Workout.view.WorkoutViewManager;
import Workout.view.WorkoutViewManagerModel;
import data_access.GoogleCalendarDAO;
import Friend.view.AddFriend.AddFriendFailedView;
import Friend.view.AddFriend.AddFriendView;
import Friend.view.FriendPage.FriendView;
import Friend.view.ShowFriendInfo.ShowFriendInfoView;
import entity.User;
import menu.interface_adapter.CreateEventController;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.MenuState;
import menu.interface_adapter.SignoutController;

import static menu.app.CreateEventUseCaseFactory.createEventUseCase;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "menu";
    private final MenuViewModel menuViewModel;

    final JButton friends;
    final JButton createEvent;
    final JButton modifyEvent;
    final JLabel user;

    final JPanel calendarPanel;

    final JButton signout;
    private User currentUser;

    public MenuView(SignoutController signoutController, MenuViewModel menuViewModel){
        this.menuViewModel = menuViewModel;
        this.menuViewModel.addPropertyChangeListener(this);

        setLayout(new BorderLayout());


        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BorderLayout());
        calendarPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.add(calendarPanel, BorderLayout.CENTER);


        user = new JLabel();
        user.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(user, BorderLayout.SOUTH);

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

        signout = new JButton(menuViewModel.SIGNOUT_BUTTON_LABEL);
        buttons.add(signout);

        signout.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        signoutController.execute();
                    }
                }
        );


        createEvent.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        WorkoutViewManagerModel workoutManagerModel = new WorkoutViewManagerModel();
                        WorkoutViewManager workoutViewManager = new WorkoutViewManager(workoutManagerModel);
                        WorkoutViewModel workoutModel = new WorkoutViewModel();
                        CreateEventController createEventController = createEventUseCase(workoutViewManager, workoutModel);
                        System.out.println("workoutView created");
                        try {
                            createEventController.execute(MenuView.this.currentUser);
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
                            DeleteFriendViewModel deleteFriendViewModel = new DeleteFriendViewModel("DeleteFriendView");
                            DeleteFriendView deleteFriendView = new DeleteFriendView(deleteFriendViewModel);
                            friendViewManager.addView(friendView);
                            friendViewManager.addView(showFriendInfoView);
                            friendViewManager.addView(addFriendView);
                            friendViewManager.addView(addFriendFailedView);
                            friendViewManager.addView(deleteFriendView);
                            FriendController friendController = FriendUseCaseFactory.create(friendviewModel,friendViewManager);
                            friendController.execute(MenuView.this.currentUser.getUsername());

                        } catch (IOException | InterruptedException | ExecutionException ex){
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


    public User getCurrentUser(){
        return this.currentUser;
    }

    public void setUser(User u) throws GeneralSecurityException, IOException {

        this.currentUser = u;

        if (this.currentUser != null) {

            this.user.setText("User: " + this.currentUser.getUsername());


        }

        GoogleCalendarDAO cal = new GoogleCalendarDAO();
        DefaultListModel<String> events = cal.getCalendarList();
        JList<String> eventList = new JList<>(events);
        JScrollPane scrollPane = new JScrollPane(eventList);

        this.calendarPanel.removeAll();
        this.calendarPanel.add(scrollPane, BorderLayout.CENTER);


    }
}
