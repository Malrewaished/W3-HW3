package com.example.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Student {

    @Id
    @NotNull(message = "ID should not empty")
    private Integer ID;


    @NotEmpty (message = "Name should not empty")
    private String name;


    @NotNull (message = "Age should not empty")
    private Integer age;

    @NotEmpty(message = "Major cannot be empty")
    @Column(columnDefinition = "varchar(8) check (major='CS' or major='MATH' or major='Engineer') ")
    private String major;


    }
