package com.example.school.service;

import com.example.school.exception.ApiException;
import com.example.school.model.Teacher;
import com.example.school.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher, Integer id) {
        Teacher oldTeacher = teacherRepository.getById(id);
        oldTeacher.setID(teacher.getID());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }


    public void deleteTeacher(Integer id) {
        Teacher myTeacher=teacherRepository.getById(id);
        teacherRepository.delete(myTeacher);
    }

    public Teacher getTeacherByID(Integer id) {
        Teacher teacher = teacherRepository.findTeacherByID(id);

        if( teacher == null){
            throw new ApiException("Invalid teacher id");
        }
        return teacher;
    }

    public List<Teacher> getAllTeacherBySalary(Integer salary) {

        List<Teacher> teacher = teacherRepository.findBySalaryGreaterThanEqual(salary);

        if( teacher == null ){
            throw new ApiException("Invalid salary");
        }
        return teacher;
    }

}
