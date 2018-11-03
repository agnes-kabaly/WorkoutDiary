package com.alice.WorkoutDiary.dao;

import com.alice.WorkoutDiary.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    Calendar findByCalendarId(Integer id);
    Calendar save(Calendar calendar);

}
