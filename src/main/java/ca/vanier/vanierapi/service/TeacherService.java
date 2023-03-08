package ca.vanier.vanierapi.service;

import java.util.List;
import java.util.Optional;

import ca.vanier.vanierapi.entity.Teacher;

public interface TeacherService {
    List<Teacher> getAllTeacher();

    Teacher addTeacher(Teacher teacher);

    Optional<Teacher> findTeacherById(Long id) ;

    Teacher getTeacherById(Long id);

    void deleteTeacherById(Long id);

    Teacher updateTeacherById(Teacher teacher,Long id);
}
