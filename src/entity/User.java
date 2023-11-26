package entity;
public class User implements CommonUser{
    /* User Class, each User is instantiated using their Google credentials*/
    private final String username;
    private final String password;
    private final String gmail;

    //hehe
    public User(String uname, String pass, String gmail){
        this.username = uname;
        this.password = pass;
        this.gmail = gmail;
        //TODO: Update UserFactory to include gmail String
    }

    //Getters
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){return this.password;}
    public String getGmail(){return this.gmail;}

}
