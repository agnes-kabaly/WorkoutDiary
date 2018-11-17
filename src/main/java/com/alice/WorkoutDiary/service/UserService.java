package com.alice.WorkoutDiary.service;

import com.alice.WorkoutDiary.dao.UserRepository;
import com.alice.WorkoutDiary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String returnAString() {
        return "first page with some text";
    }

    public String welcome(String name) {
        return "Hello " + name + " * - *";
    }

    public User findByUserName(String user_name) throws IOException {
        if (userRepository.findByUserName(user_name) != null) {
            return userRepository.findByUserName(user_name);
        } else {
            throw new IOException();
        }
    }

    public User findById(Integer userId) throws IOException {
        if (userRepository.findByUserId(userId) != null) {
            return userRepository.findByUserId(userId);
        } else {
            throw new IOException();
        }
    }

    public boolean emailNotExist(String email) {
        return userRepository.findByEmail(email) == null;
    }

    public boolean registerUser(User user) {
        return userRepository.save(user) != null;
    }

}
