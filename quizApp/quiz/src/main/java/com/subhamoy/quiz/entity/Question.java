/*
package com.subhamoy.quiz.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
   @Id
   private Long questionId;
   private  String questionText;
   private String correctAnswer;
   @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   private List<Options> options;

   public Long getQuestionId() {
      return questionId;
   }

   public void setQuestionId(Long questionId) {
      this.questionId = questionId;
   }

   public String getQuestionText() {
      return questionText;
   }

   public void setQuestionText(String questionText) {
      this.questionText = questionText;
   }

   public String getCorrectAnswer() {
      return correctAnswer;
   }

   public void setCorrectAnswer(String correctAnswer) {
      this.correctAnswer = correctAnswer;
   }

   public List<Options> getOptions() {
      return options;
   }

   public void setOptions(List<Options> options) {
      this.options = options;
      for(Options op:options){
         op.setQuestion(this);
      }
   }
}
*/