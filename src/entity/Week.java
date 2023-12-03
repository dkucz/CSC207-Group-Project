package entity;

import java.util.ArrayList;

public class Week {

    private ArrayList<ArrayList<String>> schedule = new ArrayList<>();

    private ArrayList<String> monday = new ArrayList<>();
    private ArrayList<String> tuesday = new ArrayList<>();
    private ArrayList<String> wednesday = new ArrayList<>();
    private ArrayList<String> thursday = new ArrayList<>();
    private ArrayList<String> friday = new ArrayList<>();
    private ArrayList<String> saturday = new ArrayList<>();
    private ArrayList<String> sunday = new ArrayList<>();

    public Week(){}

    public void addMon(String exercise){
        this.monday.add(exercise);
    }
    public void addTues(String exercise){
        this.tuesday.add(exercise);
    }
    public void addWednes(String exercise){
        this.wednesday.add(exercise);
    }
    public void addThurs(String exercise){
        this.thursday.add(exercise);
    }
    public void addFri(String exercise){
        this.friday.add(exercise);
    }
    public void addSat(String exercise){
        this.saturday.add(exercise);
    }
    public void addSun(String exercise){
        this.sunday.add(exercise);
    }

    public ArrayList<String> getMon(){
        return this.monday;
    }
    public ArrayList<String> getTues(){
        return this.tuesday;
    }
    public ArrayList<String> getWed(){
        return this.wednesday;
    }
    public ArrayList<String> getThur(){
        return this.thursday;
    }
    public ArrayList<String> getFri(){
        return this.friday;
    }
    public ArrayList<String> getSat(){
        return this.saturday;
    }
    public ArrayList<String> getSun(){
        return this.saturday;
    }

    public void updateSchedule(){
        this.schedule.clear();
        this.schedule.add(monday);
        this.schedule.add(tuesday);
        this.schedule.add(wednesday);
        this.schedule.add(thursday);
        this.schedule.add(friday);
        this.schedule.add(saturday);
        this.schedule.add(sunday);
    }
    public ArrayList<String> getSunday(){
        return this.sunday;
    }


    public ArrayList<ArrayList<String>> getSchedule(){
        return this.schedule;
    }
}
