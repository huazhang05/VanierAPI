package ca.vanier.vanierapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue
    private Long t_Id;
    private String t_fName;
    private String t_lName;
    private String t_email;
}
