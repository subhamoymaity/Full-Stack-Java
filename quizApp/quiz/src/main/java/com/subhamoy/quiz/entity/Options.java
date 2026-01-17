/*
package com.subhamoy.quiz.entity;

import jakarta.persistence.*;

@Entity
public class Options {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long optionId;
   private String optionText;
@ManyToOne
@JoinColumn(name = "question_id",nullable = false)
   private Question question;

   public Long getOptionId() {
      return optionId;
   }

   public void setOptionId(Long optionId) {
      this.optionId = optionId;
   }

   public Question getQuestion() {
      return question;
   }

   public void setQuestion(Question question) {
      this.question = question;
   }

   public String getOptionText() {
      return optionText;
   }

   public void setOptionText(String optionText) {
      this.optionText = optionText;
   }
}
if you mapping
 */