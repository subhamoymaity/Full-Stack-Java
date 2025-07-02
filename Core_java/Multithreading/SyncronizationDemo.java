package Spark2_0.Multithreading;

class SavingAccount{
   public synchronized void withdraw(String name) throws InterruptedException {
      for (int i = 0; i < 5; i++) {
         System.out.print("Money withdrawing = ");
         try{
            Thread.sleep(2000);
         }catch (Exception e){
            System.out.println(e.getMessage());
         }
         System.out.println(name);
      }
      System.out.println("****************Transaction completed**************");
   }
}
class MyThreadAccount extends Thread{
   SavingAccount s;
   String name;
   MyThreadAccount( SavingAccount s,String name){
      this.s=s;
      this.name=name;
   }

   @Override
   public void run() {
      try {
         s.withdraw(name);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}

public class SyncronizationDemo {

   public static void main(String[] args) {
      SavingAccount savingAccount=new SavingAccount();
      MyThreadAccount t1=new MyThreadAccount(savingAccount,"pati");
      MyThreadAccount t2=new MyThreadAccount(savingAccount,"bivi");
      t1.start();
      t2.start();

   }
}
