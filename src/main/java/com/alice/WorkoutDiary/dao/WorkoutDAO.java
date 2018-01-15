package com.alice.WorkoutDiary.dao;

import com.alice.WorkoutDiary.model.Workout;

public interface WorkoutDAO {

    void saveWorkoutDay(Workout wD);
    Workout getWorkoutDay(int id);

}
