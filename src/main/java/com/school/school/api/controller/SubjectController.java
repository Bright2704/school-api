package com.school.school.api.controller;

import com.school.school.api.entity.Subject;
import com.school.school.api.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<Subject> getSubject(){
        System.out.println("show all information");

        return subjectService.getSubject();
    }

    @PostMapping
    public void registerNewSubject(@RequestBody Subject subject){
        System.out.println(subject);
        subjectService.addNewSubject(subject);
    }
    @GetMapping("/findSubject")
    @ResponseBody
    public Optional<Subject> subjectFindbyId(@RequestParam(name = "id") long id){
        System.out.println("Hello Get Controller");
        return subjectService.findSubjectById(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public void updateSubject(@RequestParam Subject subject){
        subjectService.updateSubject(subject);
    }
}
