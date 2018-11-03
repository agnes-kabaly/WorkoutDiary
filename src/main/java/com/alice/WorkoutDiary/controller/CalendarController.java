package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.model.Calendar;
import com.alice.WorkoutDiary.service.CalendarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @RequestMapping(value = "/getCalendarById")
    public ResponseEntity<Calendar> findById(@RequestParam(required = true, value = "id") Integer calendarId) {
        Calendar calendar;
        try {
            calendar = calendarService.findById(calendarId);
            return ResponseEntity.ok(calendar);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/addCalendar", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> addCalendar(@RequestBody Map<String, Object> json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Calendar calendar = mapper.convertValue(json.get("calendar"), Calendar.class);
            LinkedHashMap<?, ?> linkedUser = (LinkedHashMap) json.get("userId");
            Integer userId = mapper.convertValue(linkedUser.get("userId"), Integer.class);
            calendarService.addNewCalendar(calendar);
            calendarService.userCreateNewCalendar(userId, calendar);
            return ResponseEntity.ok().body(String.format("Calendar date added with status: %s", calendar.getState()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to save Calendar.");
        }
    }

}
