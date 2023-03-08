package ca.vanier.vanierapi.service;

import java.util.List;
import java.util.Optional;

import ca.vanier.vanierapi.entity.Student;

public interface StudentService {   

    List<Student> getAllStudents();

    Student addStudent(Student student);

    Optional<Student> findStudentById(Long id) ;

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

    Student updateStudentById(Student student,Long id);
}
