package entity;

import java.util.ArrayList;

public class Week {

    private ArrayList<ArrayList<String>> schedule;

    private ArrayList<String> monday;
    private ArrayList<String> tuesday;
    private ArrayList<String> wednesday;
    private ArrayList<String> thursday;
    private ArrayList<String> friday;
    private ArrayList<String> saturday;
    private ArrayList<String> sunday;

    public Week(){
        this.monday = new ArrayList<>();
        this.tuesday = new ArrayList<>();
        this.wednesday = new ArrayList<>();
        this.thursday = new ArrayList<>();
        this.friday = new ArrayList<>();
        this.saturday = new ArrayList<>();
        this.sunday = new ArrayList<>();
        this.schedule = new ArrayList<>();
    }

    public Week(ArrayList<ArrayList<String>> newSchedule){
        this.schedule = newSchedule;
        this.monday = newSchedule.get(0);
        this.tuesday = newSchedule.get(1);
        this.wednesday = newSchedule.get(2);
        this.thursday = newSchedule.get(3);
        this.friday = newSchedule.get(4);
        this.saturday = newSchedule.get(5);
        this.sunday = newSchedule.get(6);

    };

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


    public ArrayList<ArrayList<String>> getSchedule(){
        return this.schedule;
    }
}
