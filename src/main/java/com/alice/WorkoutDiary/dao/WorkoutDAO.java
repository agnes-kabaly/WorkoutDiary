package com.alice.WorkoutDiary.dao;

import com.alice.WorkoutDiary.model.WorkoutDay;

public interface WorkoutDAO {

    void saveWorkoutDay(WorkoutDay wD);
    WorkoutDay getWorkoutDay(int id);

}
