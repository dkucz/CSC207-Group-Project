package data_access;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import entity.User;
import signup.data_access.SignupUserDataAccessInterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FirestoreDAO implements SignupUserDataAccessInterface {

    private final Firestore database;
    private final String userCollectionID = "users";

    public FirestoreDAO() throws IOException {
        InputStream serviceAccount = new FileInputStream("./serviceaccount.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        FirebaseApp.initializeApp(options);
        database = FirestoreClient.getFirestore();
    }

    @Override
    public void save(User user) throws ExecutionException, InterruptedException {
        // Create a new user document and set the userID as documentID
        DocumentReference newUserRef = database.collection(userCollectionID).document();
        String userID = newUserRef.getId();

        Map<String, Object> userData = _getUserData(user);

        ApiFuture<WriteResult> writeResult = newUserRef.set(userData);
        System.out.println("user created with ID: " + userID);

        writeResult.get();
    }

    private Map<String, Object> _getUserData(User user)
    {
        Map<String, Object> userData = new HashMap<>();
        userData.put("username", user.getUsername());
        userData.put("password", user.getPassword());
        return userData;
    }

    @Override
    public boolean existsByName(String username) throws ExecutionException, InterruptedException {
        CollectionReference userCollection = database.collection(userCollectionID);

        Query query = userCollection.whereEqualTo("username", username);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        boolean userExists =  !querySnapshot.get().isEmpty();

        return userExists;
    }
}
