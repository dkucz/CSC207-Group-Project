package FirestoreDAO;

import data_access.FirestoreDAO;
import entity.Friend;
import entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class FirestoreDAOTest {

    private static boolean firebaseAppInitialized = false;
    private static FirestoreDAO firestoreDAO;

    @BeforeAll
    public static void setUpClass() throws IOException {
        // Initialize FirebaseApp only once before any test method is run
        if (!firebaseAppInitialized) {
            firestoreDAO = new FirestoreDAO();
            firebaseAppInitialized = true;
        }
    }

    @Test
    public void testSaveAndExistsByName() throws ExecutionException, InterruptedException {
        // Create a test user
        User testUser = new User("testUser", "test@gmail.com", "testPassword");

        // Save the user to Firestore
        firestoreDAO.save(testUser);

        // Check if the user exists by username
        assertTrue(firestoreDAO.existsByName(testUser.getUsername()));

        // Check if the user exists by a non-existing username
        assertFalse(firestoreDAO.existsByName("NonExistingUser"));
    }

    @Test
    public void testAddFriend() throws ExecutionException, InterruptedException {
        // Create two test users
        User user1 = new User("User1", "password1", "user1@gmail.com");
        User user2 = new User("User2", "password2", "user2@gmail.com");
        Friend friend = new Friend("User2");
        friend.setGmail("user2@gmail.com");

        // Save the users to Firestore
        try {
            firestoreDAO.save(user1);
            firestoreDAO.save(user2);
        } catch (ExecutionException | InterruptedException e) {
            fail("Exception thrown while saving users: " + e.getMessage());
        }

        // Add user2 as a friend to user1
        firestoreDAO.addFriend(user1, friend);

        // Check if the friend was added successfully
        assertTrue(userExistsInFriendsCollection(user1, friend));

        // Check if a non-existing friend is not in the collection
        Friend nonExistingFriend = new Friend("NonExistingFriend");
        nonExistingFriend.setGmail("nonexisting@gmail.com");
        assertFalse(userExistsInFriendsCollection(user1, nonExistingFriend));
    }

    @Test
    public void testGetFriend() throws ExecutionException, InterruptedException {
        User user1 = new User("User1", "password1", "user1@gmail.com");
        User user2 = new User("User2", "password2", "user2@gmail.com");
        Friend friend = new Friend("User2");
        friend.setGmail("user2@gmail.com");
        firestoreDAO.save(user1);
        firestoreDAO.save(user2);
        firestoreDAO.addFriend(user1, friend);
        Friend friend2 = firestoreDAO.getFriendFromName("User1", "User2");
        assertEquals("user2@gmail.com", friend2.getGmail());
        System.out.println(friend2.getGmail());
    }

    private boolean userExistsInFriendsCollection(User user, Friend friend) {
        try {
            // Check if the friend exists in the user's friends collection
            return firestoreDAO.existsByNameInFriendsCollection(user.getUsername(), friend.getUsername());
        } catch (ExecutionException | InterruptedException e) {
            fail("Exception thrown while checking if user exists in friends collection: " + e.getMessage());
            return false;
        }
    }
}