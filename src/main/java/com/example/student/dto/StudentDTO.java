package com.example.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDTO {

    @NotNull(message = "student name cannot be empty")
    @NotBlank(message = "student name cannot be empty")
    private String name;
    @Email(message = "email is invalid")
    private String email;
    @NotNull(message = "student branch cannot be empty")
    @NotBlank(message = "student branch cannot be empty")
    private String branch;
}
