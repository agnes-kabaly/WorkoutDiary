package com.alice.WorkoutDiary;

import com.alice.WorkoutDiary.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.transaction.Transactional;

@SpringBootApplication
public class WorkoutDiaryApplication implements ServletContextListener {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutDiaryApplication.class, args);
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		User user1 = new User();

		user1.setUsername("Ági");

		user1.setEmail("vm@vm.com");

		user1.setPassword("123");

		entityManager.persist(user1);


	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
