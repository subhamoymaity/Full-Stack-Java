package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrepareStatementDemo{
   //    public  static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
   public  static String URL="jdbc:mysql://localhost:3306/college2";
   public  static String USERNAME="root";
   public  static String PASSWORD="SubhamoyMySQL@600";

   public static void main(String[] args) {
      try {
         // load Driver
//            Class.forName(LOAD_DRIVER);
         System.out.println("MySQL JDBC Driver Loaded!");

         // Making connection
         Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
         System.out.println("Connected to MySQL database!");

        /* String query = "delete from student3 where rollno =?";
         // create Statement
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         preparedStatement.setInt(1,106);
         int  rowAffected = preparedStatement.executeUpdate();
         System.out.println(" row affected "+rowAffected);
         */

         String insertQuery="INSERT INTO student3 (rollno, name, marks, grade, city) values(?,?,?,?,?)";
         PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
         preparedStatement.setInt(1,106);
         preparedStatement.setString(2,"Amit");
         preparedStatement.setInt(3,88);
         preparedStatement.setString(4,"A");
         preparedStatement.setString(5,"Kolkata");

         int rowAffected = preparedStatement.executeUpdate();
         System.out.println(" row affected "+rowAffected);

         connection.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}

//  Try Scanner in your own