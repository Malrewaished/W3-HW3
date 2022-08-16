package com.example.school.service;

import com.example.school.exception.ApiException;
import com.example.school.model.Student;
import com.example.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Student student, Integer id) {
        Student oldStudent = studentRepository.getById(id);
//        oldStudent.setID(student.getID());
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        studentRepository.save(oldStudent);
    }


    public void deleteStudent(Integer id) {
        Student student = studentRepository.getById(id);
        studentRepository.delete(student);
    }

    public Student findStudentByID(Integer id) {
        Student student = studentRepository.findStudentByID(id);
        if (student == null) {
            throw new ApiException("Invalid student id");
        }
        return student;
    }

    public Student findStudentByName(String name) {
        Student student = studentRepository.findStudentByName(name);
        if (student == null) {
            throw new ApiException("Invalid student name");
        }
        return student;
    }

    public List<Student> findMajorOfStudents(String major) {
        List<Student> student = studentRepository.findAllByMajor(major);
        if (student == null) {
            throw new ApiException("Invalid major");
        }
        return student;
    }

    public List<Student> findByAge(Integer age) {
        List<Student> student = studentRepository.findByAgeGreaterThanEqual(age);

        if( student == null){
            throw new ApiException("Invalid age !");
        }
        return student;
    }
}