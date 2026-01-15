package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDetails {
   public  static final String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
   public  static final String URL="jdbc:mysql://localhost:3306/truckmgt";
   public  static final String USERNAME="root";
   public  static final String PASSWORD="SubhamoyMySQL@600";

   public  static Connection getConnection() throws SQLException, ClassNotFoundException {
      Class.forName(LOAD_DRIVER);
      System.out.println("MySQL JDBC Driver Loaded!");
      System.out.println("Connected to MySQL database!");
      return DriverManager.getConnection(URL,USERNAME,PASSWORD);
   }
}
