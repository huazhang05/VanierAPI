package ca.vanier.vanierapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.vanier.vanierapi.entity.Teacher;
import ca.vanier.vanierapi.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;

    //Get all Teacher
    @Override
    public List<Teacher> getAllTeacher() {
        return (List<Teacher>)teacherRepository.findAll();
    }

    //Add a new Teacher
    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    //Search a Teacher by Id
    @Override
    public Teacher getTeacherById(Long id) {
        Teacher teacher=teacherRepository.findById(id).get();
        return teacher;
    }
    @Override
    public Optional<Teacher> findTeacherById(Long id) { 
        return teacherRepository.findById(id);
    }
    
    //Delete a Teacher by Id
    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    //Update a Teacher
    @Override
    public Teacher updateTeacherById(Teacher teacher, Long id) {
        Teacher newTeacher=teacherRepository.findById(id).get();
        //validation
        newTeacher.setT_fName(teacher.getT_fName());
        newTeacher.setT_lName(teacher.getT_lName());
        newTeacher.setT_email(teacher.getT_email());
        
        return teacherRepository.save(newTeacher);
    }
}
