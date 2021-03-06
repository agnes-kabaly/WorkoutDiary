package com.alice.WorkoutDiary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


}
