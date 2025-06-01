package com.example.student.controller;


import com.example.student.constants.StudentConstant;
import com.example.student.dto.StudentDTO;
import com.example.student.service.StudentService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController  
@CrossOrigin(origins="*")
@RequestMapping(path="api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "test")
    public String test(){
        log.info("invoked test method");
        return "Hello";
    }


    @GetMapping(path = "/studentApp")
    public ResponseEntity<?> studentApp(){
        return new ResponseEntity<>(StudentConstant.studentApp, HttpStatus.OK);
    }
    @PostMapping(path = "/saveStudent")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.saveStudent(studentDTO),HttpStatus.OK);
    }

    @PostMapping(path = "/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO, @PathParam("id") int id){
        return new ResponseEntity<>(studentService.updateStudent(studentDTO,id),HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteStudent")
    public ResponseEntity<?> deleteStudent(@PathParam("id") int id){
        return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.OK);
    }
      

    @GetMapping(path = "/getAllStudents")
    public ResponseEntity<?> getAllStudents() {
         return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping(path = "/getStudentByID")
    public ResponseEntity<?> getStudentByID(@PathParam("id") int id) {
        return new ResponseEntity<>(studentService.getStudentByID(id),HttpStatus.OK);
    }

}
