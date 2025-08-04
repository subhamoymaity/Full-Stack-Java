package com.subhamoy.JPA_Project01.repo;


import com.subhamoy.JPA_Project01.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
//   List<Student> findByName(String name);
//   List<Student> findByAgeGreaterThan(int age);

}
