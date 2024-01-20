package com.example.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue
            (strategy = GenerationType.IDENTITY)
    private int student_id;
    private String student_name;
    private String student_email;
    private String student_branch;


}
