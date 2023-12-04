package FriendTest;

import friend.interface_adapter.delete_friend.DeleteFriendViewModel;
import friend.view.FriendViewManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeleteFriendViewModelTest {

    @Mock
    private PropertyChangeListener propertyChangeListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSetWidthAndHeight() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");

        // Act
        viewModel.setWidth(800);
        viewModel.setHeight(600);

        // Assert
        assertEquals(800, viewModel.getCanvasWidth());
        assertEquals(300, viewModel.getCanvasHeight());
    }

    @Test
    void testSetMessage() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");

        // Act
        viewModel.setMessage("Test Message");

    }

    @Test
    void testSetDeleteFriendCompleted() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");

        // Act
        viewModel.setDeleteFriendCompleted(true);

    }

    @Test
    void testSetFriendViewManager() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        FriendViewManager friendViewManager = mock(FriendViewManager.class);

        // Act
        viewModel.setFriendViewManager(friendViewManager);

    }

    @Test
    void testSetDeletedFriendUsername() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");

        // Act
        viewModel.setDeletedFriendUsername("JohnDoe");

    }

    @Test
    void testSetCurrentUsername() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");

        // Act
        viewModel.setCurrentUsername("CurrentUser");

    }

    @Test
    void testSetOutputDataList() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.setWidth(800);
        viewModel.setHeight(600);
        viewModel.setMessage("Test Message");
        viewModel.setDeleteFriendCompleted(true);
        FriendViewManager friendViewManager = mock(FriendViewManager.class);
        viewModel.setFriendViewManager(friendViewManager);
        viewModel.setDeletedFriendUsername("JohnDoe");
        viewModel.setCurrentUsername("CurrentUser");

        // Act
        viewModel.setOutputDataList();
    }

    @Test
    void testPropertyChange() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.addPropertyChangeListener(propertyChangeListener);

        // Act
        viewModel.firePropertyChanged();

        // Assert
        verify(propertyChangeListener, times(1)).propertyChange(any());
    }

    @Test
    void testGetFontSize() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");

        // Act
        int fontSize = viewModel.getFontSize();
    }

    @Test
    void testGetAskingMessageXValue() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.setWidth(800);  // Assuming width is set appropriately

        // Act
        int askingMessageXValue = viewModel.getAskingMessageXValue();
        int b = viewModel.getNoButtonXValue();
        int c = viewModel.getNoButtonYValue();
        int d = viewModel.getNoButtonWidth();
        int f = viewModel.getNoButtonHeight();

        int e = viewModel.getYesButtonXValue();
        int h = viewModel.getYesButtonYValue();
        int g = viewModel.getYesButtonWidth();
        int m = viewModel.getYesButtonHeight();

        int z = viewModel.getResultMessageXValue();
        int m1 = viewModel.getResultMessageYValue();

        int f1 = viewModel.getDeletedFriendUsernameXValue();
        int f2 = viewModel.getDeletedFriendUsernameYValue();

        // Assert
        assertEquals((int)(800 * 0.23), askingMessageXValue);
    }

    @Test
    void testGetAskingMessageYValue() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.setHeight(600);  // Assuming height is set appropriately

        // Act
        int askingMessageYValue = viewModel.getAskingMessageYValue();

        // Assert
        assertEquals((int)(600 * 0.36), askingMessageYValue);
    }

    @Test
    void testGetFontName() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");

        // Act
        String fontName = viewModel.getFontName();

    }

    @Test
    void testGetOkButtonXValue() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.setWidth(800);  // Assuming width is set appropriately

        // Act
        int okButtonXValue = viewModel.getOkButtonXValue();

        // Assert
        assertEquals(800 / 3, okButtonXValue);
    }

    @Test
    void testGetOkButtonYValue() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.setHeight(600);  // Assuming height is set appropriately

        // Act
        int okButtonYValue = viewModel.getOkButtonYValue();

        // Assert
        assertEquals((int) (600 * 0.65), okButtonYValue);
    }

    @Test
    void testGetOkButtonWidth() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.setWidth(800);  // Assuming width is set appropriately

        // Act
        int okButtonWidth = viewModel.getOkButtonWidth();

        // Assert
        assertEquals(800 / 4, okButtonWidth);
    }

    @Test
    void testGetOkButtonHeight() {
        // Arrange
        DeleteFriendViewModel viewModel = new DeleteFriendViewModel("Test View");
        viewModel.setHeight(600);  // Assuming height is set appropriately

        // Act
        int okButtonHeight = viewModel.getOkButtonHeight();

        // Assert
        assertEquals(600 / 9, okButtonHeight);
    }
}
