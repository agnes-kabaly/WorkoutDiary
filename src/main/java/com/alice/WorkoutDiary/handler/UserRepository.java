package com.alice.WorkoutDiary.handler;

import com.alice.WorkoutDiary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
