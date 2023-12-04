package FriendTest;

import friend.use_case.add_friend.AddFriendOutputData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddFriendOutputDataTest {

    @Test
    void testGetters() {
        // Create an instance of AddFriendOutputData
        String currentUserName = "User1";
        String wantToAddFriendUsername = "Friend1";
        String wantToAddFriendGmail = "friend1@gmail.com";
        boolean friendDoesNotExist = true;
        boolean friendAlreadyInList = false;

        AddFriendOutputData outputData = new AddFriendOutputData(
                currentUserName,
                wantToAddFriendUsername,
                wantToAddFriendGmail,
                friendDoesNotExist,
                friendAlreadyInList
        );

        // Test getters
        assertEquals(currentUserName, outputData.getCurrentUserName());
        assertEquals(wantToAddFriendUsername, outputData.getWantToAddFriendUsername());
        assertEquals(wantToAddFriendGmail, outputData.getWantToADdFriendGmail());
        assertEquals(friendDoesNotExist, outputData.isFriendDoesNotExist());
        assertEquals(friendAlreadyInList, outputData.isFriendAlreadyInList());
    }
}
