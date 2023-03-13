package com.example.OneToOne.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_marks")
public class StudentMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String science ;
    private String maths ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public String getMaths() {
        return maths;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public StudentMarks(){

    }

    public StudentMarks(String science, String maths) {
        this.science = science;
        this.maths = maths;
    }

}
