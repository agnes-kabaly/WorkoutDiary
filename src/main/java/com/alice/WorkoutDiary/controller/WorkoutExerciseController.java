package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.model.WorkoutExercise;
import com.alice.WorkoutDiary.service.WorkoutExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class WorkoutExerciseController {

    @Autowired
    WorkoutExerciseService workoutExerciseService;

    @RequestMapping(value = "/addExercise", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> addExercise(@RequestBody WorkoutExercise workoutExercise) {
        try {
            workoutExerciseService.addExercise(workoutExercise);
            return ResponseEntity.ok().body(String.format("Exercise added, with name: %s", workoutExercise.getWorkoutName()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to save Exercise.");
        }
    }

    @RequestMapping(value = "/getExerciseByKey")
    public ResponseEntity<WorkoutExercise> findByKey(@RequestParam(required = true, value = "key") String key) {
        WorkoutExercise workoutExercise;
        try {
            workoutExercise = workoutExerciseService.findByKey(key);
            return ResponseEntity.ok(workoutExercise);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/editExercise", consumes = "application/json")
    public ResponseEntity<String> updateExercise(@RequestBody WorkoutExercise workoutExercise) {
        WorkoutExercise exercise;
        try {
            exercise = workoutExerciseService.findByKey(workoutExercise.getKey());
            exercise.setKey(workoutExercise.getKey());
            exercise.setWorkoutName(workoutExercise.getWorkoutName());
            exercise.setWeight(workoutExercise.getWeight());
            exercise.setWorkoutSet(workoutExercise.getWorkoutSet());
            exercise.setRep(workoutExercise.getRep());
            workoutExerciseService.addExercise(exercise);
            return ResponseEntity.ok().body(String.format("Exercise: %s, Updated", exercise.getWorkoutName()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to update Exercise.");
        }
    }


}
