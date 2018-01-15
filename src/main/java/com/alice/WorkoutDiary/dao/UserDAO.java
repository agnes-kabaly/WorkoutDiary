package com.alice.WorkoutDiary.dao;

import com.alice.WorkoutDiary.model.User;

public interface UserDAO {

    void saveUser(User user);
    User getUser(int id);


}
