package com.alice.WorkoutDiary.controller;

import com.alice.WorkoutDiary.dao.UserDAO;
import com.alice.WorkoutDiary.handler.UserHandler;
import com.alice.WorkoutDiary.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    UserDAO userHandler = new UserHandler();

    @RequestMapping(value = "/")
    public String returnAString() {
         return "first page with some text";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User returnUser(@RequestParam(required = true, value="id") int id) {
        return userHandler.getUser(id);
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomreReagal(@RequestParam(value="username", required = false, defaultValue = "World") String name) {
        return "Hello " + name + " * - *";
    }

    @RequestMapping(value = "/regUser", method = RequestMethod.POST, consumes = "application/json")
    public void saveUser(@RequestBody User user) {
        userHandler.saveUser(user);
        System.out.println("I GOT THE USER: " + user);
    }

}
