package com.example.school.controller;
import com.example.school.dto.Api;
import com.example.school.model.Teacher;
import com.example.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List> getTeacher(){
        List<Teacher> teachers = teacherService.getTeacher();
        return ResponseEntity.status(200).body(teachers);
    }

    @PostMapping
    public ResponseEntity<Api> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new Api("New teacher added !", 201));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Api> updateTeacher(@RequestBody @Valid Teacher teacher,@PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(201).body(new Api("Teacher data updated !",201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Api> deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(201).body(new Api("Teacher deleted !",201));
    }

    @GetMapping("/{id}")
    public ResponseEntity getTeacherByID(@PathVariable Integer id){
        return ResponseEntity.status(200).body (teacherService.getTeacherByID(id));
    }

    @GetMapping("/salary")
    public ResponseEntity getAllTeacherBySalary(@RequestParam Integer salary){
        return ResponseEntity.status(200).body (teacherService.getAllTeacherBySalary(salary));
    }
}