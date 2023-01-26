package com.school.school.api.controller;

import com.school.school.api.entity.School;
import com.school.school.api.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/school")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @GetMapping
    public List<School> getShools(){
        return  this.schoolService.getSchool();
    }

    @PostMapping
    public void addSchools(@RequestBody School school){schoolService.addSchool(school);}

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<School> findSchoolbyId(@PathVariable long id){
        return schoolService.findSchoolbyId(id);
    }

    @PutMapping
    @ResponseBody
    public Optional<School> updateSchoolbyId(@RequestBody School schools){
        return Optional.ofNullable(schoolService.updateSchoolbyId(schools));
    }
}
