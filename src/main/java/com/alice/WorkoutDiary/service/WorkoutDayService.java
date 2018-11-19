package com.alice.WorkoutDiary.service;

import com.alice.WorkoutDiary.dao.WorkoutDayRepository;
import com.alice.WorkoutDiary.model.User;
import com.alice.WorkoutDiary.model.WorkoutDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WorkoutDayService {

    @Autowired
    WorkoutDayRepository workoutDayRepository;

    @Autowired
    UserService userService;

    public WorkoutDay findById(Integer dayId) throws IOException {
        if(workoutDayRepository.findByDayId(dayId) != null) {
            return workoutDayRepository.findByDayId(dayId);
        } else {
            throw new IOException();
        }
    }

    public boolean addNewDay(WorkoutDay workoutDay) {
        return workoutDayRepository.save(workoutDay) != null;
    }

    public void userCreateNewDay(Integer userId, WorkoutDay workoutDay) throws IOException {
        User user;
        addNewDay(workoutDay);
        try {
            user = userService.findById(userId);
            user.addDays(workoutDay);
            userService.registerUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteDay(Integer userId, Integer dayId) throws IOException {
        User user;
        WorkoutDay workoutDay;
        try {
            workoutDay = findById(dayId);
            user = userService.findById(userId);
            user.getDays().remove(workoutDay);
            workoutDayRepository.delete(workoutDay);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
