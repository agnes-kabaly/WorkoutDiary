package com.alice.WorkoutDiary.model;

import javax.persistence.*;

@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "calendar_id")
    private int calendarId;

    private String date;

    @Enumerated
    private State state;

    private String color;

    public Calendar() {
    }

    public Calendar(String date, State state, String color) {
        this.date = date;
        this.state = state;
        this.color = color;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*public void setDayDate() {
        Date dateToFormat = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date = sdf.format(dateToFormat);
        setDate(date);
    }*/

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String  color) {
        this.color = color;
    }

}