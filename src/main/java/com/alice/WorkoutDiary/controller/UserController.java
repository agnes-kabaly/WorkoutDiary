package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.dao.UserRepository;
import com.alice.WorkoutDiary.model.User;
import com.alice.WorkoutDiary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public User findByUserName(@RequestParam(required = true, value = "user_name") String user_name) {
        return userService.findByUserName(user_name);
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

}
