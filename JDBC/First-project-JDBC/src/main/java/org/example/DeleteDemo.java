
package org.example;


       import java.sql.Connection;

       import java.sql.DriverManager;
       import java.sql.ResultSet;
       import java.sql.Statement;

/**
 * Unit test for simple App.
 */
public class DeleteDemo{
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
         String query = "delete from student3 where rollno =106";
         int  rowAffected = statement.executeUpdate(query);
         System.out.println(" row affected "+rowAffected);


         connection.close();
      }
      catch(Exception e){
         e.printStackTrace();
      }
   }
}