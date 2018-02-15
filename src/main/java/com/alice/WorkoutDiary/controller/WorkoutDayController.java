package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.model.WorkoutDay;
import com.alice.WorkoutDiary.service.WorkoutDayService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class WorkoutDayController {

    @Autowired
    WorkoutDayService workoutDayService;

    @RequestMapping(value = "/getDayById")
    public ResponseEntity<WorkoutDay> findById(@RequestParam(required = true, value = "id") Integer dayId) {
        WorkoutDay workoutDay;
        try {
            workoutDay = workoutDayService.findById(dayId);
            return ResponseEntity.ok(workoutDay);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/addNewDay", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> addNewDay(@RequestBody Map<String, Object> json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            WorkoutDay workoutDay = mapper.convertValue(json.get("workoutDay"), WorkoutDay.class);
            LinkedHashMap<?, ?> linedUser = (LinkedHashMap) json.get("userId");
            Integer userId = mapper.convertValue(linedUser.get("userId"), Integer.class);
            workoutDayService.addNewDay(workoutDay);
            workoutDayService.userCreateNewDay(userId, workoutDay);
            return ResponseEntity.ok().body(String.format("New day added, with day name: %s", workoutDay.getDayName()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Day save wasn't successful.");
        }
    }
}
