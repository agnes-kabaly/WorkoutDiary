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

    public User findByUserName(String user_name) throws IOException {
        if (userRepository.findByUserName(user_name) != null) {
            return userRepository.findByUserName(user_name);
        } else {
            throw new IOException();
        }
    }

}
