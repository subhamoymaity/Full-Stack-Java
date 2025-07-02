package Spark2_0.singletone;

public class LazySingleton {
   // Step 1: Instance is not created yet
   private static LazySingleton INSTANCE=null;

   // Step 2: Private constructor
   private LazySingleton() {
      System.out.println("Singleton instance created lazily!");
   }

   // Step 3: Instance created only when method is called
   public static LazySingleton getInstance() {
      if (INSTANCE == null) {
         INSTANCE = new LazySingleton(); // Lazy initialization
      }
      return INSTANCE;
   }
}
