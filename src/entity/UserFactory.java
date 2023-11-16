package entity;

public class UserFactory {
    public User create(String username, String password, String gmail){
        return new User(username, password, gmail);
    }
}
