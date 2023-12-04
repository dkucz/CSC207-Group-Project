package data_access;

import friend.data_access.AddFriend.AddFriendDAOInterface;
import friend.data_access.DeleteFriend.DeleteFriendDAOInterface;
import friend.data_access.FriendPage.FriendPageDAOInterface;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import entity.Friend;
import entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class FirestoreDAO implements AddFriendDAOInterface, DeleteFriendDAOInterface, FriendPageDAOInterface {

    private final Firestore database;
    private final String userCollectionID = "users";
    private final String friendCollectionID = "friends";
    private final String userString = "username";
    private final String passwordString = "password";
    private final String gmailString = "gmail";
    private final String exerciseScheduleID = "ExerciseSchedule";
    private final CollectionReference userCollection;

    public FirestoreDAO() throws IOException {
        InputStream serviceAccount = new FileInputStream("./serviceaccount.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        //FirebaseApp.initializeApp(options);
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
        database = FirestoreClient.getFirestore();
        userCollection = database.collection(userCollectionID);
    }

    public void save(User user) throws ExecutionException, InterruptedException
    {
        // Create a new user document and set the userID as documentID
        DocumentReference newUserRef = database.collection(userCollectionID).document(user.getUsername());

        Map<String, Object> userData = getUserData(user);

        ApiFuture<WriteResult> writeResult = newUserRef.set(userData);

        writeResult.get();
    }

    public boolean existsByName(String username) throws ExecutionException, InterruptedException {
        return userExists(userCollection, username);
    }

    public boolean existsByNameInFriendsCollection(String username, String friendUsername)
            throws ExecutionException, InterruptedException {
        CollectionReference friendCollection = userCollection.document(username).collection(friendCollectionID);
        return userExists(friendCollection, friendUsername);
    }

    public void addFriend(User user, Friend friend) throws ExecutionException, InterruptedException {
        CollectionReference friendsCollection = database.collection(userCollectionID)
                .document(user.getUsername()).collection(friendCollectionID);

        DocumentReference friendDocReference = friendsCollection.document(friend.getUsername());

        Map<String, Object> friendData = getUserData(friend);

        ApiFuture<WriteResult> writeRes = friendDocReference.set(friendData);

        writeRes.get();
    }

    public List<Friend> getFriendsAsList(String username) throws ExecutionException, InterruptedException {
        List<Friend> friendsList = new ArrayList<>();

        CollectionReference friendCollection = userCollection.document(username).collection(friendCollectionID);
        ApiFuture<QuerySnapshot> friendQuery = friendCollection.get();

        for (QueryDocumentSnapshot friendDocument : friendQuery.get().getDocuments())
        {
            Friend friend = friendDocument.toObject(Friend.class);
            friendsList.add(friend);
        }
        return friendsList;
    }

    public User getUserFromName(String username) throws ExecutionException, InterruptedException {
        Query query = userCollection.whereEqualTo(userString, username);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        DocumentSnapshot userDocument = querySnapshot.get().getDocuments().get(0);
        return userDocument.toObject(User.class);
    }

    public Friend getFriendFromName(String username, String friendUsername) throws ExecutionException, InterruptedException {
        CollectionReference friendCollection = userCollection.document(username).collection(friendCollectionID);
        Query query = friendCollection.whereEqualTo(userString, friendUsername);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        DocumentSnapshot friendDocument = querySnapshot.get().getDocuments().get(0);
        return friendDocument.toObject(Friend.class);
    }

    public void removeFriend(String username, String friendUsername) throws ExecutionException, InterruptedException {
        deleteFriendDocument(username, friendUsername);
        deleteFriendDocument(friendUsername, username);
    }

    public void addExerciseToSchedule(String username, int day, String exerciseName) throws ExecutionException, InterruptedException {
        CollectionReference exerciseSchedule = userCollection.document(username).collection(exerciseScheduleID);
        DocumentReference dayDocument = exerciseSchedule.document(String.valueOf(day));
        DocumentSnapshot documentSnapshot = dayDocument.get().get();
        if(!documentSnapshot.exists() || !documentSnapshot.contains("exercises"))
        {
            Map<String, Object> exerciseData = new HashMap<>();
            exerciseData.put("exercises", Arrays.asList(exerciseName));
            dayDocument.set(exerciseData);
        }else{
            dayDocument.update("exercises", FieldValue.arrayUnion(exerciseName));
        }
    }

    public ArrayList<ArrayList<String>> getExerciseSchedule(String username) throws ExecutionException, InterruptedException {
        ArrayList<ArrayList<String>> exerciseSchedule = new ArrayList<>();

        CollectionReference exerciseCollection = userCollection.document(username).collection(exerciseScheduleID);

        ApiFuture<QuerySnapshot> snapshot = exerciseCollection.get();
        List<QueryDocumentSnapshot> exercises = snapshot.get().getDocuments();

        for (int day = 0; day <= 6; day++) {
            DocumentReference exerciseDocument = exerciseCollection.document(String.valueOf(day));

            ApiFuture<DocumentSnapshot> documentSnapshotFuture = exerciseDocument.get();
            DocumentSnapshot exerciseDoc = documentSnapshotFuture.get();

            if (exerciseDoc.exists() && exerciseDoc.contains("exercises")) {
                List<String> exerciseList = (List<String>) exerciseDoc.get("exercises");
                exerciseSchedule.add(new ArrayList<>(exerciseList));
            } else {
                exerciseSchedule.add(new ArrayList<>());
            }
        }
        return exerciseSchedule;
    }

    public boolean exerciseScheduleExists(String username) throws ExecutionException, InterruptedException {
        CollectionReference exerciseCollection = userCollection.document(username).collection(exerciseScheduleID);
        QuerySnapshot querySnapshot = exerciseCollection.get().get();
        if (!querySnapshot.isEmpty())
        {
            return true;
        }
        return false;
    }

    public boolean hasFiveExercises(String username, int day) throws ExecutionException, InterruptedException {
        DocumentReference exerciseDocument = userCollection.document(username)
                .collection(exerciseScheduleID).document(String.valueOf(day));
        DocumentSnapshot documentSnapshot = exerciseDocument.get().get();
        if (!documentSnapshot.exists()) {
            return false;
        } else{
            ArrayList<String> exerciseList = (ArrayList<String>) documentSnapshot.get("exercises");
            if (exerciseList != null && exerciseList.size() == 5) {
                return true;
            }
        }
        return false;
    }

    private void deleteFriendDocument(String username, String friendUsername) throws ExecutionException, InterruptedException {
        CollectionReference friendCollection = userCollection.document(username).
                collection(friendCollectionID);

        Query query = friendCollection.whereEqualTo(userString, friendUsername);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        List<QueryDocumentSnapshot> friendDocuments = querySnapshot.get().getDocuments();
        if (!friendDocuments.isEmpty())
        {
            friendDocuments.get(0).getReference().delete();
        }
    }

    private boolean userExists(CollectionReference collectionReference, String username)
            throws ExecutionException, InterruptedException {
        Query query = collectionReference.whereEqualTo(userString, username);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        boolean userExists = !querySnapshot.get().isEmpty();

        return userExists;
    }

    private Map<String, Object> getUserData(User user)
    {
        Map<String, Object> userData = new HashMap<>();
        userData.put(userString, user.getUsername());
        userData.put(passwordString, user.getPassword());
        userData.put(gmailString, user.getGmail());
        return userData;
    }

    private Map<String, Object> getUserData(Friend friend)
    {
        Map<String, Object> userData = new HashMap<>();
        userData.put(userString, friend.getUsername());
        userData.put(gmailString, friend.getGmail());
        return userData;
    }
}
