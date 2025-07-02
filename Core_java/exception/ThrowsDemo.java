package Spark2_0.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ThrowTest
{
   void m1() throws IOException {
      m2();
   }
   void m2() throws IOException    //throws give his responsibilities to his caller method
   {

      BufferedReader reader = new BufferedReader(new FileReader(":D/"));
   }
}
public class ThrowsDemo {
   public static void main(String[] args) throws IOException {
      //throws give his responsibilities to defaultExceptionalHandler
      ThrowTest test=new ThrowTest();
      test.m1();
   }
}
