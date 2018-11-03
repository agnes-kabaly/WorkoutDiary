package com.alice.WorkoutDiary;

import com.alice.WorkoutDiary.model.*;
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

		user1.setEmail("alice@minta.com");

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

		workoutDay1.setColor("yellow");
		workoutDay2.setColor("green");
		workoutDay3.setColor("purple");

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

		exercise1.setKey("abcd123");
		exercise2.setKey("efgh123");
		exercise3.setKey("abcd4567");
		exercise4.setKey("abpqrs13");
		exercise5.setKey("abxyzs238");
		exercise6.setKey("nmpqr3987");

		exercise1.setWorkoutName("Thigh Abductor");
		exercise2.setWorkoutName("Squats");
		exercise3.setWorkoutName("Lunges");
		exercise4.setWorkoutName("Romanian Deadlift");
		exercise5.setWorkoutName("Calf Raises");
		exercise6.setWorkoutName("Abdominal Crunch");

		exercise7.setKey("98765kpqr");
		exercise8.setKey("2589hdkl");
		exercise9.setKey("678sdhel");
		exercise10.setKey("mnkbjh8798");
		exercise11.setKey("jkjkjk89");
		exercise12.setKey("26hd7j8k8");
		exercise13.setKey("3h4km5km5");
		exercise14.setKey("7f7djsk888");

		exercise7.setWorkoutName("Pull Ups");
		exercise8.setWorkoutName("Barbell Row");
		exercise9.setWorkoutName("Wide Grip Lat Pulldown");
		exercise10.setWorkoutName("One Arm Dumbbell Row");
		exercise11.setWorkoutName("Seated Cable Row");
		exercise12.setWorkoutName("Hyperextensions");
		exercise13.setWorkoutName("Upright Row");
		exercise14.setWorkoutName("Triceps Dips");

		exercise15.setKey("8d8d8d8d8");

		exercise15.setWorkoutName("Abdominal Crunch2");

		exercise1.setWeight("30 kg");
		exercise2.setWeight("0 kg");
		exercise3.setWeight("5 kg");
		exercise4.setWeight("15 kg");
		exercise5.setWeight("4 kg");
		exercise6.setWeight("0 kg");

		exercise7.setWeight("0 kg");
		exercise8.setWeight("15 kg");
		exercise9.setWeight("15 kg");
		exercise10.setWeight("3 kg");
		exercise11.setWeight("15 kg");
		exercise12.setWeight("0 kg");
		exercise13.setWeight("3 kg");
		exercise14.setWeight("3 kg");

		exercise15.setWeight("0 kg");

		exercise1.setWorkoutSet("4 x");
		exercise2.setWorkoutSet("4 x");
		exercise3.setWorkoutSet("4 x");
		exercise4.setWorkoutSet("3 x");
		exercise5.setWorkoutSet("4 x");
		exercise6.setWorkoutSet("3 x");

		exercise7.setWorkoutSet("3 x");
		exercise8.setWorkoutSet("3 x");
		exercise9.setWorkoutSet("3 x");
		exercise10.setWorkoutSet("3 x");
		exercise11.setWorkoutSet("3 x");
		exercise12.setWorkoutSet("4 x");
		exercise13.setWorkoutSet("3 x");
		exercise14.setWorkoutSet("3 x");

		exercise15.setWorkoutSet("4 x");

		exercise1.setRep("20 db");
		exercise2.setRep("12 db");
		exercise3.setRep("20 db");
		exercise4.setRep("16 db");
		exercise5.setRep("20 db");
		exercise6.setRep("24 db");

		exercise7.setRep("10 db");
		exercise8.setRep("10 db");
		exercise9.setRep("10 db");
		exercise10.setRep("12 db");
		exercise11.setRep("12 db");
		exercise12.setRep("20 db");
		exercise13.setRep("10 db");
		exercise14.setRep("10 db");

		exercise15.setRep("20 db");

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

		Calendar calendar1 = new Calendar();
		Calendar calendar2 = new Calendar();
		Calendar calendar3 = new Calendar();
		Calendar calendar4 = new Calendar();

		calendar1.setDate("2018-11-14");
		calendar2.setDate("2018-11-15");
		calendar3.setDate("2018-11-16");
		calendar4.setDate("2018-11-20");

		calendar1.setState(State.COMPLETED);
		calendar2.setState(State.ABORTED);
		calendar3.setState(State.IMPROVED);
		calendar4.setState(State.DESCENDED);

		calendar1.setColor("yellow");
		calendar2.setColor("green");
		calendar3.setColor("purple");
		calendar4.setColor("green");

		user1.addCalendars(calendar1);
		user1.addCalendars(calendar2);
		user1.addCalendars(calendar3);
		user1.addCalendars(calendar4);

	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
