package FriendTest;

import entity.Friend;
import friend.data_access.friend_page.FriendPageDAOInterface;
import friend.interface_adapter.friend_page.FriendPresenter;
import friend.use_case.friend_page.FriendInputData;
import friend.use_case.friend_page.FriendInteractor;
import friend.use_case.friend_page.FriendOutputData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class FriendInteractorTest {

    @Test
    public void testExecute() throws ExecutionException, InterruptedException {
        // Mock dependencies
        FriendPageDAOInterface firestoreDAO = Mockito.mock(FriendPageDAOInterface.class);
        FriendPresenter friendPresenter = Mockito.mock(FriendPresenter.class);

        // Set up test data
        String userName = "testUser";
        ArrayList<Friend> mockFriendList = new ArrayList<>();
        when(firestoreDAO.getFriendsAsList(userName)).thenReturn(mockFriendList);

        // Create FriendInteractor instance
        FriendInteractor friendInteractor = new FriendInteractor(friendPresenter, firestoreDAO);

        // Create FriendInputData
        FriendInputData friendInputData = new FriendInputData(userName);

        // Execute the interactor
        friendInteractor.execute(friendInputData);

        // Verify that the DAO method was called with the correct username
        verify(firestoreDAO, times(1)).getFriendsAsList(userName);

        // Verify that the presenter method was called with the correct output data
        verify(friendPresenter, times(1)).prepareSuccessView(any(FriendOutputData.class));
    }
}