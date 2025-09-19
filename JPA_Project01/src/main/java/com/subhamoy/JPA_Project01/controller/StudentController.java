package com.subhamoy.JPA_Project01.controller;

import com.subhamoy.JPA_Project01.entity.Student;
import com.subhamoy.JPA_Project01.repo.StudentRepo;
import com.subhamoy.JPA_Project01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/std")
public class StudentController {
   @Autowired
   private StudentService service;

   //1st API
   @PostMapping("/save")
   private Student createStudent(@RequestBody Student student){
      // From postman(clint) coming the json data that automatically converting in object
      return service.saveStudent(student);
      //saving in DB
   }

   //2nd API
   @GetMapping("/all")
   public List<Student> getAllStudents(){
      List<Student> allStudentData = service.getAllStudentData();
      return allStudentData;
   }

   //3rd API
//   @GetMapping("/{id}")
//   public Student getStudentById(@PathVariable Integer id) {
//      return service.getStudentById(id);
//   }

   @GetMapping
   public Student getStudentById(@RequestParam Integer id) {
      return service.getStudentById(id);
   }

   @PutMapping("/{id}")
   public  Student updateStudent(@PathVariable Integer id , @RequestBody Student student){
      Student updateStudent = service.updateStudent(id, student);
      return  updateStudent;
   }

//   Homework - @DeleteMapping , @PatchMapping
   // How to write custom query in JPA
}
