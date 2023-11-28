package entity;

public class Friend implements CommonUser{

    public Friend(){}

    public Friend(String username, String gmail) {
        this.username = username;
        this.gmail = gmail;
    }
  
    private String username;
    private String gmail;

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
