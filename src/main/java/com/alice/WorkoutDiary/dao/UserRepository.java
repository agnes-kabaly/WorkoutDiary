package com.alice.WorkoutDiary.dao;

import com.alice.WorkoutDiary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    User findByUserId(Integer userId);
    User save(User user);

}
