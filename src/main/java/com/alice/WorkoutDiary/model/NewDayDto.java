package com.alice.WorkoutDiary.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Set;

@Data
public class NewDayDto {

    @JsonProperty("workoutDay")
    private WorkoutDay workoutDay;

    @JsonProperty("exercises")
    private Set<WorkoutExercise> workouts;

}
