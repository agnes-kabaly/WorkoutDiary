package com.alice.WorkoutDiary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class WorkoutDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "day_id")
    private int dayId;

    private String dayName;

    private String color;

    @JsonIgnoreProperties("workoutDay")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "day_exercise",
            joinColumns = {@JoinColumn(name = "day_id") },
            inverseJoinColumns = { @JoinColumn(name = "workout_id") })
    private Set<WorkoutExercise> workouts = new HashSet<>();

    public Set<WorkoutExercise> getWorkouts() {
        return workouts;
    }

    @JsonDeserialize(as = HashSet.class)
    public void setWorkouts(Set<WorkoutExercise> workouts) {
        this.workouts = workouts;
    }

    public void addWorkouts(WorkoutExercise workout) {
        this.workouts.add(workout);
    }

    public void deleteWorkout(WorkoutExercise workout) {
        this.workouts.remove(workout);
    }

}
