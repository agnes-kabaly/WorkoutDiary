package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.model.WorkoutDay;
import com.alice.WorkoutDiary.model.WorkoutExercise;
import com.alice.WorkoutDiary.service.WorkoutDayService;
import com.alice.WorkoutDiary.service.WorkoutExerciseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
public class WorkoutDayController {

    @Autowired
    WorkoutDayService workoutDayService;

    @Autowired
    WorkoutExerciseService workoutExerciseService;

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
            LinkedHashMap<Object, Object> linedExercises = (LinkedHashMap) json.get("exercises");
            ArrayList<Object> myList = (ArrayList) linedExercises.get("exercises");
            for (Object obj : myList) {
                WorkoutExercise workoutExercise = mapper.convertValue(obj, WorkoutExercise.class);
                workoutExerciseService.addExercise(workoutExercise);
                workoutDay.addWorkouts(workoutExercise);
            }
            workoutDayService.addNewDay(workoutDay);
            workoutDayService.userCreateNewDay(userId, workoutDay);
            return ResponseEntity.ok().body(String.format("New day added, with day name: %s", workoutDay.getDayName()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Day save wasn't successful.");
        }
    }
}
