package ca.vanier.vanierapi.service;

import java.util.List;
import java.util.Optional;

import ca.vanier.vanierapi.entity.Course;

public interface CourseService {
    List<Course> getAllCourse();

    Course addCourse(Course course);

    Optional<Course> findCourseById(Long id) ;

    Course getCourseById(Long id);

    void deleteCourseById(Long id);

    Course updateCourseById(Course course,Long id);
}
