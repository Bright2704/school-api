package com.school.school.api.controller;

import com.school.school.api.entity.Student;
import com.school.school.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){this.studentService = studentService;}

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudent();
    }


    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
        studentService.addNewStudent(student);
    }
}
