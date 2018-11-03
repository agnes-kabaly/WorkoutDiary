package com.alice.WorkoutDiary.service;

import com.alice.WorkoutDiary.dao.CalendarRepository;
import com.alice.WorkoutDiary.model.Calendar;
import com.alice.WorkoutDiary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    UserService userService;

    public Calendar findById(Integer calendarId) throws IOException {
        if (calendarRepository.findByCalendarId(calendarId) != null) {
            return calendarRepository.findByCalendarId(calendarId);
        } else {
            throw new IOException();
        }
    }

    public void addNewCalendar(Calendar calendar) throws IOException {
        if (calendarRepository.save(calendar) != null) {
            calendarRepository.save(calendar);
        } else {
            throw new IOException();
        }
    }

    public void userCreateNewCalendar(Integer userId, Calendar calendar) {
        User user;
        try {
            user = userService.findById(userId);
            user.addCalendars(calendar);
            userService.registerUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
