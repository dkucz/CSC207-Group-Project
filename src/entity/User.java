package entity;
import java.util.*;
public class User {
    /* User Class, each User is instantiated using their Google credentials*/
    private final String username;
    private final String password;
    private List<User> friends;
    private int points;

    public User(String uname, String pass){
        this.username = uname;
        this.password = pass;
        this.friends = new ArrayList<>();
        this.points = 0;
    }

    //Getters
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.username;
    }
    public List<User> getFriends(){
        return this.friends;
    }
    public int getPoints(){
        return this.points;
    }

    //Setters
    public void addFriends(User friend){
        this.friends.add(friend);
    }
    public void addPoints(int points){
        this.points += points;
    }


}
