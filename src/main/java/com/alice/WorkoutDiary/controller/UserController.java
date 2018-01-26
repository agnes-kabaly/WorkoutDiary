package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.dao.UserRepository;
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
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @RequestMapping(value = "/")
    public String returnAString() {
         return "first page with some text";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(@RequestParam(value="username", required = false, defaultValue = "World") String name) {
        return "Hello " + name + " * - *";
    }

    @RequestMapping(value = "/findByName")
    public ResponseEntity<User> findByUserName(@RequestParam(required = true, value = "user_name") String user_name) {
        User user;
        try {
            user = userService.findByUserName(user_name);
            return ResponseEntity.ok(user);
        } catch (IOException e) {
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/getUserById")
    public User findById(@RequestParam(required = true, value = "id") Integer userId) {
        return userRepository.findByUserId(userId);
    }

    @RequestMapping(value = "/regUser", method = RequestMethod.POST, consumes = "application/json")
    public User saveUser(@RequestBody User user) {
        user.setDate();
        System.out.println("I GOT THE USER: " + user);
        return userRepository.save(user);
    }

    //teszt postmannel
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResponseEntity<?> testMethod(@RequestBody Map<String, Object> valami) {
        return ResponseEntity.ok().build();
    }

}
