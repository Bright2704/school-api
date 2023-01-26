package com.school.school.api.service;

import com.school.school.api.Repository.StudentRepository;
import com.school.school.api.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){return this.studentRepository.findAll();}

    public void addNewStudent(Student student){
        studentRepository.save(student);

    }
}
