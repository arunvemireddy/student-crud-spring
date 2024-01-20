package com.example.student.dao;

import java.util.List;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_DAO extends JpaRepository<Student,Integer> {
	

    @Query(value = "SELECT * FROM STUDENT",nativeQuery = true)
    public List<Student> getStudents(int id);

}
