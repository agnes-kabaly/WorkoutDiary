package com.alice.WorkoutDiary.dao;

import com.alice.WorkoutDiary.model.WorkoutDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Long> {

    WorkoutDay findByDayId(Integer id);
    WorkoutDay save(WorkoutDay workoutDay);
    void delete(WorkoutDay workoutDay);

}
