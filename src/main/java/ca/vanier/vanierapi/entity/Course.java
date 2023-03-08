package ca.vanier.vanierapi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue
    private Long c_Id;
    private String c_Name;

    //one course has maximun one teacher,so it is one to one relationship
    @OneToOne(targetEntity = Teacher.class,cascade = {CascadeType.ALL})
    private Teacher teacher;

    //one course can have less than 30 students,so it is one to many relationship
    @OneToMany(targetEntity = Student.class,cascade = {CascadeType.ALL})
    private List<Student> student;

}
