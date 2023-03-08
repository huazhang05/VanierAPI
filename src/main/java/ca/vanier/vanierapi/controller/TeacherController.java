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

import ca.vanier.vanierapi.entity.Teacher;
import ca.vanier.vanierapi.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    // Get all teachers
    @GetMapping("/AllTeachers")
    public List<Teacher> TeacherList() {
        return teacherService.getAllTeacher();
    }

    // Search Teacher by Id
    @GetMapping("/SearchTeacherById/{id}")
    public Teacher SearchTeacherById(@PathVariable long id) {
        if (!teacherService.findTeacherById(id).isPresent())
            return null;
        else {
            return teacherService.getTeacherById(id);
        }
    }

    // Add a new teacher
    @PostMapping("/AddTeacher")
    public Teacher AddTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    // Update a teacher
    @PostMapping("/UpdateTeacher/{id}")
    public String UpdateTeacher(@RequestBody Teacher teacher, @PathVariable long id) {
        if (!teacherService.findTeacherById(id).isPresent())
            return "Teacher not found";
        else {
            teacherService.updateTeacherById(teacher, id);
            return "Success updated";
        }
    }

    // Delete a teacher by Id
    @DeleteMapping("/DeleteTeacherById/{id}")
    public String DeleteTeacherById(@PathVariable long id) {
        if (!teacherService.findTeacherById(id).isPresent())
            return "Teacher not found";
        else {
            teacherService.deleteTeacherById(id);
            return "Success deleted";
        }
    }
}
