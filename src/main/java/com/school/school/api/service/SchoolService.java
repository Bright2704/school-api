package com.school.school.api.service;

import com.school.school.api.Repository.SchoolRepository;
import com.school.school.api.entity.School;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    public final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    public List<School> getSchool(){return this.schoolRepository.findAll();}
    public void addSchool(School school){schoolRepository.save(school);}


    public Optional<School> findSchoolbyId(long id) {
        return schoolRepository.findSchoolsById(id);
    }

    public School updateSchoolbyId(School school) {
        Optional<School> optionalSchool = schoolRepository.findById(school.getId());
        if (!optionalSchool.isPresent()) {
            throw new IllegalArgumentException("School with id " + school.getId() + " not found");
        }
        School existingSchool = optionalSchool.get();
        existingSchool.setSubject(school.getSubject());
        existingSchool.setName(school.getName());

        return schoolRepository.save(existingSchool);
    }
}

//    public Optional<School> updateSchoolbyId(School school) {
//        Optional<School> optionalSchool = schoolRepository.findSchoolsById(school.getId());
//        School exittingSchool = optionalSchool.get();
//        exittingSchool.setSubject(school.getSubject());
//        exittingSchool.setName(school.getName());
//
//        return  optionalSchool;
//    }
//}
