package com.school.school.api.controller;

import com.school.school.api.entity.Teacher;
import com.school.school.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeacher(){
        return teacherService.getTeacher();
    }
    @PostMapping
    public void registerNewTeacher(@RequestBody Teacher teacher){
        System.out.println(teacher);
        teacherService.addNewTeacher(teacher);
    }
}
