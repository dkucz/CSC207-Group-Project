package signup.use_case;

public class SignupInputData {
    final private String username;
    final private String gmail;
    final private String password;
    final private String repeatPassword;
    public SignupInputData(String username, String gmail, String password, String repeatPassword)
    {
        this.username = username;
        this.gmail = gmail;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public String getUsername(){ return this.username; }

    public String getGmail(){ return this.gmail; }

    public String getPassword(){ return this.password; }

    public String getRepeatPassword() { return this.repeatPassword; }
}
