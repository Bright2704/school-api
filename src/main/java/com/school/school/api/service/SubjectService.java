package com.school.school.api.service;

import com.school.school.api.Repository.StudentRepository;
import com.school.school.api.Repository.SubjectRepository;
import com.school.school.api.Repository.TeacherRepository;
import com.school.school.api.entity.Student;
import com.school.school.api.entity.Subject;
import com.school.school.api.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    public final SubjectRepository subjectRepository;
    public final StudentRepository studentRepository;
    public final TeacherRepository teacherRepository;


    public SubjectService(SubjectRepository subjectRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Subject> getSubject(){
        return  this.subjectRepository.findAll();
    }
    public void addNewSubject(Subject subject){
        subjectRepository.save(subject);
    }

    public Optional<Subject> findSubjectById(Long id){

        return subjectRepository.findSubjectById(id);
    }
    public Optional<Subject> updateSubject(Subject subject){
        Optional<Subject> optionalSubject = subjectRepository.findSubjectById(subject.getId());
        Optional<Teacher> optionalTeachers = teacherRepository.findTeachersById(subject.getId());
        Optional<Student> optionalStudents = studentRepository.findStudentsById(subject.getId());
        Teacher exitingTeachers = optionalTeachers.get();
        Student exitingStudent = optionalStudents.get();
        Subject exitingSubject = optionalSubject.get();


        System.out.println(subject.getStudents());
        exitingSubject.setTeachers(exitingTeachers);
        exitingSubject.setStudents(exitingStudent);

        subjectRepository.save(exitingSubject);
        teacherRepository.save(exitingTeachers);
        studentRepository.save(exitingStudent);

        return null;
    }
}