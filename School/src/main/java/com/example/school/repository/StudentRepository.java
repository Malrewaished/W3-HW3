package com.example.school.repository;
import com.example.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentByID(Integer ID);

    Student findStudentByName(String name);


    List<Student> findAllByMajor(String major);

    List<Student> findByAgeGreaterThanEqual(Integer age);

}



