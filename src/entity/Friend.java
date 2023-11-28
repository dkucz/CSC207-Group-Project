package entity;

public class Friend implements CommonUser{

    public Friend(){}

    private String username;
    private String gmail;

    public Friend(String username)
    {
        this.username = username;
    }

    //Setter for gmail. Should only ever be called once.
    public void setGmail(String gmail)
    {
        this.gmail = gmail;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getGmail() {
        return this.gmail;
    }
}
