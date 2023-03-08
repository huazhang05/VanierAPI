package ca.vanier.vanierapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.vanierapi.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {
    
}
