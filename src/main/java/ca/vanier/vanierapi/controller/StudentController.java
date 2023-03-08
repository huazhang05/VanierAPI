package ca.vanier.vanierapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.vanierapi.entity.Student;
import ca.vanier.vanierapi.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping("/AllStudents")
    public List<Student> StudentList() {
        return studentService.getAllStudents();
    }

    // Search student by Id
    @GetMapping("/SearchStudentById/{id}")
    public Student SearchStudentById(@PathVariable long id) {
        if (!studentService.findStudentById(id).isPresent())
            return null;
        else {
            return studentService.getStudentById(id);            
        }
    }

    // Add a new student
    @PostMapping("/AddStudent")
    public Student AddStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Update a student
    @PostMapping("/UpdateStudent/{id}")
    public String UpdateStudent(@RequestBody Student student, @PathVariable long id) {
        if (!studentService.findStudentById(id).isPresent())
            return "Student not found";
        else {
            studentService.updateStudentById(student, id);
            return "Success updated";
        }
    }

    // Delete a student by Id
    @DeleteMapping("/DeleteStudentById/{id}")
    public String DeleteStudentById(@PathVariable long id) {
        if (!studentService.findStudentById(id).isPresent())
            return "Student not found";
        else {
            studentService.deleteStudentById(id);
            return "Success deleted";
        }
    }
}
