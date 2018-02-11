package com.alice.WorkoutDiary.service;

import com.alice.WorkoutDiary.dao.WorkoutDayRepository;
import com.alice.WorkoutDiary.model.WorkoutDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WorkoutDayService {

    @Autowired
    WorkoutDayRepository workoutDayRepository;

    public WorkoutDay findById(Integer dayId) throws IOException {
        if(workoutDayRepository.findByDayId(dayId) != null) {
            return workoutDayRepository.findByDayId(dayId);
        } else {
            throw new IOException();
        }
    }

    public void addNewDay(WorkoutDay workoutDay) throws IOException {
        if (workoutDayRepository.save(workoutDay) != null) {
            workoutDayRepository.save(workoutDay);
        } else {
            throw new IOException();
        }
    }

}