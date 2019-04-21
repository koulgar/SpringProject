package com.koulgar.controller;

import com.koulgar.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students = new ArrayList<>();

    @PostConstruct
    public void loadData(){
    students.add(new Student("John","Doe"));
    students.add(new Student("Mario","Rossi"));
    students.add(new Student("Mary","Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudentList(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId>=students.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found... " + studentId);
        }
        return students.get(studentId);
    }
}
