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

import friend.app.FriendUseCaseFactory;
import friend.interface_adapter.*;
import friend.interface_adapter.add_friend.AddFriendFailedViewModel;
import friend.interface_adapter.add_friend.AddFriendViewModel;
import friend.interface_adapter.delete_friend.DeleteFriendViewModel;
import friend.interface_adapter.friend_page.FriendController;
import friend.interface_adapter.friend_page.FriendViewModel;
import friend.interface_adapter.show_friend_info.ShowFriendInfoViewModel;
import friend.view.*;
import friend.view.delete_friend.DeleteFriendView;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import workout.view.WorkoutView;
import workout.view.WorkoutViewManager;
import workout.view.WorkoutViewManagerModel;
import app.ScheduleUseCaseFactory;
import app.ViewManagerModel;
import app.WorkoutUseCaseFactory;
import data_access.ExercisesDAO;
import data_access.FacadeDAO;
import data_access.FirestoreDAO;
import data_access.GoogleCalendarDAO;
import friend.view.add_friend.AddFriendFailedView;
import friend.view.add_friend.AddFriendView;
import friend.view.friend_page.FriendView;
import friend.view.show_friend_info.ShowFriendInfoView;
import entity.User;
import menu.interface_adapter.CreateEventController;
import menu.interface_adapter.MenuViewModel;
import menu.interface_adapter.MenuState;
import menu.interface_adapter.SignoutController;
import signup.interface_adapter.SignupViewModel;

import static menu.app.CreateEventUseCaseFactory.createEventUseCase;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewname = "menu";
    private final MenuViewModel menuViewModel;

    final JButton friends;
    final JButton createEvent;
    final JButton refresh;
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


        refresh = new JButton(menuViewModel.REFRESH_BUTTON_LABEL);
        buttons.add(refresh);

        signout = new JButton(menuViewModel.SIGNOUT_BUTTON_LABEL);
        buttons.add(signout);


        refresh.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GoogleCalendarDAO cal = new GoogleCalendarDAO();
                        MenuView.this.calendarPanel.removeAll();

                        String calendarName = "Fitness Tracker";
                        DefaultListModel<String> events = null;

                        try {
                            events = cal.getEventsForToday(calendarName);


                            if (events != null) {
                                events.add(0, "Calendar: " + calendarName);

                                JList<String> eventList = new JList<>(events);
                                JScrollPane scrollPane = new JScrollPane(eventList);

                                MenuView.this.calendarPanel.add(scrollPane, BorderLayout.CENTER);
                                MenuView.this.calendarPanel.revalidate();
                            }
                        } catch (GeneralSecurityException | IOException ex){
                            System.out.println("Refresh failed!");
                        }
                    }
                }
        );

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
                        try {
                            //STUFF
                            WorkoutViewManagerModel workoutManagerModel = new WorkoutViewManagerModel();
                            WorkoutViewManager workoutViewManager = new WorkoutViewManager(workoutManagerModel);
                            WorkoutViewModel workoutViewModel = new WorkoutViewModel();
                            SignupViewModel signupViewModel = new SignupViewModel();
                            MenuViewModel menuViewModel = new MenuViewModel();
                            ViewManagerModel viewManagerModel = new ViewManagerModel();
                            ModifyWorkoutViewModel modifyWorkoutViewModel = new ModifyWorkoutViewModel();

                            //FACADE initialization
                            ExercisesDAO appDAO = new ExercisesDAO();
                            FirestoreDAO firestoreDAO = new FirestoreDAO();
                            GoogleCalendarDAO google = new GoogleCalendarDAO();
                            FacadeDAO DAO = new FacadeDAO(firestoreDAO, google, appDAO);

                            //WORKOUT VIEW initialization
                            ModifyWorkoutController modController = ScheduleUseCaseFactory.createModUseCase(modifyWorkoutViewModel, firestoreDAO);
                            WorkoutView workout = WorkoutUseCaseFactory.create(viewManagerModel,
                                    workoutViewModel, modifyWorkoutViewModel, modController, menuViewModel, DAO);
                            workoutViewManager.addView(workout);
                            CreateEventController createEventController = createEventUseCase(workoutManagerModel,
                                    workoutViewManager, workoutViewModel);
                            createEventController.execute(MenuView.this.currentUser);
                            System.out.println("The workout name is " + workout.viewName);
                        } catch (GeneralSecurityException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
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
        this.calendarPanel.removeAll();

        String calendarName = "Fitness Tracker";
        DefaultListModel<String> events = cal.getEventsForToday(calendarName);
        if (events != null) {
            events.add(0, "Calendar: " + calendarName);

            JList<String> eventList = new JList<>(events);
            JScrollPane scrollPane = new JScrollPane(eventList);

            this.calendarPanel.add(scrollPane, BorderLayout.CENTER);
        }


    }
}
