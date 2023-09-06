package com.school.school.api.controller;

import com.school.school.api.entity.School;
import com.school.school.api.entity.Subject;
import com.school.school.api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/school")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<School> getSchools(){
        return  this.schoolService.getSchool();
    }

    @PostMapping
    public void addSchools(@RequestBody School school){schoolService.addSchool(school);}

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<School> findSchoolById(@PathVariable long id){
        return schoolService.findSchoolbyId(id);
    }

    @GetMapping("/findSchool")
    @ResponseBody
    public Optional<School> schoolFindbyId(@RequestParam(name = "id") long id){
        System.out.println("Hello Get Controller");
        return schoolService.findSchoolbyId(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public Optional<School> updateSchoolbyId(@RequestBody School schools){
        return Optional.ofNullable(schoolService.updateSchoolbyId(schools));
    }
}
