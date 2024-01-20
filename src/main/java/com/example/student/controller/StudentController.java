package com.example.student.controller;


import com.example.student.constants.StudentConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@CrossOrigin(origins="*")
@RequestMapping(path="/api")
public class Controller {

//    @Autowired
//    private Student_Service studentservice;


    @GetMapping(path = "/studentApp")
    public ResponseEntity<?> studentApp(){
        return new ResponseEntity<>(StudentConstant.studentApp, HttpStatus.OK);
    }
      
//    @PostMapping("save-student")
//    public boolean saveStudent(@RequestBody Student student) {
//         return studentservice.saveStudent(student);
//
//    }
//
//    @GetMapping("students-list")
//    public List<Student> allstudents() {
//         return studentservice.getStudents();
//
//    }
//
//    @DeleteMapping("delete-student/{student_id}")
//    public boolean deleteStudent(@PathVariable("student_id") int student_id,Student student) {
//        student.setStudent_id(student_id);
//        return studentservice.deleteStudent(student);
//    }
//
//    @GetMapping("student/{student_id}")
//    public List<Student> allstudentByID(@PathVariable("student_id") int student_id,Student student) {
//         student.setStudent_id(student_id);
//         return studentservice.getStudentByID(student);
//
//    }
//
//    @PostMapping("update-student/{student_id}")
//    public boolean updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id) {
//        student.setStudent_id(student_id);
//        return studentservice.updateStudent(student);
//    }
}
