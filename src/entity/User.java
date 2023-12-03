package entity;

import java.util.ArrayList;

public class User implements CommonUser{
    /* User Class, each User is instantiated using their Google credentials*/
    private String username;
    private String password;
    private String gmail;

    public Week week= new Week();

    public User(){}

    public User(String username, String pass, String gmail){
        this.username = username;
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

    public Week getWeek(){return this.week;}

    public void setWeek(Week week){this.week = week;}
}
