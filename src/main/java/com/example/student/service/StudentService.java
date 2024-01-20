package com.example.student.service;

import java.util.List;

import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import org.springframework.stereotype.Service;


public interface Student_Service {

    public Student saveStudent(StudentDTO studentDTO);
    public List<Student> getStudents();  
    public boolean deleteStudent(Student student);  
    public List<Student> getStudentByID(Student student);  
    public boolean updateStudent(Student student); 
}
