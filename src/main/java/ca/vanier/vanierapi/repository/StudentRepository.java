package ca.vanier.vanierapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.vanier.vanierapi.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    
}
