package com.alice.WorkoutDiary.service;

import com.alice.WorkoutDiary.dao.WorkoutExerciseRepository;
import com.alice.WorkoutDiary.model.WorkoutExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WorkoutExerciseService {

    @Autowired
    WorkoutExerciseRepository workoutExerciseRepository;

    public void addExercise(WorkoutExercise workoutExercise) throws IOException {
        if (workoutExerciseRepository.save(workoutExercise) != null) {
            workoutExerciseRepository.save(workoutExercise);
        } else {
            throw new IOException();
        }
    }

    public WorkoutExercise findByKey(String key) throws IOException {
        if (workoutExerciseRepository.findByKey(key) != null) {
            return workoutExerciseRepository.findByKey(key);
        } else {
            throw new IOException();
        }
    }

}
