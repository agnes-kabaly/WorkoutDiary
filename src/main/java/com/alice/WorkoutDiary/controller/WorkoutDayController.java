package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.model.NewDayDto;
import com.alice.WorkoutDiary.model.WorkoutDay;
import com.alice.WorkoutDiary.model.WorkoutExercise;
import com.alice.WorkoutDiary.service.WorkoutDayService;
import com.alice.WorkoutDiary.service.WorkoutExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public ResponseEntity<String> addNewDay(@RequestParam(value = "userId") Integer userId, @RequestBody NewDayDto newDayDto) {
        try {
            newDayDto.getWorkoutDay().setWorkouts(newDayDto.getWorkouts());
            for (WorkoutExercise workoutExercise : newDayDto.getWorkouts()) {
                workoutExerciseService.addExercise(workoutExercise);
            }
            workoutDayService.userCreateNewDay(userId, newDayDto.getWorkoutDay());
            return ResponseEntity.ok().body(String.format("New day added, with day name: %s", newDayDto.getWorkoutDay().getDayName()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Day save wasn't successful.");
        }
    }
}
