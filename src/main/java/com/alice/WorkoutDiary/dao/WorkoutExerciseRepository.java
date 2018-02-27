package com.alice.WorkoutDiary.dao;

import com.alice.WorkoutDiary.model.WorkoutExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutExerciseRepository extends JpaRepository<WorkoutExercise, Long> {

    WorkoutExercise save(WorkoutExercise workoutExercise);
    WorkoutExercise findByKey(String key);

}
