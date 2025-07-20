package org.example;


import javax.management.Query;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {
   public static String LOAD_DRIVER = "com.mysql.cj.jdbc.Driver";
   public static String URL = "jdbc:mysql://localhost:3306/college2";
   public static String USERNAME = "root";
   public static String PASSWORD = "SubhamoyMySQL@600";

   public static void main(String[] args) {
      try {
         // load Driver
         Class.forName(LOAD_DRIVER);
         System.out.println("MySQL JDBC Driver Loaded!");

         // Making connection
         Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         System.out.println("Connected to MySQL database!");

         // create Statement
         Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE
         );

         // create query
         String query = "select * from student3";
         ResultSet resultSet = statement.executeQuery(query);

         while (resultSet.next()) {
            int rollno = resultSet.getInt("rollno");
            String name = resultSet.getString("name");
            int marks = resultSet.getInt("marks");
            String grade = resultSet.getString("grade");
            String city = resultSet.getString("city");

            System.out.println("Roll " + rollno + "  Name " + name + "  Marks " + marks + "  Grade " + grade + "  City " + city);
         }

         resultSet.last();
         System.out.println("Fetching the last row");
         System.out.println("ID " + resultSet.getInt("rollno"));
         System.out.println("Name " + resultSet.getString("name"));

         resultSet.first();
         System.out.println("Fetching the first row");
         System.out.println("ID " + resultSet.getInt("rollno"));
         System.out.println("Name " + resultSet.getString("name"));

         resultSet.updateString("name", "Akash");
         resultSet.updateRow();

         resultSet.moveToInsertRow();
         resultSet.updateInt("rollno", 109);
         resultSet.updateString("name", "Rahul");
         resultSet.updateInt("marks", 90);
         resultSet.updateString("grade", "A");
         resultSet.updateString("city", "Kolkata");
         resultSet.insertRow();


         while (resultSet.next()) {
            if (resultSet.getInt("rollno") == 109) {
               resultSet.deleteRow();
               System.out.println("Row deleted successfully!");
               break;
            }
         }


         connection.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
