package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.model.User;
import com.alice.WorkoutDiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/")
    public ResponseEntity<String> returnAString() {
        return ResponseEntity.ok(userService.returnAString());
       // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ResponseEntity<String> welcome(@RequestParam(value="username", required = false, defaultValue = "World") String name) {
        return ResponseEntity.ok(userService.welcome(name));
    }

    //teszt postmannel
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<?> testMethod(@RequestBody Map<String, Object> valami) {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/findByName")
    public ResponseEntity<User> findByUserName(@RequestParam(required = true, value = "user_name") String user_name) {
        User user;
        try {
            user = userService.findByUserName(user_name);
            return ResponseEntity.ok(user);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/getUserById")
    public ResponseEntity<User> findById(@RequestParam(required = true, value = "id") Integer userId) {
        User user;
        try {
            user = userService.findById(userId);
            return ResponseEntity.ok(user);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/regUser", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.emailNotExist(user.getEmail())) {
            user.setDate();
            System.out.println("I GOT THE USER: " + user);
            userService.registerUser(user);
            return ResponseEntity.ok().body(String.format("Registration was success, with username: %s", user.getUserName()));
        } else {
            return ResponseEntity.status(500).body(String.format("Registration failed. Email address %s is already exist.", user.getEmail()));
        }
    }

}
