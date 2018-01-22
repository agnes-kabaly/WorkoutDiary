package com.alice.WorkoutDiary.model;

/*import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity*/
public class WorkoutDay {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    public int dayId;

    public String dayName;
    public int weight;
    public int set;
    public int rep;

}
