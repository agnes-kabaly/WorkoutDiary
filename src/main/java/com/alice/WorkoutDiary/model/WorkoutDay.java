package com.alice.WorkoutDiary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WorkoutDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "day_id")
    private int dayId;

    private String dayName;

    @JsonIgnoreProperties("workoutDay")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "day_exercise",
            joinColumns = {@JoinColumn(name = "workout_id") },
            inverseJoinColumns = { @JoinColumn(name = "day_id") })
    private Set<WorkoutExercise> workouts = new HashSet<>();

    public Set<WorkoutExercise> getWorkouts() {
        return workouts;
    }

    @JsonDeserialize(as = HashSet.class)
    public void setWorkouts(Set<WorkoutExercise> days) {
        this.workouts = workouts;
    }

    public void addWorkouts(WorkoutExercise workout) {
        this.workouts.add(workout);
    }

    public void deleteWorkout(WorkoutExercise workout) {
        this.workouts.remove(workout);
    }

    public WorkoutDay() {
    }

    public WorkoutDay(String dayName) {
        this.dayName = dayName;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

}
