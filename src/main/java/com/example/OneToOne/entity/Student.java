package com.example.OneToOne.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "student ")
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;
    private String studentName ;
    private String studentEmail ;
    private String studentAddress ;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name= "student_marks_id")
    private StudentMarks studentMarks ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public StudentMarks getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(StudentMarks studentMarks) {
        this.studentMarks = studentMarks;
    }

    public Student(String studentName, String studentEmail, String studentAddress) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

    public Student(){

    }
}
