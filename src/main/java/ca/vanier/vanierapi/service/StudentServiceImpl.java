package ca.vanier.vanierapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.vanierapi.entity.Student;
import ca.vanier.vanierapi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    //Get all Students
    @Override
    public List<Student> getAllStudents() {
        return (List<Student>)studentRepository.findAll();
    }

    //Add a new student
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    //Search a student by Id
    @Override
    public Student getStudentById(Long id) {
        Student student=studentRepository.findById(id).get();
        return student;
    }
    @Override
    public Optional<Student> findStudentById(Long id) { 
        return studentRepository.findById(id);
    }
    
    //Delete a student by Id
    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    //Update a student
    @Override
    public Student updateStudentById(Student student, Long id) {
        Student newStudent=studentRepository.findById(id).get();
        //validation
        newStudent.setStu_fName(student.getStu_fName());
        newStudent.setStu_lName(student.getStu_lName());
        newStudent.setStu_email(student.getStu_email());
        
        return studentRepository.save(newStudent);
    }


}
