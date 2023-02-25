package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Student;
import com.repository.StudentRepository;

@RestController
public class StudentController 
{
    @Autowired
    StudentRepository sr;
    
    @PostMapping("/insertstudent")
    public String saveStudent(@RequestBody Student s) {
    	sr.save(s);
    	return "Student Saved!!";
    	
    }
    
    @PostMapping("/updatestudent")
    public String updateStudent(@RequestBody Student s) {
    	sr.save(s);
    	return "Student Updated!!";
    	
    }
    
    @GetMapping("/getstudent")
    public Student getStudent(@RequestParam int id) {
    	Optional<Student> os = sr.findById(id);
    	return os.get();   	
    }
    
    @DeleteMapping("/deletestudent")
    public String deleteStudent(@RequestParam int id) {
    	sr.deleteById(id);
    	return "Student Deleted!!";
    }
    
    
}
