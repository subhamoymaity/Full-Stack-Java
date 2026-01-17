package com.subhamoy.quiz.controller;

import com.subhamoy.quiz.dto.LoginRequest;
import com.subhamoy.quiz.entity.QuizQuestion;
import com.subhamoy.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class LoginController {

   @Autowired
   private QuestionService questionService;

   // Simple hardcoded credentials for demo purposes
   private static final String USERNAME = "user";
   private static final String PASSWORD = "password";

   @PostMapping("/login")
   public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
      if (USERNAME.equals(loginRequest.getUsername()) && PASSWORD.equals(loginRequest.getPassword())) {
         return ResponseEntity.ok("Login Successful!");
      } else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
      }
   }

   @GetMapping("/questions")
   public ResponseEntity<List<QuizQuestion>> getQuestions() {
      List<QuizQuestion> questions = questionService.getAllQuestions();
      return ResponseEntity.ok(questions);
   }

   @PostMapping(value = "/questions", consumes = "application/json", produces = "application/json")
   public ResponseEntity<QuizQuestion> saveQuestion(@RequestBody QuizQuestion question) {
      QuizQuestion saved = questionService.saveQuestion(question);
      return ResponseEntity.status(HttpStatus.CREATED).body(saved);
   }
}