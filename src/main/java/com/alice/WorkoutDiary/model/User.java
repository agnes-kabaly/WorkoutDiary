package com.alice.WorkoutDiary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
    @JsonProperty
    private String userName;
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

    private String regDate;

    private String image;

    @JsonIgnoreProperties("user")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_day",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "day_id") })
    private Set<WorkoutDay> days = new HashSet<>();

    @JsonIgnoreProperties("user")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_calendar",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "calendar_id")})
    private Set<Calendar> calendars = new HashSet<>();

    public User() {

    }

    public User(String userName, String email, String password, String regDate) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
    }

    public User(int userId, String userName, String email, String password, String regDate, String image) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        this.image = image;
    }

    public User(int userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(String userName, String email, String password, String regDate, String image, Set<WorkoutDay> days, Set<Calendar> calendars) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        this.image = image;
        this.days = days;
        this.calendars = calendars;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getImage() {
        return image;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public void setDate() {
        Date dateToFormat = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date = sdf.format(dateToFormat);
        setRegDate(date);
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<WorkoutDay> getDays() {
        return days;
    }

    @JsonDeserialize(as = HashSet.class)
    public void setDays(Set<WorkoutDay> days) {
        this.days = days;
    }

    public void addDays(WorkoutDay day) {
        this.days.add(day);
    }

    public void deleteDay(WorkoutDay day) {
        this.days.remove(day);
    }

    @JsonDeserialize(as = HashSet.class)
    public void setCalendars(Set<Calendar> calendars) {this.calendars = calendars; }

    public void addCalendars(Calendar calendar) { this.calendars.add(calendar); }

    public Set<Calendar> getCalendars() {
        return calendars;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", regDate='" + regDate + '\'' +
                ", image='" + image + '\'' +
                ", days=" + days +
                '}';
    }

}
