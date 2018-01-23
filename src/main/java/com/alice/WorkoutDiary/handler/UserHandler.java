package com.alice.WorkoutDiary.handler;

import com.alice.WorkoutDiary.dao.UserDAO;
import com.alice.WorkoutDiary.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserHandler implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        String query = String.format("SELECT u FROM %s u WHERE id = %s", User.class.getName(), id);
        User user = entityManager.createQuery(query, User.class).getSingleResult();
        return user;
    }

}
