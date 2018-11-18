package com.alice.WorkoutDiary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
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

    public void setDate() {
        Date dateToFormat = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date = sdf.format(dateToFormat);
        setRegDate(date);
    }

    public void addDays(WorkoutDay day) {
        this.days.add(day);
    }

    public void deleteDay(WorkoutDay day) {
        this.days.remove(day);
    }

    public void addCalendars(Calendar calendar) { this.calendars.add(calendar); }


}
