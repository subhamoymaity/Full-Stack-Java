package Spark2_0.exception;

public class ExceptionDmeo3 {

   public static void main(String[] args) {
      int arr[]=new int[5];
      for(int i=0;i<arr.length;i++)
      {
         arr[i]=i;
      }
      try {
         int res=arr[1];
         System.out.println(10/0);
         //throw new ArithmeticException("Request fail due tech error"); // JVM throughs
      }
      /*  catch (ArithmeticException e)
        {
            System.out.println("ArithmeticException");
            System.out.println(e.getMessage());
        }*/
      catch (ArrayIndexOutOfBoundsException e)
      {
         System.out.println("ArrayIndexOutOfBoundsException");
         System.out.println(e.getMessage());
      }
       /* catch (Exception e)  //when we use "try with multiple catch" -- at first use child then 'Exception'
        {
            System.out.println("i am in catch");
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }*/

   }
}
