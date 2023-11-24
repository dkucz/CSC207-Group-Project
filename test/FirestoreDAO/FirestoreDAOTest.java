package FirestoreDAO;

import data_access.FirestoreDAO;
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
        assertTrue(firestoreDAO.existsByName(testUser.getUserID()));

        // Check if the user exists by a non-existing username
        assertFalse(firestoreDAO.existsByName("NonExistingUser"));
    }

    @Test
    public void testAddFriend() {
        // Create two test users
        User user1 = new User("User1", "user1@gmail.com", "password1");
        User user2 = new User("User2", "user2@gmail.com", "password2");

        // Save the users to Firestore
        try {
            firestoreDAO.save(user1);
            firestoreDAO.save(user2);
        } catch (ExecutionException | InterruptedException e) {
            fail("Exception thrown while saving users: " + e.getMessage());
        }

        // Add user2 as a friend to user1
        firestoreDAO.addFriend(user1, user2);

        // Check if the friend was added successfully
        assertTrue(userExistsInFriendsCollection(user1, user2));

        // Check if a non-existing friend is not in the collection
        User nonExistingFriend = new User("NonExistingFriend", "nonexisting@gmail.com", "nonexistingPassword");
        assertFalse(userExistsInFriendsCollection(user1, nonExistingFriend));
    }

    private boolean userExistsInFriendsCollection(User user, User friend) {
        try {
            // Check if the friend exists in the user's friends collection
            return firestoreDAO.existsByNameInFriendsCollection(user.getUserID(), friend.getUserID());
        } catch (ExecutionException | InterruptedException e) {
            fail("Exception thrown while checking if user exists in friends collection: " + e.getMessage());
            return false;
        }
    }
}