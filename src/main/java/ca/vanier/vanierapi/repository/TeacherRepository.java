package ca.vanier.vanierapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.vanierapi.entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Long> {
    
}
