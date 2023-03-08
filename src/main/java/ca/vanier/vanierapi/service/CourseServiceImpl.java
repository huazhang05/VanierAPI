package ca.vanier.vanierapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.vanierapi.entity.Course;
import ca.vanier.vanierapi.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    //Get all Course
    @Override
    public List<Course> getAllCourse() {
        return (List<Course>)courseRepository.findAll();
    }

    //Add a new Course
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);        
    }

    //Search a Course by Id
    @Override
    public Course getCourseById(Long id) {
        Course course=courseRepository.findById(id).get();
        return course;
    }
    @Override
    public Optional<Course> findCourseById(Long id) { 
        return courseRepository.findById(id);
    }
    
    //Delete a Course by Id
    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    //Update a Course
    @Override
    public Course updateCourseById(Course course, Long id) {
        Course newCourse=courseRepository.findById(id).get();
        //validation
        newCourse.setStudent(course.getStudent());
        newCourse.setTeacher(course.getTeacher());
        return courseRepository.save(newCourse);
    }
}
