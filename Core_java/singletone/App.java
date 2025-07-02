package Spark2_0.singletone;


public class App {
   public static void main(String[] args) {
      LazySingleton obj1 = LazySingleton.getInstance();
      LazySingleton obj2 = LazySingleton.getInstance();

      System.out.println(obj1 == obj2);  // ✅ true (same object)
   }
}
