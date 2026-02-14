package com.example.student.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private int student_id;
    @NotNull(message = "student name cannot be empty")
    @NotBlank(message = "student name cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String student_name;
    @Email(message = "email is invalid")
    private String student_email;
    @NotNull(message = "student branch cannot be empty")
    @NotBlank(message = "student branch cannot be empty")
    private String student_branch;
}
