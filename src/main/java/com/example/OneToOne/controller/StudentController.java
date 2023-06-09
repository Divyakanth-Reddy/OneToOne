package com.example.OneToOne.controller;

import com.example.OneToOne.entity.Student;
import com.example.OneToOne.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/students")
    // this @RequestBody annotation helps to avoid when the data is empty and will make the field as mandatory
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<> (studentRepo.save(student), HttpStatus.CREATED );

    }

    @GetMapping("/students")
    public ResponseEntity <List<Student>> getStudents(){ // this method is going to return list of students
        return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK) ;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity <Student> getStudent(@PathVariable long id){ // this is how we get the id using path param which is path variable
        Optional<Student> student = studentRepo.findById(id) ;
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @PutMapping("/students/{id}")
    public ResponseEntity <Student> updateStudent(@PathVariable long id , @RequestBody Student stud){
        Optional<Student> student = studentRepo.findById(id) ;
        if (student.isPresent()) {
            student.get().setStudentName(stud.getStudentName());
            student.get().setStudentEmail(stud.getStudentEmail());
            student.get().setStudentAddress(stud.getStudentAddress());
            return new ResponseEntity<>(studentRepo.save(student.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity <Void> deleteStudent(@PathVariable long id ){
        Optional<Student> student = studentRepo.findById(id) ;
        if (student.isPresent()) {
            studentRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }
    }

}
