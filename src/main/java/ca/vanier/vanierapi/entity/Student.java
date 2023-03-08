package ca.vanier.vanierapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    private Long stu_Id;
    private String stu_fName;
    private String stu_lName;
    private String stu_email;
}
