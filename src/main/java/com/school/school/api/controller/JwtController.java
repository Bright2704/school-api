package com.school.school.api.controller;

import com.school.school.api.entity.School;
import com.school.school.api.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class JwtController {
    private final SchoolService schoolService;

    public JwtController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<School> findSchoolById(@PathVariable long id){
        return schoolService.findSchoolbyId(id);
    }
}
