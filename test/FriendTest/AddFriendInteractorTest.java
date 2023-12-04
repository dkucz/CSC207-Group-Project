package FriendTest;

import friend.data_access.add_friend.AddFriendDAOInterface;
import friend.data_access.share_calendar.ShareCalendarDAOInterface;
import friend.use_case.add_friend.AddFriendInteractor;
import friend.use_case.add_friend.AddFriendOutputBoundary;
import friend.view.FriendViewManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import friend.data_access.add_friend.AddFriendDAOInterface;
import friend.use_case.add_friend.ShareCalendarDAOInterface;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddFriendInteractorTest {

    private AddFriendOutputBoundary addFriendPresenter;
    private AddFriendDAOInterface firestoreDAO;
    private ShareCalendarDAOInterface calendarDAO;
    private AddFriendInteractor addFriendInteractor;

    @BeforeEach
    void setUp() {
        addFriendPresenter = mock(AddFriendOutputBoundary.class);
        firestoreDAO = mock(AddFriendDAOInterface.class);
        calendarDAO = mock(ShareCalendarDAOInterface.class);
        FriendViewManager friendViewManager = mock(FriendViewManager.class);
        when(addFriendPresenter.getFriendViewManager()).thenReturn(friendViewManager);

        addFriendInteractor = new AddFriendInteractor(addFriendPresenter, firestoreDAO, calendarDAO);
    }

    @Test
    void testAddFriendSuccess() throws ExecutionException, InterruptedException, IOException, GeneralSecurityException {
        // Arrange
        AddFriendInputData inputData = new AddFriendInputData("currentUser", "friendToAdd");
        when(firestoreDAO.existsByName("friendToAdd")).thenReturn(true);
        when(firestoreDAO.getUserFromName("friendToAdd")).thenReturn(new User("friendToAdd", "friend@gmail.com"));
        when(firestoreDAO.getUserFromName("currentUser")).thenReturn(new User("currentUser", "user@gmail.com"));

        // Act
        assertDoesNotThrow(() -> addFriendInteractor.execute(inputData));

        // Assert
        verify(addFriendPresenter, times(1)).prepareSuccessView(any());
        verify(addFriendPresenter, never()).prepareFailedView(any());
        verify(firestoreDAO, times(2)).addFriend(any(), any());
        verify(calendarDAO, times(1)).createAccessControlRule(anyString());
    }

    @Test
    void testAddFriendUserDoesNotExist() throws ExecutionException, InterruptedException, IOException, GeneralSecurityException {
        // Arrange
        AddFriendInputData inputData = new AddFriendInputData("currentUser", "nonExistentUser");
        when(firestoreDAO.existsByName("nonExistentUser")).thenReturn(false);

        // Act
        assertDoesNotThrow(() -> addFriendInteractor.execute(inputData));

        // Assert
        verify(addFriendPresenter, times(1)).prepareFailedView(any());
        verify(addFriendPresenter, never()).prepareSuccessView(any());
        verify(firestoreDAO, never()).addFriend(any(), any());
        verify(calendarDAO, never()).createAccessControlRule(anyString());
    }

    @Test
    void testAddFriendAlreadyInList() throws ExecutionException, InterruptedException, IOException, GeneralSecurityException {
        // Arrange
        AddFriendInputData inputData = new AddFriendInputData("currentUser", "friendAlreadyInList");
        when(firestoreDAO.existsByName("friendAlreadyInList")).thenReturn(true);
        when(firestoreDAO.getUserFromName("friendAlreadyInList")).thenReturn(new User("friendAlreadyInList", "friend@gmail.com"));
        when(firestoreDAO.getUserFromName("currentUser")).thenReturn(new User("currentUser", "user@gmail.com"));
        FriendViewManager friendViewManager = mock(FriendViewManager.class);
        when(addFriendPresenter.getFriendViewManager()).thenReturn(friendViewManager);
        when(friendViewManager.getFriendView()).thenReturn(new FriendView());

        // Act
        assertDoesNotThrow(() -> addFriendInteractor.execute(inputData));

        // Assert
        verify(addFriendPresenter, times(1)).prepareFailedView(any());
        verify(addFriendPresenter, never()).prepareSuccessView(any());
        verify(firestoreDAO, never()).addFriend(any(), any());
        verify(calendarDAO, never()).createAccessControlRule(anyString());
    }
}