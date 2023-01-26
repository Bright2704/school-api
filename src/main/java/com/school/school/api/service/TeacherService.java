package com.school.school.api.service;

import com.school.school.api.Repository.TeacherRepository;
import com.school.school.api.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    public final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository=teacherRepository;
    }

    public List<Teacher> getTeacher(){return this.teacherRepository.findAll();}

    public void addNewTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }
}
