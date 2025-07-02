package com.subhamoy.JPA_Project01.service;

import com.subhamoy.JPA_Project01.entity.Student;
import com.subhamoy.JPA_Project01.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   @Autowired
   StudentRepo studentRepo;

   public Student saveStudent(Student student) {
      return studentRepo.save(student);
   }
   public List<Student> getAllStudentData(){
      List<Student> list = studentRepo.findAll();
      return  list;
   }
}