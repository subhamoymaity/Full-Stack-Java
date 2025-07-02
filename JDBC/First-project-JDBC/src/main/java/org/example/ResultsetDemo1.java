package org.example;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Unit test for simple App.
 */
public class ResultsetDemo1{
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

         // create Statement
         Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE
         );

         // create query
         String query = "select * from student3";
         ResultSet resultSet = statement.executeQuery(query);

         while(resultSet.next()){
//            System.in.read();
//            resultSet.refreshRow();
            Thread.sleep(1000);
            System.out.println(resultSet.getInt("rollno")+"   "+
                                      resultSet.getString("name")+"   "+
                                      resultSet.getString("marks")+ "    "+
                                      resultSet.getString("grade")+ "    "+
                                      resultSet.getString("city")+ "    "
            );
         }

         connection.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}
