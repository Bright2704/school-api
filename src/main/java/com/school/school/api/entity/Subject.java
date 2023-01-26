package com.school.school.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@Entity
@Table
@EnableAutoConfiguration
public class Subject {
    @Id
    @GeneratedValue
    private Long id;


    public Subject() {
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teachers_id")
    private Teacher teachers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "students_id")
    private Student students;
}
