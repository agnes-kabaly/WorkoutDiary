package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.model.WorkoutDay;
import com.alice.WorkoutDiary.service.WorkoutDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public ResponseEntity<String> addNewDay(@RequestBody WorkoutDay workoutDay) {
        try {
            workoutDayService.addNewDay(workoutDay);
            return ResponseEntity.ok().body(String.format("New day added, with day name: %s", workoutDay.getDayName()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Day save isn't success.");
        }
    }
}
