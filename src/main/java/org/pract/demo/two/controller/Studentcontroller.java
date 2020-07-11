package org.pract.demo.two.controller;

import org.pract.demo.two.redis.entity.Student;
import org.pract.demo.two.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/student")
public class Studentcontroller {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") String id){
        return studentRepository.findById( id ).orElse(new Student());
    }

    @PostMapping("/add")
    public Student addStudent(@Valid Student student, BindingResult result){
        if( result.hasErrors() ){
            return new Student();
        }
        return studentRepository.save( student );
    }

}
