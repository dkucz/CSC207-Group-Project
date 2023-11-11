package login.use_case;

public class LoginInputData {
    private String username;
    private String gmail;
    private String password;

    public LoginInputData(String username, String gmail, String password)
    {
        this.username = username;
        this.gmail = gmail;
        this.password = password;
    }

    public String getUsername(){ return this.username; }
    public String getGmail(){ return this.gmail; }
    public String getPassword(){ return this.password;}

}
