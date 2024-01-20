package com.example.student.service;

import java.util.List;

import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;


public interface StudentService {

    public Student saveStudent(StudentDTO studentDTO);
    public Student updateStudent(StudentDTO studentDTO, int id);
    public String deleteStudent(int id);
    public List<Student> getAllStudents();
    public Student getStudentByID(int id);

}
