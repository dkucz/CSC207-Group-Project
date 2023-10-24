package entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Group {
    private final String name;
    private final List<User> members;

    //private final Calendar calendar;

    public Group(String n, User u){
        this.name = n;
        this.members = new ArrayList<>();
        this.members.add(u);
        //this.calendar = new Calendar();
    }

    public String getName(){
        return this.name;
    }
    public void addMember(User u){
        this.members.add(u);
    }

    /*public void createEvent(Event a){

    }*/
}
