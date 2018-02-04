package com.alice.WorkoutDiary;

import com.alice.WorkoutDiary.model.User;
import com.alice.WorkoutDiary.model.WorkoutDay;
import com.alice.WorkoutDiary.model.WorkoutExercise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
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

		user1.setUserName("Alice");

		user1.setEmail("minta@minta.com");

		user1.setPassword("1235678");

		user1.setRegDate("2018-01-24 11:39:28");

		user1.setImage("http://cdn.blog.hu/fu/fulesbagoly/image/marilyn-manson_1.jpg");

		entityManager.persist(user1);

		WorkoutDay workoutDay1 = new WorkoutDay();
		WorkoutDay workoutDay2 = new WorkoutDay();
		WorkoutDay workoutDay3 = new WorkoutDay();

		workoutDay1.setDayName("Leg Day");
		workoutDay2.setDayName("Back Day");
		workoutDay3.setDayName("Abs Day");

		user1.addDays(workoutDay1);
		user1.addDays(workoutDay2);
		user1.addDays(workoutDay3);

		WorkoutExercise exercise1 = new WorkoutExercise();
		WorkoutExercise exercise2 = new WorkoutExercise();
		WorkoutExercise exercise3 = new WorkoutExercise();
		WorkoutExercise exercise4 = new WorkoutExercise();
		WorkoutExercise exercise5 = new WorkoutExercise();
		WorkoutExercise exercise6 = new WorkoutExercise();

		WorkoutExercise exercise7 = new WorkoutExercise();
		WorkoutExercise exercise8 = new WorkoutExercise();
		WorkoutExercise exercise9 = new WorkoutExercise();
		WorkoutExercise exercise10 = new WorkoutExercise();
		WorkoutExercise exercise11 = new WorkoutExercise();
		WorkoutExercise exercise12 = new WorkoutExercise();
		WorkoutExercise exercise13 = new WorkoutExercise();
		WorkoutExercise exercise14 = new WorkoutExercise();

		WorkoutExercise exercise15 = new WorkoutExercise();

		exercise1.setWorkoutName("Thigh Abductor");
		exercise2.setWorkoutName("Squats");
		exercise3.setWorkoutName("Lunges");
		exercise4.setWorkoutName("Romanian Deadlift");
		exercise5.setWorkoutName("Calf Raises");
		exercise6.setWorkoutName("Abdominal Crunch");

		exercise7.setWorkoutName("Pull Ups");
		exercise8.setWorkoutName("Barbell Row");
		exercise9.setWorkoutName("Wide Grip Lat Pulldown");
		exercise10.setWorkoutName("One Arm Dumbbell Row");
		exercise11.setWorkoutName("Seated Cable Row");
		exercise12.setWorkoutName("Hyperextensions");
		exercise13.setWorkoutName("Upright Row");
		exercise14.setWorkoutName("Triceps Dips");

		exercise15.setWorkoutName("Abdominal Crunch2");

		exercise1.setWeight(30);
		exercise2.setWeight(0);
		exercise3.setWeight(5);
		exercise4.setWeight(15);
		exercise5.setWeight(4);
		exercise6.setWeight(0);

		exercise7.setWeight(0);
		exercise8.setWeight(15);
		exercise9.setWeight(15);
		exercise10.setWeight(3);
		exercise11.setWeight(15);
		exercise12.setWeight(0);
		exercise13.setWeight(3);
		exercise14.setWeight(3);

		exercise14.setWeight(0);

		exercise1.setWorkoutSet(4);
		exercise2.setWorkoutSet(4);
		exercise3.setWorkoutSet(4);
		exercise4.setWorkoutSet(3);
		exercise5.setWorkoutSet(4);
		exercise6.setWorkoutSet(3);

		exercise7.setWorkoutSet(3);
		exercise8.setWorkoutSet(3);
		exercise9.setWorkoutSet(3);
		exercise10.setWorkoutSet(3);
		exercise11.setWorkoutSet(3);
		exercise12.setWorkoutSet(4);
		exercise13.setWorkoutSet(3);
		exercise14.setWorkoutSet(3);

		exercise15.setWorkoutSet(4);

		exercise1.setRep(20);
		exercise2.setRep(12);
		exercise3.setRep(20);
		exercise4.setRep(16);
		exercise5.setRep(20);
		exercise6.setRep(24);

		exercise7.setRep(10);
		exercise8.setRep(10);
		exercise9.setRep(10);
		exercise10.setRep(12);
		exercise11.setRep(12);
		exercise12.setRep(20);
		exercise13.setRep(10);
		exercise14.setRep(10);

		exercise15.setRep(20);

		workoutDay1.addWorkouts(exercise1);
		workoutDay1.addWorkouts(exercise2);
		workoutDay1.addWorkouts(exercise3);
		workoutDay1.addWorkouts(exercise4);
		workoutDay1.addWorkouts(exercise5);
		workoutDay1.addWorkouts(exercise6);

		workoutDay2.addWorkouts(exercise7);
		workoutDay2.addWorkouts(exercise8);
		workoutDay2.addWorkouts(exercise9);
		workoutDay2.addWorkouts(exercise10);
		workoutDay2.addWorkouts(exercise11);
		workoutDay2.addWorkouts(exercise12);
		workoutDay2.addWorkouts(exercise13);
		workoutDay2.addWorkouts(exercise14);

		workoutDay3.addWorkouts(exercise15);

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
