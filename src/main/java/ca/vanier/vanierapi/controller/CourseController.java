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

import ca.vanier.vanierapi.businessLogic.businessLogic;
import ca.vanier.vanierapi.entity.Course;
import ca.vanier.vanierapi.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // Get all course
    @GetMapping("/AllCourse")
    public List<Course> StudentList() {
        return courseService.getAllCourse();
    }

    // Search course by Id
    @GetMapping("/SearchCourseById/{id}")
    public Course SearchCourseById(@PathVariable long id) {
        if (!courseService.findCourseById(id).isPresent())
            return null;
        else {
            return courseService.getCourseById(id);
        }
    }

    // Add a new course
    @PostMapping("/AddCourse")
    public String AddCourse(@RequestBody Course course) {
        if(businessLogic.isAvailable(course))
        {
            courseService.addCourse(course);
            return "Success. The course added";
        }
        else
        return "One course only can have maximum 30 students";
    }

    // Update a course
    @PostMapping("/UpdateCourse/{id}")
    public String Updatecourse(@RequestBody Course course, @PathVariable long id) {
        if (!courseService.findCourseById(id).isPresent())
            return "Course not found";
        else {
            if(businessLogic.isAvailable(course)){
                courseService.updateCourseById(course,id);
                return "Success updated";
            }
            else
            return "One course only can have maximum 30 students";
        }
    }

    // Delete a Course by Id
    @DeleteMapping("/DeleteCourseById/{id}")
    public String DeleteCourseById(@PathVariable long id) {
        if (!courseService.findCourseById(id).isPresent())
            return "Course not found";
        else {
            courseService.deleteCourseById(id);
            return "Success deleted";
        }
    }
}
