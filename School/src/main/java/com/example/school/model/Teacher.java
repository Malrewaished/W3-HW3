package com.example.school.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data
@NoArgsConstructor @Entity
public class Teacher {

    @Id
    @NotNull (message = "ID should not empty")
    private Integer ID;


    @NotEmpty (message = "Name should not empty")
    private String name;



    @NotNull (message = "Salary should not empty")
    private Integer salary;
}
