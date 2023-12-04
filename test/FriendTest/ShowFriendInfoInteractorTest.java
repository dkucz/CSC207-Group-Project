package FriendTest;

import friend.use_case.show_friend_info.ShowFriendInfoInputData;
import friend.use_case.show_friend_info.ShowFriendInfoInteractor;
import friend.use_case.show_friend_info.ShowFriendInfoOutputBoundary;
import friend.use_case.show_friend_info.ShowFriendInfoOutputData;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import friend.view.FriendViewManager;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ShowFriendInfoInteractorTest {

    @Test
    public void testExecute() {
        // Mock dependencies
        ShowFriendInfoOutputBoundary showFriendInfoPresenter = Mockito.mock(ShowFriendInfoOutputBoundary.class);
        FriendViewManager friendViewManager = Mockito.mock(FriendViewManager.class);
        Mockito.when(showFriendInfoPresenter.getFriendViewManager()).thenReturn(friendViewManager);

        // Create ShowFriendInfoInteractor instance
        ShowFriendInfoInteractor showFriendInfoInteractor = new ShowFriendInfoInteractor(showFriendInfoPresenter);

        // Create ShowFriendInfoInputData
        ShowFriendInfoInputData showFriendInfoInputData = new ShowFriendInfoInputData("currentUser", "friendUser", "friend@gmail.com");

        // Execute the interactor
        showFriendInfoInteractor.execute(showFriendInfoInputData);

        // Verify that the presenter method was called with the correct output data
        verify(showFriendInfoPresenter, times(1)).prepareSuccessView(any(ShowFriendInfoOutputData.class));
    }
}