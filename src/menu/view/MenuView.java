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
import Workout.data_access.WorkoutDataAccessInterface;
import Workout.interface_adapter.ModifyWorkout.ModifyWorkoutController;
import Workout.interface_adapter.ModifyWorkout.ModifyWorkoutViewModel;
import Workout.interface_adapter.SearchWorkout.WorkoutViewModel;
import Workout.view.WorkoutView;
import Workout.view.WorkoutViewManager;
import Workout.view.WorkoutViewManagerModel;
import app.ScheduleUseCaseFactory;
import app.ViewManagerModel;
import app.WorkoutUseCaseFactory;
import data_access.ExercisesDAO;
import data_access.FacadeDAO;
import data_access.FirestoreDAO;
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
import signup.interface_adapter.SignupViewModel;

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
                            ModifyWorkoutController modController = ScheduleUseCaseFactory.createModUseCase(modifyWorkoutViewModel, DAO);
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
        this.calendarPanel.removeAll();

        String calendarName = this.currentUser.getGmail();
        DefaultListModel<String> events = cal.getEventsForToday(calendarName);
        if (events != null) {
            events.add(0, "Calendar: " + calendarName);

            JList<String> eventList = new JList<>(events);
            JScrollPane scrollPane = new JScrollPane(eventList);

            this.calendarPanel.add(scrollPane, BorderLayout.CENTER);
        }


    }
}
