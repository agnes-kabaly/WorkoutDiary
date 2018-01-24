package com.alice.WorkoutDiary.model;

import javax.persistence.*;

@Entity
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "workout_id")
    private int workoutId;

    private String workoutName;

    private int weight;

    private int workoutSet;

    private int rep;

    public WorkoutExercise() {
    }

    public WorkoutExercise(String workoutName, int weight, int workoutSet, int rep) {
        this.workoutName = workoutName;
        this.weight = weight;
        this.workoutSet = workoutSet;
        this.rep = rep;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public int getWeight() {
        return weight;
    }

    public int getWorkoutSet() {
        return workoutSet;
    }

    public int getRep() {
        return rep;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWorkoutSet(int workoutSet) {
        this.workoutSet = workoutSet;
    }

    public void setRep(int rep) {
        this.rep = rep;
    }

}
