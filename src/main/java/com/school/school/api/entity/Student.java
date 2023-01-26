package com.school.school.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@Entity
@Table
@EnableAutoConfiguration

public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student() {
    }
}
