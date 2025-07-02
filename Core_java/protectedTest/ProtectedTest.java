package Spark2_0.protectedTest;

import Spark2_0.Modifiers.ModifierProtected;
import Spark2_0.Modifiers.ModifierPublic;

public class ProtectedTest extends ModifierProtected {

   public static void main(String[] args) {
      ProtectedTest protectedTest=new ProtectedTest();
      System.out.println(protectedTest.name);
      protectedTest.display();

      ModifierPublic modifierPublic=new ModifierPublic();
      modifierPublic.display();
   }
}
