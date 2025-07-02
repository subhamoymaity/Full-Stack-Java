package Spark2_0.singletone;

public class EagerSingleton {
   // Step 1: Private static instance
   private static EagerSingleton INSTANCE = new EagerSingleton();

   // Step 2: Private constructor to prevent external object creation
   private EagerSingleton() {
      System.out.println("Singleton instance created!");
   }

   // Step 3: Public method to return the single instance
   public static EagerSingleton getInstance() {
      return INSTANCE;
   }
}

/*
🧠 private static EagerSingleton INSTANCE = new EagerSingleton();
static means the variable belongs to the class, not to any object.
So you can call:  EagerSingleton.getInstance();  // ✅ without creating an object


🧠private EagerSingleton() {}
❌ No one can use new EagerSingleton() from outside the class.
✅ Ensures that only the class itself can create the object — enforcing singleton behavior.


🧠 public static EagerSingleton getInstance()
public: It means this method is accessible from anywhere in your project.
static: This allows you to call the method without creating an object of EagerSingleton.
 */