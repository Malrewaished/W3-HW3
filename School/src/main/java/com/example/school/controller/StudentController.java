package com.example.school.controller;
import com.example.school.dto.Api;
import com.example.school.model.Student;
import com.example.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List> getStudents(){
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<Api> addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(201).body(new Api("New student added !", 201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Api> updateStudent(@RequestBody @Valid Student student , @PathVariable Integer id){
        studentService.updateStudent(student,id);
        return ResponseEntity.status(201).body(new Api("Student data updated !",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Api> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(201).body(new Api("Student deleted !",201));
    }

    @GetMapping("/{id}")
    public ResponseEntity findStudentByID(@PathVariable Integer id ){
        return ResponseEntity.status(200).body(studentService.findStudentByID(id));
    }

    @GetMapping("/name")
    public ResponseEntity findStudentByName(@RequestParam String name ){
        return ResponseEntity.status(200).body(studentService.findStudentByName(name));
    }

    @GetMapping("/major")
    public ResponseEntity findAllByMajor(@RequestParam String major ){
        return ResponseEntity.status(200).body(studentService.findMajorOfStudents(major));
    }

    @GetMapping("/age")
    public ResponseEntity findAllByAge(@RequestParam Integer age ){
        return ResponseEntity.status(200).body(studentService.findByAge(age));
    }

}
