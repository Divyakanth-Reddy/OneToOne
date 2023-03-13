package com.example.OneToOne.repo;

import com.example.OneToOne.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   // It is indeed not necessary to put the @Repository annotation on interfaces that extend JpaRepository ,
// Spring recognizes the repositories by the fact that they extend one of the predefined Repository interfaces
public interface StudentRepo extends JpaRepository<Student , Long> {
}
