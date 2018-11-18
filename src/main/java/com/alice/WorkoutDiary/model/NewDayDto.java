package com.alice.WorkoutDiary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class NewDayDto {

    @JsonProperty("workoutDay")
    private WorkoutDay workoutDay;

    @JsonProperty("exercises")
    private Set<WorkoutExercise> workouts;

    public WorkoutDay getWorkoutDay() {
        return workoutDay;
    }

    public Set<WorkoutExercise> getWorkouts() {
        return workouts;
    }

}
