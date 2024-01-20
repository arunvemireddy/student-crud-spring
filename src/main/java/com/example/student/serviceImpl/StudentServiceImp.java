package com.example.serviceImpl;

import com.example.student.dao.Student_DAO;
import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import com.example.student.service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
//@Transactional
public class Student_Service_Imp implements Student_Service {


    @Autowired
    private Student_DAO studentdao;

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudent_name(studentDTO.getName());
        student.setStudent_email(studentDTO.getEmail());
        student.setStudent_branch(studentDTO.getBranch());
        return studentdao.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }

    @Override
    public boolean deleteStudent(Student student) {
        return false;
    }

    @Override
    public List<Student> getStudentByID(Student student) {
        return null;
    }

    @Override
    public boolean updateStudent(Student student) {
        return false;
    }


}
