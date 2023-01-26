package com.school.school.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@Entity
@Table
@EnableAutoConfiguration
public class School {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
