package org.example;

public class Student {
   private  String name;
   private String city;
   private String course;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getCourse() {
      return course;
   }

   public void setCourse(String course) {
      this.course = course;
   }

   @Override
   public String toString() {
      return "Student{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    ", course='" + course + '\'' +
                    '}';
   }
}
