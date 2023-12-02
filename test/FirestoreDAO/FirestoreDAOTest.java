package FirestoreDAO;

import data_access.FirestoreDAO;
import entity.Friend;
import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    public void testAddExercise() throws ExecutionException, InterruptedException {
        if (!firestoreDAO.existsByName("testUser"))
        {
            User testUser = new User("testUser", "test@gmail.com", "testPassword");
            firestoreDAO.save(testUser);
        }
        firestoreDAO.addExerciseToSchedule("testUser", 0, "pull ups");
        firestoreDAO.addExerciseToSchedule("testUser", 0, "push ups");
        firestoreDAO.addExerciseToSchedule("testUser", 2, "push ups");
        System.out.println(firestoreDAO.getExerciseSchedule("testUser"));
        Assertions.assertNotNull(firestoreDAO.getExerciseSchedule("testUser"));
    }

    @Test
    public void testFriendList() throws ExecutionException, InterruptedException {
        List<Friend> friends = firestoreDAO.getFriendsAsList("User1");
        assertEquals("User2", friends.get(0).getUsername());
        assertEquals("user2@gmail.com", friends.get(0).getGmail());
    }

    @Test
    public void testGetUser() throws ExecutionException, InterruptedException {
        User user = firestoreDAO.getUserFromName("User1");
        assertEquals("User1", user.getUsername());
        assertEquals("user1@gmail.com", user.getGmail());
        assertEquals("password1", user.getPassword());
    }

    @Test
    public void testRemoveFriend() throws ExecutionException, InterruptedException{
        User user1 = firestoreDAO.getUserFromName("User1");
        Friend newFriend = new Friend("newFriend");
        firestoreDAO.addFriend(user1, newFriend);
        assertTrue(firestoreDAO.existsByNameInFriendsCollection("User1", "newFriend"));
        firestoreDAO.removeFriend("User1", "newFriend");
        assertTrue(!firestoreDAO.existsByNameInFriendsCollection("User1", "newFriend"));
    }

    @Test
    public void testFiveExercises() throws ExecutionException, InterruptedException{
        if (!firestoreDAO.existsByName("testUser2"))
        {
            User testUser = new User("testUser2", "test@gmail.com", "testPassword");
            firestoreDAO.save(testUser);
        }
        firestoreDAO.addExerciseToSchedule("testUser2", 0, "pull ups");
        firestoreDAO.addExerciseToSchedule("testUser2", 0, "push ups");
        firestoreDAO.addExerciseToSchedule("testUser2", 0, "push");
        firestoreDAO.addExerciseToSchedule("testUser2", 0, "push up");
        firestoreDAO.addExerciseToSchedule("testUser2", 0, "stance");
        assertTrue(firestoreDAO.hasFiveExercises("testUser2", 0));
    }

    @Test
    public void testAddExerciseToEmpty() throws ExecutionException, InterruptedException {
        if (!firestoreDAO.existsByName("testUser3"))
        {
            User testUser = new User("testUser3", "test@gmail.com", "testPassword");
            firestoreDAO.save(testUser);
        }
        firestoreDAO.addExerciseToSchedule("testUser3", 0, "pushes");
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

    @Test
    public void testExerciseScheduleExists() throws ExecutionException, InterruptedException {
        if (!firestoreDAO.existsByName("testUser4"))
        {
            User testUser = new User("testUser4", "test@gmail.com", "testPassword");
            firestoreDAO.save(testUser);
        }
        assertFalse(firestoreDAO.exerciseScheduleExists("testUser4"));
        assertFalse(firestoreDAO.hasFiveExercises("testUser4", 0));
        firestoreDAO.addExerciseToSchedule("testUser4", 0, "exer");
        assertTrue(firestoreDAO.exerciseScheduleExists("testUser4"));
    }
}