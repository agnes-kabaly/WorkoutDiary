package com.alice.WorkoutDiary.model;

import javax.persistence.*;

@Entity
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workout_id")
    private int workoutId;

    @Column(name = "`key`")
    private String key;

    private String workoutName;

    private String weight;

    private String workoutSet;

    private String rep;

    public WorkoutExercise() {
    }

    public WorkoutExercise(String key, String workoutName, String weight, String workoutSet, String rep) {
        this.key = key;
        this.workoutName = workoutName;
        this.weight = weight;
        this.workoutSet = workoutSet;
        this.rep = rep;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public String getWeight() {
        return weight;
    }

    public String getWorkoutSet() {
        return workoutSet;
    }

    public String getRep() {
        return rep;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setWorkoutSet(String workoutSet) {
        this.workoutSet = workoutSet;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
