package com.example.student.serviceImpl;

import com.example.student.dao.StudentDAO;
import com.example.student.dto.StudentDTO;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
//@Transactional
public class StudentServiceImp implements StudentService {


    @Autowired
    private StudentDAO studentdao;

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudent_name(studentDTO.getName());
        student.setStudent_email(studentDTO.getEmail());
        student.setStudent_branch(studentDTO.getBranch());
        return studentdao.save(student);
    }

    @Override
    public Student updateStudent(StudentDTO studentDTO, int id) {
        Optional<Student> optionalStudent = studentdao.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setStudent_name(studentDTO.getName());
            student.setStudent_email(studentDTO.getEmail());
            student.setStudent_branch(studentDTO.getBranch());
            return studentdao.save(student);
        } else {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentdao.findAll();
    }

    @Override
    public String deleteStudent(int id) {
        studentdao.deleteById(id);
        return "deleted";
    }

    @Override
    public Student getStudentByID(int id) {
        Optional<Student> optionalStudent = studentdao.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new EntityNotFoundException("Student with id " + id + " not found");
        }
    }


}
